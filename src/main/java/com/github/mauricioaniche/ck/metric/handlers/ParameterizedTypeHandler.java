package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.ParameterizedType;
import java.util.logging.Logger;

public class ParameterizedTypeHandler implements NodeHandler<ParameterizedType> {
    @Override
    public void handle(ParameterizedType node, CouplingCalculator couplingCalculator) {
        try {
            ITypeBinding binding = node.resolveBinding();
            if (binding != null) {
                couplingCalculator.coupleTo(binding);

                for (ITypeBinding types : binding.getTypeArguments()) {
                    couplingCalculator.coupleTo(types);
                }
            } else {
                couplingCalculator.coupleTo(node.getType());
            }
        } catch (NullPointerException e) {
            Logger.getLogger(ParameterizedTypeHandler.class.getName()).severe(e.getMessage());
        }
    }
}
