package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.TypeLiteral;

public class TypeLiteralHandler implements NodeHandler<TypeLiteral> {
    @Override
    public void handle(TypeLiteral node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getType());
    }
}
