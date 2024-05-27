package com.github.mauricioaniche.ck.metrictypes;

import com.github.mauricioaniche.ck.*;
import java.util.*;



public class MethodMetrics {
	private Set<CKMethodResult> methods;
	private Set<CKMethodResult> visibleMethods;

	private int numberOfStaticMethods;
	private int numberOfPublicMethods;
	private int numberOfPrivateMethods;
	private int numberOfProtectedMethods;
	private int numberOfDefaultMethods;
	private int numberOfAbstractMethods;
	private int numberOfFinalMethods;
	private int numberOfSynchronizedMethods;
	private int numberOfMethods;

	public MethodMetrics() {
		this.methods = new HashSet<>();
		this.visibleMethods = new HashSet<>();
	}

	public void addMethod(CKMethodResult method) {
		this.methods.add(method);
		if (method.getIsVisible()) {
			visibleMethods.add(method);
		}
	}

	public Set<CKMethodResult> getMethods() {
		return Collections.unmodifiableSet(methods);
	}

	public Set<CKMethodResult> getVisibleMethods() {
		return Collections.unmodifiableSet(visibleMethods);
	}

	public Optional<CKMethodResult> getMethod(String methodName) {
		return methods.stream().filter(m -> m.getMethodName().equals(methodName)).findFirst();
	}

	public void setNumberOfMethods(int numberOfMethods) {
		this.numberOfMethods = numberOfMethods;
	}

	public int getNumberOfMethods() {
		return numberOfMethods;
	}

	public void setNumberOfStaticMethods(int numberOfStaticMethods) {
		this.numberOfStaticMethods = numberOfStaticMethods;
	}

	public int getNumberOfStaticMethods() {
		return numberOfStaticMethods;
	}

	public void setNumberOfPublicMethods(int numberOfPublicMethods) {
		this.numberOfPublicMethods = numberOfPublicMethods;
	}

	public int getNumberOfPublicMethods() {
		return numberOfPublicMethods;
	}

	public void setNumberOfPrivateMethods(int numberOfPrivateMethods) {
		this.numberOfPrivateMethods = numberOfPrivateMethods;
	}

	public int getNumberOfPrivateMethods() {
		return numberOfPrivateMethods;
	}

	public void setNumberOfProtectedMethods(int numberOfProtectedMethods) {
		this.numberOfProtectedMethods = numberOfProtectedMethods;
	}

	public int getNumberOfProtectedMethods() {
		return numberOfProtectedMethods;
	}

	public void setNumberOfDefaultMethods(int numberOfDefaultMethods) {
		this.numberOfDefaultMethods = numberOfDefaultMethods;
	}

	public int getNumberOfDefaultMethods() {
		return numberOfDefaultMethods;
	}

	public void setNumberOfAbstractMethods(int numberOfAbstractMethods) {
		this.numberOfAbstractMethods = numberOfAbstractMethods;
	}

	public int getNumberOfAbstractMethods() {
		return numberOfAbstractMethods;
	}

	public void setNumberOfFinalMethods(int numberOfFinalMethods) {
		this.numberOfFinalMethods = numberOfFinalMethods;
	}

	public int getNumberOfFinalMethods() {
		return numberOfFinalMethods;
	}

	public void setNumberOfSynchronizedMethods(int numberOfSynchronizedMethods) {
		this.numberOfSynchronizedMethods = numberOfSynchronizedMethods;
	}

	public int getNumberOfVisibleMethods() {
		return visibleMethods.size();
	}

	public int getNumberOfSynchronizedMethods() {
		return numberOfSynchronizedMethods;
	}

}
