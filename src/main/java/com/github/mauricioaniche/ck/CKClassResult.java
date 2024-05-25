package com.github.mauricioaniche.ck;

import java.util.*;

import com.github.mauricioaniche.ck.metrictypes.*;

public class CKClassResult {

	private ClassMetrics classMetrics;
	private FieldMetrics fieldMetrics;
	private MethodMetrics methodMetrics;
	private GeneralMetrics generalMetrics;

	private String file;
	private String className;
	private String type;
	private int modifiers;

	public CKClassResult(String file, String className, String type, int modifiers) {
		this.file = file;
		this.className = className;
		this.type = type;
		this.modifiers = modifiers;
		this.classMetrics = new ClassMetrics(className);
		this.fieldMetrics = new FieldMetrics();
		this.methodMetrics = new MethodMetrics();
		this.generalMetrics = new GeneralMetrics();
	}

	/**
	 * public/static/private and other org.eclipse.jdt.core.dom.Modifier modifiers
	 * 
	 * @see org.eclipse.jdt.core.dom.Modifier to decode int
	 * @return
	 */
	public int getModifiers() {
		return modifiers;
	}

	public String getFile() {
		return file;
	}

	public String getClassName() {
		return className;
	}

	public String getType() {
		return type;
	}

	// Métodos genéricos de get e set de ClassMetrics

	public int getDit() {
		return this.classMetrics.getDit();
	}

	public void setDit(int dit) {
		this.classMetrics.setDit(dit);
	}

	public int getNoc() {
		return this.classMetrics.getNoc();
	}

	public void setNoc(int noc) {
		this.classMetrics.setNoc(noc);
	}

	public void setWmc(int cc) {
		this.classMetrics.setWmc(cc);
	}

	public int getWmc() {
		return this.classMetrics.getWmc();
	}

	public int getCbo() {
		return this.classMetrics.getCbo();
	}

	public void setCbo(int cbo) {
		this.classMetrics.setCbo(cbo);
	}

	public int getCboModified() {
		return this.classMetrics.getCboModified();
	}

	public void setCboModified(int cboModified) {
		this.classMetrics.setCboModified(cboModified);
	}

	public int getFanin() {
		return this.classMetrics.getFanin();
	}

	public void setFanin(int fanin) {
		this.classMetrics.setFanin(fanin);
	}

	public int getFanout() {
		return this.classMetrics.getFanout();
	}

	public void setFanout(int fanout) {
		this.classMetrics.setFanout(fanout);
	}

	public void setLcom(int lcom) {
		this.classMetrics.setLcom(lcom);
	}

	public int getLcom() {
		return this.classMetrics.getLcom();
	}

	public void setLcomNormalized(float lcomNormalized) {
		this.classMetrics.setLcomNormalized(lcomNormalized);
	}

	public float getLcomNormalized() {
		return this.classMetrics.getLcomNormalized();
	}

	public void setRfc(int rfc) {
		this.classMetrics.setRfc(rfc);
	}

	public int getRfc() {
		return this.classMetrics.getRfc();
	}

	public int getNosi() {
		return this.generalMetrics.getNosi();
	}

	public void setNosi(int nosi) {
		this.generalMetrics.setNosi(nosi);
	}

	public int getLoc() {
		return this.generalMetrics.getLoc();
	}

	public void setLoc(int loc) {
		this.generalMetrics.setLoc(loc);
	}

	public void addMethod(CKMethodResult method) {
		this.methodMetrics.addMethod(method);
	}

	public Set<CKMethodResult> getMethods() {
		return this.methodMetrics.getMethods();
	}

	public Set<CKMethodResult> getVisibleMethods() {
		return this.methodMetrics.getVisibleMethods();
	}

	public Optional<CKMethodResult> getMethod(String methodName) {
		return this.methodMetrics.getMethod(methodName);
	}

	public void setFieldNames(Set<String> fieldNames) {
		this.fieldMetrics.setFieldNames(fieldNames);
	}

	public Set<String> getFieldNames() {
		return this.fieldMetrics.getFieldNames();
	}

	// Métodos genéricos de set e get de GeneralMetrics

	public void setReturnQty(int returnQty) {
		this.generalMetrics.setReturnQty(returnQty);
	}

	public int getReturnQty() {
		return this.generalMetrics.getReturnQty();
	}

	public void setLoopQty(int loopQty) {
		this.generalMetrics.setLoopQty(loopQty);
	}

	public int getLoopQty() {
		return this.generalMetrics.getLoopQty();
	}

	public void setComparisonsQty(int comparisonsQty) {
		this.generalMetrics.setComparisonsQty(comparisonsQty);
	}

	public int getComparisonsQty() {
		return this.generalMetrics.getComparisonsQty();
	}

	public void setTryQty(int tryCatchQty) {
		this.generalMetrics.setTryQty(tryCatchQty);
	}

	public int getTryQty() {
		return this.generalMetrics.getTryQty();
	}

	public void setParenthesizedExpsQty(int parenthesizedExpsQty) {
		this.generalMetrics.setParenthesizedExpsQty(parenthesizedExpsQty);
	}

	public int getParenthesizedExpsQty() {
		return this.generalMetrics.getParenthesizedExpsQty();
	}

	public void setStringLiteralsQty(int stringLiteralsQty) {
		this.generalMetrics.setStringLiteralsQty(stringLiteralsQty);
	}

	public int getStringLiteralsQty() {
		return this.generalMetrics.getStringLiteralsQty();
	}

	public void setNumbersQty(int numbersQty) {
		this.generalMetrics.setNumbersQty(numbersQty);
	}

	public int getNumbersQty() {
		return this.generalMetrics.getNumbersQty();
	}

	public void setAssignmentsQty(int assignmentsQty) {
		this.generalMetrics.setAssignmentsQty(assignmentsQty);
	}

	public int getAssignmentsQty() {
		return this.generalMetrics.getAssignmentsQty();
	}

	public void setMathOperationsQty(int mathOperationsQty) {
		this.generalMetrics.setMathOperationsQty(mathOperationsQty);
	}

	public int getMathOperationsQty() {
		return this.generalMetrics.getMathOperationsQty();
	}

	public void setVariablesQty(int variablesQty) {
		this.generalMetrics.setVariablesQty(variablesQty);
	}

	public int getVariablesQty() {
		return this.generalMetrics.getVariablesQty();
	}

	public void setMaxNestedBlocks(int maxNestedBlocks) {
		this.generalMetrics.setMaxNestedBlocks(maxNestedBlocks);
	}

	public int getMaxNestedBlocks() {
		return this.generalMetrics.getMaxNestedBlocks();
	}

	public void setAnonymousClassesQty(int anonymousClassesQty) {
		this.generalMetrics.setAnonymousClassesQty(anonymousClassesQty);
	}

	public int getAnonymousClassesQty() {
		return this.generalMetrics.getAnonymousClassesQty();
	}

	public void setInnerClassesQty(int innerClassesQty) {
		this.generalMetrics.setInnerClassesQty(innerClassesQty);
	}

	public int getInnerClassesQty() {
		return this.generalMetrics.getInnerClassesQty();
	}

	public void setLambdasQty(int lambdasQty) {
		this.generalMetrics.setLambdasQty(lambdasQty);
	}

	public int getLambdasQty() {
		return this.generalMetrics.getLambdasQty();
	}

	public void setUniqueWordsQty(int uniqueWordsQty) {
		this.generalMetrics.setUniqueWordsQty(uniqueWordsQty);
	}

	public int getUniqueWordsQty() {
		return this.generalMetrics.getUniqueWordsQty();
	}

	// Métodos genéricos de set e get de MethodMetrics

	public void setNumberOfMethods(int numberOfMethods) {
		this.methodMetrics.setNumberOfMethods(numberOfMethods);
	}

	public int getNumberOfMethods() {
		return this.methodMetrics.getNumberOfMethods();
	}

	public void setNumberOfStaticMethods(int numberOfStaticMethods) {
		this.methodMetrics.setNumberOfStaticMethods(numberOfStaticMethods);
	}

	public int getNumberOfStaticMethods() {
		return this.methodMetrics.getNumberOfStaticMethods();
	}

	public void setNumberOfPublicMethods(int numberOfPublicMethods) {
		this.methodMetrics.setNumberOfPublicMethods(numberOfPublicMethods);
	}

	public int getNumberOfPublicMethods() {
		return this.methodMetrics.getNumberOfPublicMethods();
	}

	public void setNumberOfPrivateMethods(int numberOfPrivateMethods) {
		this.methodMetrics.setNumberOfPrivateMethods(numberOfPrivateMethods);
	}

	public int getNumberOfPrivateMethods() {
		return this.methodMetrics.getNumberOfPrivateMethods();
	}

	public void setNumberOfProtectedMethods(int numberOfProtectedMethods) {
		this.methodMetrics.setNumberOfProtectedMethods(numberOfProtectedMethods);
	}

	public int getNumberOfProtectedMethods() {
		return this.methodMetrics.getNumberOfProtectedMethods();
	}

	public void setNumberOfDefaultMethods(int numberOfDefaultMethods) {
		this.methodMetrics.setNumberOfDefaultMethods(numberOfDefaultMethods);
	}

	public int getNumberOfDefaultMethods() {
		return this.methodMetrics.getNumberOfDefaultMethods();
	}

	public void setNumberOfAbstractMethods(int numberOfAbstractMethods) {
		this.methodMetrics.setNumberOfAbstractMethods(numberOfAbstractMethods);
	}

	public int getNumberOfAbstractMethods() {
		return this.methodMetrics.getNumberOfAbstractMethods();
	}

	public void setNumberOfFinalMethods(int numberOfFinalMethods) {
		this.methodMetrics.setNumberOfFinalMethods(numberOfFinalMethods);
	}

	public int getNumberOfFinalMethods() {
		return this.methodMetrics.getNumberOfFinalMethods();
	}

	public void setNumberOfSynchronizedMethods(int numberOfSynchronizedMethods) {
		this.methodMetrics.setNumberOfSynchronizedMethods(numberOfSynchronizedMethods);
	}

	public int getNumberOfVisibleMethods() {
		return this.methodMetrics.getNumberOfVisibleMethods();
	}

	public int getNumberOfSynchronizedMethods() {
		return this.methodMetrics.getNumberOfSynchronizedMethods();
	}

	// Métodos de set e get de FieldMetrics

	public void setNumberOfFields(int numberOfFields) {
		this.fieldMetrics.setNumberOfFields(numberOfFields);
	}

	public int getNumberOfFields() {
		return this.fieldMetrics.getNumberOfFields();
	}

	public void setNumberOfStaticFields(int numberOfStaticFields) {
		this.fieldMetrics.setNumberOfStaticFields(numberOfStaticFields);
	}

	public int getNumberOfStaticFields() {
		return this.fieldMetrics.getNumberOfStaticFields();
	}

	public void setNumberOfPublicFields(int numberOfPublicFields) {
		this.fieldMetrics.setNumberOfPublicFields(numberOfPublicFields);
	}

	public int getNumberOfPublicFields() {
		return this.fieldMetrics.getNumberOfPublicFields();
	}

	public void setNumberOfPrivateFields(int numberOfPrivateFields) {
		this.fieldMetrics.setNumberOfPrivateFields(numberOfPrivateFields);
	}

	public int getNumberOfPrivateFields() {
		return this.fieldMetrics.getNumberOfPrivateFields();
	}

	public void setNumberOfProtectedFields(int numberOfProtectedFields) {
		this.fieldMetrics.setNumberOfProtectedFields(numberOfProtectedFields);
	}

	public int getNumberOfProtectedFields() {
		return this.fieldMetrics.getNumberOfProtectedFields();
	}

	public void setNumberOfDefaultFields(int numberOfDefaultFields) {
		this.fieldMetrics.setNumberOfDefaultFields(numberOfDefaultFields);
	}

	public int getNumberOfDefaultFields() {
		return this.fieldMetrics.getNumberOfDefaultFields();
	}

	public void setNumberOfFinalFields(int numberOfFinalFields) {
		this.fieldMetrics.setNumberOfFinalFields(numberOfFinalFields);
	}

	public int getNumberOfFinalFields() {
		return this.fieldMetrics.getNumberOfFinalFields();
	}

	public void setNumberOfSynchronizedFields(int numberOfSynchronizedFields) {
		this.fieldMetrics.setNumberOfSynchronizedFields(numberOfSynchronizedFields);
	}

	public int getNumberOfSynchronizedFields() {
		return this.fieldMetrics.getNumberOfSynchronizedFields();
	}

	public void setLogStatementsQty(int numberOfLogStatements) {
		this.generalMetrics.setLogStatementsQty(numberOfLogStatements);

	}

	public int getNumberOfLogStatements() {
		return this.generalMetrics.getNumberOfLogStatements();
	}

	public float getTightClassCohesion() {
		return this.classMetrics.getTightClassCohesion();
	}

	public float getLooseClassCohesion() {
		return this.classMetrics.getLooseClassCohesion();
	}

	public void setTightClassCohesion(float tightClassCohesion) {
		this.classMetrics.setTightClassCohesion(tightClassCohesion);
	}

	public void setLooseClassCohesion(float looseClassCohesion) {
		this.classMetrics.setLooseClassCohesion(looseClassCohesion);
	}

	public int getCatchQty() {
		return this.generalMetrics.getCatchQty();
	}

	public void setCatchQty(int catchQty) {
		this.generalMetrics.setCatchQty(catchQty);
	}

	public int getNullCheckQty() {
		return this.generalMetrics.getNullCheckQty();
	}

	public void setNullCheckQty(int nullCheckQty) {
		this.generalMetrics.setNullCheckQty(nullCheckQty);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CKClassResult that = (CKClassResult) o;
		return file.equals(that.file) &&
				className.equals(that.className) &&
				type.equals(that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, className, type);
	}

	@Override
	public String toString() {
		return "CKClassResult [file=" + file + ", className=" + className + "]";
	}
}