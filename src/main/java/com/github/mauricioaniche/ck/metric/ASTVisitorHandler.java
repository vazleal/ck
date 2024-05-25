package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.*;
import java.util.List;
import java.util.logging.Logger;

public class ASTVisitorHandler {
    private static final Logger logger = Logger.getLogger(ASTVisitorHandler.class.getName());
    private CouplingCalculator couplingCalculator;

    public ASTVisitorHandler(CouplingCalculator couplingCalculator) {
        this.couplingCalculator = couplingCalculator;
    }

    public void handleVisit(VariableDeclarationStatement node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(ClassInstanceCreation node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(ArrayCreation node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(FieldDeclaration node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(ReturnStatement node) {
        if (node.getExpression() != null) {
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
        }
    }

    public void handleVisit(TypeLiteral node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(ThrowStatement node) {
        if (node.getExpression() != null)
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
    }

    public void handleVisit(TypeDeclaration node) {
        ITypeBinding resolvedType = node.resolveBinding();

        if (resolvedType != null) {
            ITypeBinding binding = resolvedType.getSuperclass();
            if (binding != null)
                couplingCalculator.coupleTo(binding);

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

    public void handleVisit(MethodDeclaration node) {
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

    public void handleVisit(CastExpression node) {
        couplingCalculator.coupleTo(node.getType());
    }

    public void handleVisit(InstanceofExpression node) {
        couplingCalculator.coupleTo(node.getRightOperand());
        couplingCalculator.coupleTo(node.getLeftOperand().resolveTypeBinding());
    }

    public void handleVisit(MethodInvocation node) {
        IMethodBinding binding = node.resolveMethodBinding();
        if (binding != null)
            couplingCalculator.coupleTo(binding.getDeclaringClass());
    }

    public void handleVisit(NormalAnnotation node) {
        coupleToAnnotation(node);
    }

    public void handleVisit(MarkerAnnotation node) {
        coupleToAnnotation(node);
    }

    public void handleVisit(SingleMemberAnnotation node) {
        coupleToAnnotation(node);
    }

    private void coupleToAnnotation(Annotation node) {
        ITypeBinding resolvedType = node.resolveTypeBinding();
        if (resolvedType != null)
            couplingCalculator.coupleTo(resolvedType);
        else {
            couplingCalculator.addToSet(node.getTypeName().getFullyQualifiedName());
        }
    }

    public void handleVisit(ParameterizedType node) {
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
            logger.severe(e.getMessage());
        }
    }
}
