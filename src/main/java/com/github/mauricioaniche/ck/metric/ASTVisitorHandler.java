package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.*;

import com.github.mauricioaniche.ck.metric.handlers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ASTVisitorHandler {
    private static final Logger logger = Logger.getLogger(ASTVisitorHandler.class.getName());
    private final CouplingCalculator couplingCalculator;
    private final Map<Class<? extends ASTNode>, NodeHandler<? extends ASTNode>> handlers;

    public ASTVisitorHandler(CouplingCalculator couplingCalculator) {
        this.couplingCalculator = couplingCalculator;
        this.handlers = new HashMap<>();
        initializeHandlers();
    }

    private void initializeHandlers() {
        handlers.put(VariableDeclarationStatement.class, new VariableDeclarationStatementHandler());
        handlers.put(ClassInstanceCreation.class, new ClassInstanceCreationHandler());
        handlers.put(ArrayCreation.class, new ArrayCreationHandler());
        handlers.put(FieldDeclaration.class, new FieldDeclarationHandler());
        handlers.put(ReturnStatement.class, new ReturnStatementHandler());
        handlers.put(TypeLiteral.class, new TypeLiteralHandler());
        handlers.put(ThrowStatement.class, new ThrowStatementHandler());
        handlers.put(TypeDeclaration.class, new TypeDeclarationHandler());
        handlers.put(MethodDeclaration.class, new MethodDeclarationHandler());
        handlers.put(CastExpression.class, new CastExpressionHandler());
        handlers.put(InstanceofExpression.class, new InstanceofExpressionHandler());
        handlers.put(MethodInvocation.class, new MethodInvocationHandler());
        handlers.put(NormalAnnotation.class, new AnnotationHandler());
        handlers.put(MarkerAnnotation.class, new AnnotationHandler());
        handlers.put(SingleMemberAnnotation.class, new AnnotationHandler());
        handlers.put(ParameterizedType.class, new ParameterizedTypeHandler());
    }

    public void handleVisit(ASTNode node) {
        NodeHandler handler = handlers.get(node.getClass());
        if (handler != null) {
            handler.handle(node, couplingCalculator);
        } else {
            logger.warning("No handler found for node type: " + node.getClass().getName());
        }
    }
}
