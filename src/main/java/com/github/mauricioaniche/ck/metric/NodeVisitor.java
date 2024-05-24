package com.github.mauricioaniche.ck.metric;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jdt.core.dom.*;

public abstract class NodeVisitor {
    protected CouplingManager couplingManager;

    protected NodeVisitor(CouplingManager couplingManager) {
        this.couplingManager = couplingManager;
    }

    public abstract void visit(ASTNode node);
}

class VariableDeclarationVisitor extends NodeVisitor {
    public VariableDeclarationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof VariableDeclarationStatement) {
            couplingManager.coupleTo(((VariableDeclarationStatement) node).getType());
        }
    }
}

class ClassInstanceCreationVisitor extends NodeVisitor {
    public ClassInstanceCreationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof ClassInstanceCreation) {
            couplingManager.coupleTo(((ClassInstanceCreation) node).getType());
        }
    }
}

class ArrayCreationVisitor extends NodeVisitor {
    public ArrayCreationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof ArrayCreation) {
            couplingManager.coupleTo(((ArrayCreation) node).getType());
        }
    }
}

class FieldDeclarationVisitor extends NodeVisitor {
    public FieldDeclarationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof FieldDeclaration) {
            couplingManager.coupleTo(((FieldDeclaration) node).getType());
        }
    }
}

class ReturnStatementVisitor extends NodeVisitor {
    public ReturnStatementVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof ReturnStatement) {
            if (((ReturnStatement) node).getExpression() != null) {
                couplingManager.coupleTo(((ReturnStatement) node).getExpression().resolveTypeBinding());
            }
        }
    }
}

class TypeLiteralVisitor extends NodeVisitor {
    public TypeLiteralVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof TypeLiteral) {
            couplingManager.coupleTo(((TypeLiteral) node).getType());
        }
    }
}

class ThrowStatementVisitor extends NodeVisitor {
    public ThrowStatementVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof ThrowStatement) {
            if (((ThrowStatement) node).getExpression() != null) {
                couplingManager.coupleTo(((ThrowStatement) node).getExpression().resolveTypeBinding());
            }
        }
    }
}

class TypeDeclarationVisitor extends NodeVisitor {
    public TypeDeclarationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof TypeDeclaration) {
            ITypeBinding resolvedType = ((TypeDeclaration) node).resolveBinding();
            if (resolvedType != null) {
                ITypeBinding binding = resolvedType.getSuperclass();
                if (binding != null) couplingManager.coupleTo(binding);
                for (ITypeBinding interfaces : resolvedType.getInterfaces()) {
                    couplingManager.coupleTo(interfaces);
                }
            } else {
                couplingManager.coupleTo(((TypeDeclaration) node).getSuperclassType());
                List<Type> list = ((TypeDeclaration) node).superInterfaceTypes();
			    list.forEach(x -> couplingManager.coupleTo(x));
            }
        }
    }
}

class MethodDeclarationVisitor extends NodeVisitor {
    public MethodDeclarationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof MethodDeclaration) {
            IMethodBinding resolvedMethod = ((MethodDeclaration) node).resolveBinding();
            if (resolvedMethod != null) {
                couplingManager.coupleTo(resolvedMethod.getReturnType());
                for (ITypeBinding param : resolvedMethod.getParameterTypes()) {
                    couplingManager.coupleTo(param);
                }
            } else {
                couplingManager.coupleTo(((MethodDeclaration) node).getReturnType2());
                List<TypeParameter> list = ((MethodDeclaration) node).typeParameters();
                list.forEach(x -> couplingManager.coupleTo(x.getName()));
            }
        }
    }
}

class CastExpressionVisitor extends NodeVisitor {
    public CastExpressionVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof CastExpression) {
            couplingManager.coupleTo(((CastExpression) node).getType());
        }
    }
}

class InstanceofExpressionVisitor extends NodeVisitor {
    public InstanceofExpressionVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof InstanceofExpression) {
            couplingManager.coupleTo(((InstanceofExpression) node).getRightOperand());
            couplingManager.coupleTo(((InstanceofExpression) node).getLeftOperand().resolveTypeBinding());
        }
    }
}

class MethodInvocationVisitor extends NodeVisitor {
    public MethodInvocationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof MethodInvocation) {
            IMethodBinding binding = ((MethodInvocation) node).resolveMethodBinding();
            if (binding != null) {
                couplingManager.coupleTo(binding.getDeclaringClass());
            }
        }
    }
}

class NormalAnnotationVisitor extends NodeVisitor {
    public NormalAnnotationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof NormalAnnotation) {
            couplingManager.coupleTo((NormalAnnotation) node);
        }
    }
}

class MarkerAnnotationVisitor extends NodeVisitor {
    public MarkerAnnotationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof MarkerAnnotation) {
            couplingManager.coupleTo((MarkerAnnotation) node);
        }
    }
}

class SingleMemberAnnotationVisitor extends NodeVisitor {
    public SingleMemberAnnotationVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof SingleMemberAnnotation) {
            couplingManager.coupleTo((SingleMemberAnnotation) node);
        }
    }
}

class ParameterizedTypeVisitor extends NodeVisitor {
    public ParameterizedTypeVisitor(CouplingManager couplingManager) {
        super(couplingManager);
    }

    @Override
    public void visit(ASTNode node) {
        if (node instanceof ParameterizedType) {
            try {
                ITypeBinding binding = ((ParameterizedType) node).resolveBinding();
                if (binding != null) {
                    couplingManager.coupleTo(binding);
                    for (ITypeBinding types : binding.getTypeArguments()) {
                        couplingManager.coupleTo(types);
                    }
                } else {
                    couplingManager.coupleTo(((ParameterizedType) node).getType());
                }
            } catch (NullPointerException e) {
                Logger.getLogger(ParameterizedTypeVisitor.class.getName()).severe(e.getMessage());
            }
        }
    }
}