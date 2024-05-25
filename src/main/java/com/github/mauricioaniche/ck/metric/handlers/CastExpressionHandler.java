package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.CastExpression;

public class CastExpressionHandler implements NodeHandler<CastExpression> {
    @Override
    public void handle(CastExpression node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getType());
    }
}
