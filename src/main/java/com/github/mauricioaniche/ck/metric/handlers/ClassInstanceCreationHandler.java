package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;

public class ClassInstanceCreationHandler implements NodeHandler<ClassInstanceCreation> {
    @Override
    public void handle(ClassInstanceCreation node, CouplingCalculator couplingCalculator) {
        couplingCalculator.coupleTo(node.getType());
    }
}
