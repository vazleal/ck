package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.InstanceofExpression;

public class InstanceofExpressionHandler implements NodeHandler<InstanceofExpression> {
    @Override
    public void handle(InstanceofExpression node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getRightOperand());
        couplingCalculator.coupleTo(node.getLeftOperand().resolveTypeBinding());
    }
}
