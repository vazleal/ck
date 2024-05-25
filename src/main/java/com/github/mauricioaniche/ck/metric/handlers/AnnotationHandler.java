package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ITypeBinding;

public class AnnotationHandler implements NodeHandler<Annotation> {
    @Override
    public void handle(Annotation node, CouplingCalculator couplingCalculator) {
        ITypeBinding resolvedType = node.resolveTypeBinding();
        if (resolvedType != null) {
            couplingCalculator.coupleTo(resolvedType);
        } else {
            couplingCalculator.addToSet(node.getTypeName().getFullyQualifiedName());
        }
    }
}
