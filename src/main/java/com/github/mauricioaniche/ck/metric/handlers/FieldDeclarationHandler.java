package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.FieldDeclaration;

public class FieldDeclarationHandler implements NodeHandler<FieldDeclaration> {
    @Override
    public void handle(FieldDeclaration node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getType());
    }
}
