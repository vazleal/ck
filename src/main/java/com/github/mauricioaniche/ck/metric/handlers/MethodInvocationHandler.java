package com.github.mauricioaniche.ck.metric.handlers;

import com.github.mauricioaniche.ck.metric.CouplingCalculator;
import com.github.mauricioaniche.ck.metric.NodeHandler;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

public class MethodInvocationHandler implements NodeHandler<MethodInvocation> {
    @Override
    public void handle(MethodInvocation node, CouplingCalculator couplingCalculator) {
        IMethodBinding binding = node.resolveMethodBinding();
        if (binding != null) {
            couplingCalculator.coupleTo(binding.getDeclaringClass());
        }
    }
}
