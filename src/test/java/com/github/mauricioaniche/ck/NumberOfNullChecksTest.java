package com.github.mauricioaniche.ck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberOfNullChecksTest extends BaseTest {

	private CKClassResult result;
	
	@BeforeAll
	public void setUp() {
		report = run(fixturesDir() + "/nullcheck");
		result = report.get("nullcheck.NullCheck");
	}
	
	@Test
	public void countClass() {
		Assertions.assertEquals(21, result.getNullCheckQty());
	}

	@Test
	public void countMethod_CheckWithEqual() {
		Assertions.assertEquals(1, result.getMethod("checkEqual/0").get().getNullCheckQty());
	}
	
	@Test
	public void countMethod_CheckWithDifferent() {
		Assertions.assertEquals(1, result.getMethod("checkDifferent/0").get().getNullCheckQty());
	}

	@Test
	public void countMethod_CheckWithEqual_WithinMultipleConditions() {
		Assertions.assertEquals(3, result.getMethod("checkMultipleConditionsCheck_OneEqual/0").get().getNullCheckQty());
	}

	@Test
	public void countMethod_CheckWithDifferent_WithinMultipleConditions() {
		Assertions.assertEquals(1, result.getMethod("checkMultipleConditionsCheck_OneDifferent/0").get().getNullCheckQty());
	}

	@Test
	public void countMethod_CheckWithinMultipleConditions() {
		Assertions.assertEquals(11, result.getMethod("checkMultipleConditionsCheck/0").get().getNullCheckQty());
	}

	@Test
	public void countMethod_CheckWithinNestedConditions() {
		Assertions.assertEquals(4, result.getMethod("checkMultipleConditionsCheckNested/0").get().getNullCheckQty());
	}


}
