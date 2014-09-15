package org.evosuite.symbolic.expr;

import org.evosuite.symbolic.expr.bv.IntegerBinaryExpression;
import org.evosuite.symbolic.expr.bv.IntegerComparison;
import org.evosuite.symbolic.expr.bv.IntegerConstant;
import org.evosuite.symbolic.expr.bv.IntegerUnaryExpression;
import org.evosuite.symbolic.expr.bv.IntegerVariable;
import org.evosuite.symbolic.expr.bv.RealComparison;
import org.evosuite.symbolic.expr.bv.RealToIntegerCast;
import org.evosuite.symbolic.expr.bv.RealUnaryToIntegerExpression;
import org.evosuite.symbolic.expr.bv.StringBinaryComparison;
import org.evosuite.symbolic.expr.bv.StringBinaryToIntegerExpression;
import org.evosuite.symbolic.expr.bv.StringMultipleComparison;
import org.evosuite.symbolic.expr.bv.StringMultipleToIntegerExpression;
import org.evosuite.symbolic.expr.bv.StringToIntegerCast;
import org.evosuite.symbolic.expr.bv.StringUnaryToIntegerExpression;
import org.evosuite.symbolic.expr.fp.IntegerToRealCast;
import org.evosuite.symbolic.expr.fp.RealBinaryExpression;
import org.evosuite.symbolic.expr.fp.RealConstant;
import org.evosuite.symbolic.expr.fp.RealUnaryExpression;
import org.evosuite.symbolic.expr.fp.RealVariable;
import org.evosuite.symbolic.expr.reader.StringReaderExpr;
import org.evosuite.symbolic.expr.str.IntegerToStringCast;
import org.evosuite.symbolic.expr.str.RealToStringCast;
import org.evosuite.symbolic.expr.str.StringBinaryExpression;
import org.evosuite.symbolic.expr.str.StringConstant;
import org.evosuite.symbolic.expr.str.StringMultipleExpression;
import org.evosuite.symbolic.expr.str.StringUnaryExpression;
import org.evosuite.symbolic.expr.str.StringVariable;
import org.evosuite.symbolic.expr.token.HasMoreTokensExpr;
import org.evosuite.symbolic.expr.token.NewTokenizerExpr;
import org.evosuite.symbolic.expr.token.NextTokenizerExpr;
import org.evosuite.symbolic.expr.token.StringNextTokenExpr;

public interface ExpressionVisitor<K, V> {

	public K visit(IntegerBinaryExpression n, V arg);

	public K visit(IntegerComparison n, V arg);

	public K visit(IntegerConstant n, V arg);

	public K visit(IntegerUnaryExpression n, V arg);

	public K visit(IntegerVariable n, V arg);

	public K visit(RealComparison n, V arg);

	public K visit(RealToIntegerCast n, V arg);

	public K visit(RealUnaryToIntegerExpression n, V arg);

	public K visit(StringBinaryComparison n, V arg);

	public K visit(StringBinaryToIntegerExpression n, V arg);

	public K visit(StringMultipleComparison n, V arg);

	public K visit(StringMultipleToIntegerExpression n, V arg);

	public K visit(StringToIntegerCast n, V arg);

	public K visit(StringUnaryToIntegerExpression n, V arg);

	public K visit(IntegerToRealCast n, V arg);

	public K visit(RealBinaryExpression n, V arg);

	public K visit(RealConstant n, V arg);

	public K visit(RealUnaryExpression n, V arg);

	public K visit(RealVariable n, V arg);

	public K visit(StringReaderExpr n, V arg);

	public K visit(IntegerToStringCast n, V arg);

	public K visit(RealToStringCast n, V arg);

	public K visit(StringBinaryExpression n, V arg);

	public K visit(StringConstant n, V arg);

	public K visit(StringMultipleExpression n, V arg);

	public K visit(StringUnaryExpression n, V arg);

	public K visit(StringVariable n, V arg);

	public K visit(HasMoreTokensExpr n, V arg);

	public K visit(NewTokenizerExpr n, V arg);

	public K visit(NextTokenizerExpr n, V arg);

	public K visit(StringNextTokenExpr n, V arg);

}