package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.ReturnStatement;

public class ReturnStatementHandler implements NodeHandler<ReturnStatement> {
    @Override
    public void handle(ReturnStatement node, CouplingCalculator couplingCalculator) {
        if (node.getExpression() != null) {
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
        }
    }
}
