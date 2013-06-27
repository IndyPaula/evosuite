package org.evosuite.continuous.job;

import java.util.List;

import org.evosuite.continuous.job.schedule.BudgetAndSeedingSchedule;
import org.evosuite.continuous.job.schedule.BudgetSchedule;
import org.evosuite.continuous.job.schedule.ScheduleType;
import org.evosuite.continuous.job.schedule.SeedingSchedule;
import org.evosuite.continuous.job.schedule.SimpleSchedule;
import org.evosuite.continuous.persistency.StorageManager;
import org.evosuite.continuous.project.ProjectStaticData;

/**
 * Class used to define which classes should be used as CUT for this CTG execution,
 * and how to allocate the search budget
 * 
 * @author arcuri
 *
 */
public class JobScheduler {
	
	/**
	 * The types of schedules that can be used
	 * @author arcuri
	 *
	 */
	public enum AvailableSchedule {SIMPLE,BUDGET,SEEDING,BUDGET_AND_SEEDING}; 
	
	private final ProjectStaticData projectData;
	private final StorageManager storageManager;
	private final int numberOfCores;
	private final int totalBudgetInMinutes;
	private final int totalMemoryInMB;
	
	private ScheduleType currentSchedule; 
	

	
	public JobScheduler(ProjectStaticData projectData,
			StorageManager storageManager, int numberOfCores,
			int totalMemoryInMB, int totalBudgetInMinutes) {
		super();
		this.projectData = projectData;
		this.storageManager = storageManager;
		this.numberOfCores = numberOfCores;
		this.totalMemoryInMB = totalMemoryInMB;
		this.totalBudgetInMinutes = totalBudgetInMinutes;
		
		/*
		 * TODO: default one should be the best found in the experiments, likely BUDGET_AND_SEEDING
		 */
		chooseScheduleType(AvailableSchedule.SIMPLE);
	}
	
	public void chooseScheduleType(AvailableSchedule schedule) throws IllegalArgumentException{

		switch(schedule){
			case SIMPLE:
				currentSchedule = new SimpleSchedule(this);
				break;
			case BUDGET:
				currentSchedule = new BudgetSchedule(this);
				break;
			case SEEDING:
				currentSchedule = new SeedingSchedule(this);
				break;
			case BUDGET_AND_SEEDING:
				currentSchedule = new BudgetAndSeedingSchedule(this);
				break;
			default:
				throw new IllegalArgumentException("Schedule '"+schedule+"' is not supported");				
		}
	}

	/**
	 * Return new schedule, or <code>null</code> if scheduling is finished
	 * @return
	 */
	public List<JobDefinition> createNewSchedule(){
		if(!canExecuteMore()){
			return null;
		}
		return currentSchedule.createNewSchedule();
	}
	

	
	/**
	 * When we get a schedule, the scheduler might decide to do not use the entire
	 * budget. Reason? It might decide to generate some test cases first, and then 
	 * use those as seeding for a new round of execution
	 * 
	 * @return
	 */
	public boolean canExecuteMore(){
		return currentSchedule.canExecuteMore();
	}

	public ProjectStaticData getProjectData() {
		return projectData;
	}

	public StorageManager getStorageManager() {
		return storageManager;
	}
	
	public int getNumberOfCores() {
		return numberOfCores;
	}

	public int getTotalBudgetInMinutes() {
		return totalBudgetInMinutes;
	}

	public int getTotalMemoryInMB() {
		return totalMemoryInMB;
	}	
}