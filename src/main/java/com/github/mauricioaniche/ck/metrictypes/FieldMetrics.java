package com.github.mauricioaniche.ck.metrictypes;

import java.util.*;

public class FieldMetrics {
	private Set<String> fieldNames;
	private int numberOfFields;
	private int numberOfStaticFields;
	private int numberOfPublicFields;
	private int numberOfPrivateFields;
	private int numberOfProtectedFields;
	private int numberOfDefaultFields;
	private int numberOfFinalFields;
	private int numberOfSynchronizedFields;

	public void setFieldNames(Set<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

	public Set<String> getFieldNames() {
		return fieldNames;
	}

	public void setNumberOfFields(int numberOfFields) {
		this.numberOfFields = numberOfFields;
	}

	public int getNumberOfFields() {
		return numberOfFields;
	}

	public void setNumberOfStaticFields(int numberOfStaticFields) {
		this.numberOfStaticFields = numberOfStaticFields;
	}

	public int getNumberOfStaticFields() {
		return numberOfStaticFields;
	}

	public void setNumberOfPublicFields(int numberOfPublicFields) {
		this.numberOfPublicFields = numberOfPublicFields;
	}

	public int getNumberOfPublicFields() {
		return numberOfPublicFields;
	}

	public void setNumberOfPrivateFields(int numberOfPrivateFields) {
		this.numberOfPrivateFields = numberOfPrivateFields;
	}

	public int getNumberOfPrivateFields() {
		return numberOfPrivateFields;
	}

	public void setNumberOfProtectedFields(int numberOfProtectedFields) {
		this.numberOfProtectedFields = numberOfProtectedFields;
	}

	public int getNumberOfProtectedFields() {
		return numberOfProtectedFields;
	}

	public void setNumberOfDefaultFields(int numberOfDefaultFields) {
		this.numberOfDefaultFields = numberOfDefaultFields;
	}

	public int getNumberOfDefaultFields() {
		return numberOfDefaultFields;
	}

	public void setNumberOfFinalFields(int numberOfFinalFields) {
		this.numberOfFinalFields = numberOfFinalFields;
	}

	public int getNumberOfFinalFields() {
		return numberOfFinalFields;
	}

	public void setNumberOfSynchronizedFields(int numberOfSynchronizedFields) {
		this.numberOfSynchronizedFields = numberOfSynchronizedFields;
	}

	public int getNumberOfSynchronizedFields() {
		return numberOfSynchronizedFields;
	}

}
