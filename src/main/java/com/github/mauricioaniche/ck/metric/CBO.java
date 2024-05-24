package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import org.eclipse.jdt.core.dom.*;

import java.util.Arrays;
import java.util.List;

public class CBO implements CKASTVisitor, ClassLevelMetric, MethodLevelMetric {
	private CouplingManager couplingManager = new CouplingManager();
	private List<NodeVisitor> visitors = Arrays.asList(
			new VariableDeclarationVisitor(couplingManager),
			new ClassInstanceCreationVisitor(couplingManager),
			new ArrayCreationVisitor(couplingManager),
			new FieldDeclarationVisitor(couplingManager),
			new ReturnStatementVisitor(couplingManager),
			new TypeLiteralVisitor(couplingManager),
			new ThrowStatementVisitor(couplingManager),
			new TypeDeclarationVisitor(couplingManager),
			new MethodDeclarationVisitor(couplingManager),
			new CastExpressionVisitor(couplingManager),
			new InstanceofExpressionVisitor(couplingManager),
			new MethodInvocationVisitor(couplingManager),
			new NormalAnnotationVisitor(couplingManager),
			new MarkerAnnotationVisitor(couplingManager),
			new SingleMemberAnnotationVisitor(couplingManager),
			new ParameterizedTypeVisitor(couplingManager));

	@Override
	public void visit(ASTNode node) {
		for (NodeVisitor visitor : visitors) {
			visitor.visit(node);
		}
	}

	@Override
	public void setResult(CKClassResult result) {
		couplingManager.clean();
		result.setCbo(couplingManager.getCouplingSize());
	}

	@Override
	public void setResult(CKMethodResult result) {
		couplingManager.clean();
		result.setCbo(couplingManager.getCouplingSize());
	}
}
