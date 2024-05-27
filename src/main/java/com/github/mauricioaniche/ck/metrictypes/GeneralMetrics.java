package com.github.mauricioaniche.ck.metrictypes;

public class GeneralMetrics {
    private int returnQty;
    private int loopQty;
    private int comparisonsQty;
    private int tryQty;
    private int catchQty;
    private int parenthesizedExpsQty;
    private int stringLiteralsQty;
    private int numbersQty;
    private int assignmentsQty;
    private int mathOperationsQty;
    private int variablesQty;
    private int maxNestedBlocks;
    private int anonymousClassesQty;
    private int innerClassesQty;
    private int lambdasQty;
    private int uniqueWordsQty;
    private int nullCheckQty;
    private int numberOfLogStatements;
    private int nosi;
	private int loc;

    public void setLogStatementsQty(int numberOfLogStatements) {
        this.numberOfLogStatements = numberOfLogStatements;
    }

    public int getNumberOfLogStatements() {
        return numberOfLogStatements;
    }

    public int getCatchQty() {
        return catchQty;
    }

    public void setCatchQty(int catchQty) {
        this.catchQty = catchQty;
    }

    public int getNullCheckQty() {
        return nullCheckQty;
    }

    public void setNullCheckQty(int nullCheckQty) {
        this.nullCheckQty = nullCheckQty;
    }

    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public void setLoopQty(int loopQty) {
        this.loopQty = loopQty;
    }

    public int getLoopQty() {
        return loopQty;
    }

    public void setComparisonsQty(int comparisonsQty) {
        this.comparisonsQty = comparisonsQty;
    }

    public int getComparisonsQty() {
        return comparisonsQty;
    }

    public void setTryQty(int tryCatchQty) {
        this.tryQty = tryCatchQty;
    }

    public int getTryQty() {
        return tryQty;
    }

    public void setParenthesizedExpsQty(int parenthesizedExpsQty) {
        this.parenthesizedExpsQty = parenthesizedExpsQty;
    }

    public int getParenthesizedExpsQty() {
        return parenthesizedExpsQty;
    }

    public void setStringLiteralsQty(int stringLiteralsQty) {
        this.stringLiteralsQty = stringLiteralsQty;
    }

    public int getStringLiteralsQty() {
        return stringLiteralsQty;
    }

    public void setNumbersQty(int numbersQty) {
        this.numbersQty = numbersQty;
    }

    public int getNumbersQty() {
        return numbersQty;
    }

    public void setAssignmentsQty(int assignmentsQty) {
        this.assignmentsQty = assignmentsQty;
    }

    public int getAssignmentsQty() {
        return assignmentsQty;
    }

    public void setMathOperationsQty(int mathOperationsQty) {
        this.mathOperationsQty = mathOperationsQty;
    }

    public int getMathOperationsQty() {
        return mathOperationsQty;
    }

    public void setVariablesQty(int variablesQty) {
        this.variablesQty = variablesQty;
    }

    public int getVariablesQty() {
        return variablesQty;
    }

    public void setMaxNestedBlocks(int maxNestedBlocks) {
        this.maxNestedBlocks = maxNestedBlocks;
    }

    public int getMaxNestedBlocks() {
        return maxNestedBlocks;
    }

    public void setAnonymousClassesQty(int anonymousClassesQty) {
        this.anonymousClassesQty = anonymousClassesQty;
    }

    public int getAnonymousClassesQty() {
        return anonymousClassesQty;
    }

    public void setInnerClassesQty(int innerClassesQty) {
        this.innerClassesQty = innerClassesQty;
    }

    public int getInnerClassesQty() {
        return innerClassesQty;
    }

    public void setLambdasQty(int lambdasQty) {
        this.lambdasQty = lambdasQty;
    }

    public int getLambdasQty() {
        return lambdasQty;
    }

    public void setUniqueWordsQty(int uniqueWordsQty) {
        this.uniqueWordsQty = uniqueWordsQty;
    }

    public int getUniqueWordsQty() {
        return uniqueWordsQty;
    }

    public int getNosi() {
		return nosi;
	}

	public void setNosi(int nosi) {
		this.nosi = nosi;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}
}
