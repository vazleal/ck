package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTNode;

public interface NodeHandler<T extends ASTNode> {
    void handle(T node, CouplingCalculator couplingCalculator);
}
