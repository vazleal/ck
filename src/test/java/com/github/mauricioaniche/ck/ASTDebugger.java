package com.github.mauricioaniche.ck;

import com.github.mauricioaniche.ck.metric.CKASTVisitor;
import com.github.mauricioaniche.ck.metric.ClassLevelMetric;

import java.util.logging.Logger;

import org.eclipse.jdt.core.dom.*;

public class ASTDebugger implements CKASTVisitor, ClassLevelMetric {

	private static final Logger logger = Logger.getLogger(ASTDebugger.class.getName());

	public void visit(AnnotationTypeDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(AnnotationTypeMemberDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(AnonymousClassDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ArrayAccess node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ArrayCreation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ArrayInitializer node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ArrayType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(AssertStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(Assignment node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(Block node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(BlockComment node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(BooleanLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(BreakStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(CastExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(CatchClause node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(CharacterLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ClassInstanceCreation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(CompilationUnit node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ConditionalExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ConstructorInvocation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ContinueStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(CreationReference node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(Dimension node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(DoStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(EmptyStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(EnhancedForStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(EnumConstantDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(EnumDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ExpressionMethodReference node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ExpressionStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(FieldAccess node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(FieldDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ForStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(IfStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ImportDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(InfixExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(Initializer node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(InstanceofExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(IntersectionType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(LabeledStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(LambdaExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(LineComment node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MarkerAnnotation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MemberRef node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MemberValuePair node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MethodRef node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MethodRefParameter node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MethodDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(MethodInvocation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(Modifier node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(NameQualifiedType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(NormalAnnotation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(NullLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(NumberLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(PackageDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ParameterizedType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ParenthesizedExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(PostfixExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(PrefixExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(PrimitiveType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(QualifiedName node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(QualifiedType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ReturnStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SimpleName node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SimpleType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SingleMemberAnnotation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SingleVariableDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(StringLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SuperConstructorInvocation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SuperFieldAccess node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SuperMethodInvocation node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SuperMethodReference node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SwitchCase node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SwitchStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(SynchronizedStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TagElement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TextElement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ThisExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(ThrowStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TryStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TypeDeclaration node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TypeDeclarationStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TypeLiteral node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TypeMethodReference node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(TypeParameter node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(UnionType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(VariableDeclarationExpression node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(VariableDeclarationStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(VariableDeclarationFragment node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(WhileStatement node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	public void visit(WildcardType node) {
		logger.info("-- " + node.getClass().getSimpleName());
		logger.info(node.toString());
	}

	@Override
	public void setResult(CKClassResult result) {

	}
}
