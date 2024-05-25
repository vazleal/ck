package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.*;
import java.util.List;

public class TypeDeclarationHandler implements NodeHandler<TypeDeclaration> {
    @Override
    public void handle(TypeDeclaration node, CouplingCalculator couplingCalculator) {
        ITypeBinding resolvedType = node.resolveBinding();

        if (resolvedType != null) {
            ITypeBinding binding = resolvedType.getSuperclass();
            if (binding != null) {
                couplingCalculator.coupleTo(binding);
            }

            for (ITypeBinding interfaces : resolvedType.getInterfaces()) {
                couplingCalculator.coupleTo(interfaces);
            }
        } else {
            couplingCalculator.coupleTo(node.getSuperclassType());
            @SuppressWarnings("unchecked")
            List<Type> list = node.superInterfaceTypes();
            list.forEach(couplingCalculator::coupleTo);
        }
    }
}
