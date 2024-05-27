package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import org.eclipse.jdt.core.dom.*;

public class CBO implements CKASTVisitor, ClassLevelMetric, MethodLevelMetric {
    private CouplingCalculator couplingCalculator = new CouplingCalculator();
    private ASTVisitorHandler visitorHandler = new ASTVisitorHandler(couplingCalculator);

    @Override
    public void visit(VariableDeclarationStatement node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(ClassInstanceCreation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(ArrayCreation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(FieldDeclaration node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(ReturnStatement node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(TypeLiteral node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(ThrowStatement node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(TypeDeclaration node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(MethodDeclaration node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(CastExpression node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(InstanceofExpression node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(MethodInvocation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(NormalAnnotation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(MarkerAnnotation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(SingleMemberAnnotation node) {
        visitorHandler.handleVisit(node);
    }

    @Override
    public void visit(ParameterizedType node) {
        visitorHandler.handleVisit(node);
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
