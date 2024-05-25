package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.*;
import java.util.List;

public class MethodDeclarationHandler implements NodeHandler<MethodDeclaration> {
    @Override
    public void handle(MethodDeclaration node, CouplingCalculator couplingCalculator) {
        IMethodBinding resolvedMethod = node.resolveBinding();
        if (resolvedMethod != null) {
            couplingCalculator.coupleTo(resolvedMethod.getReturnType());
            for (ITypeBinding param : resolvedMethod.getParameterTypes()) {
                couplingCalculator.coupleTo(param);
            }
        } else {
            couplingCalculator.coupleTo(node.getReturnType2());
            @SuppressWarnings("unchecked")
            List<TypeParameter> list = node.typeParameters();
            list.forEach(x -> couplingCalculator.coupleTo(x.getName()));
        }
    }
}
