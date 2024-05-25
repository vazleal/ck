package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import org.eclipse.jdt.core.dom.*;

import java.util.List;
import java.util.logging.Logger;

public class CBO implements CKASTVisitor, ClassLevelMetric, MethodLevelMetric {
    private static final Logger logger = Logger.getLogger(CBO.class.getName());
    private CouplingCalculator couplingCalculator = new CouplingCalculator();

    @Override
    public void visit(VariableDeclarationStatement node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(ClassInstanceCreation node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(ArrayCreation node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(FieldDeclaration node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(ReturnStatement node) {
        if (node.getExpression() != null) {
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
        }
    }

    @Override
    public void visit(TypeLiteral node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(ThrowStatement node) {
        if (node.getExpression() != null)
            couplingCalculator.coupleTo(node.getExpression().resolveTypeBinding());
    }

    @Override
    public void visit(TypeDeclaration node) {
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

    @Override
    public void visit(MethodDeclaration node) {
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

    @Override
    public void visit(CastExpression node) {
        couplingCalculator.coupleTo(node.getType());
    }

    @Override
    public void visit(InstanceofExpression node) {
        couplingCalculator.coupleTo(node.getRightOperand());
        couplingCalculator.coupleTo(node.getLeftOperand().resolveTypeBinding());
    }

    @Override
    public void visit(MethodInvocation node) {
        IMethodBinding binding = node.resolveMethodBinding();
        if (binding != null)
            couplingCalculator.coupleTo(binding.getDeclaringClass());
    }

    @Override
    public void visit(NormalAnnotation node) {
        coupleToAnnotation(node);
    }

    @Override
    public void visit(MarkerAnnotation node) {
        coupleToAnnotation(node);
    }

    @Override
    public void visit(SingleMemberAnnotation node) {
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

    @Override
    public void visit(ParameterizedType node) {
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

    @Override
    public void setResult(CKClassResult result) {
        couplingCalculator.clean();
        result.setCbo(couplingCalculator.getCouplingSize());
    }

    @Override
    public void setResult(CKMethodResult result) {
        couplingCalculator.clean();
        result.setCbo(couplingCalculator.getCouplingSize());
    }
}
