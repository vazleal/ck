package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.ThrowStatement;

public class ThrowStatementHandler implements NodeHandler<ThrowStatement> {
    @Override
    public void handle(ThrowStatement node, CouplingCalculator couplingCalculator) {
        if (node.getExpression() != null) {
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
        }
    }
}
