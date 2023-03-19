package com.github.mauricioaniche.ck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberOfTryCatchesTest extends BaseTest {

	private CKClassResult result;
	
	@BeforeAll
	public void setUp() {
		report = run(fixturesDir() + "/trycatch");
		result = report.get("trycatch.TryCatch");
	}
	
	@Test
	public void countClass() {
		Assertions.assertEquals(6, result.getTryQty());
		Assertions.assertEquals(7, result.getCatchQty());
	}

	@Test
	public void countNestedTry() {
		Assertions.assertEquals(2, result.getMethod("m1/0").get().getTryQty());
		Assertions.assertEquals(2, result.getMethod("m1/0").get().getCatchQty());
	}

	@Test
	public void countTryCatchFinally() {
		Assertions.assertEquals(1, result.getMethod("m2/0").get().getTryQty());
		Assertions.assertEquals(1, result.getMethod("m2/0").get().getCatchQty());
	}

	@Test
	public void countTryCatchTwoExceptions() {
		Assertions.assertEquals(1, result.getMethod("m3/0").get().getTryQty());
		Assertions.assertEquals(1, result.getMethod("m3/0").get().getCatchQty());
	}

	@Test
	public void countNoTryStatement() {
		Assertions.assertEquals(0, result.getMethod("m4/0").get().getTryQty());
		Assertions.assertEquals(0, result.getMethod("m4/0").get().getCatchQty());
	}
	
	@Test
	public void countTryMultipleCatches() {
		Assertions.assertEquals(1, result.getMethod("m5/0").get().getTryQty());
		Assertions.assertEquals(2, result.getMethod("m5/0").get().getCatchQty());
	}
}
