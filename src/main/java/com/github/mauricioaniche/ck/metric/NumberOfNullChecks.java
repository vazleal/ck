package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;


public class NumberOfNullChecks implements CKASTVisitor, ClassLevelMetric, MethodLevelMetric {

	private int nullCheckQty;
	
	@Override
	public void visit(InfixExpression node) {
		Expression left = node.getLeftOperand();
		Expression right = node.getRightOperand();

		if (!(left instanceof InfixExpression && !(right instanceof InfixExpression))) {
			Operator o = node.getOperator();

			if (o == Operator.EQUALS || o == Operator.NOT_EQUALS) {
				if(left instanceof NullLiteral || right instanceof NullLiteral) {
					nullCheckQty++;
				}
			}
		}
	}
	
	@Override
	public void setResult(CKMethodResult result) {
		result.setNullCheckQty(nullCheckQty);

	}

	@Override
	public void setResult(CKClassResult result) {
		result.setNullCheckQty(nullCheckQty);
	}
}
