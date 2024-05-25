package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class VariableDeclarationStatementHandler implements NodeHandler<VariableDeclarationStatement> {
    @Override
    public void handle(VariableDeclarationStatement node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getType());
    }
}
