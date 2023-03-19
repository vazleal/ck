package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.TryStatement;

public class NumberOfTryCatches implements CKASTVisitor, ClassLevelMetric, MethodLevelMetric {

	private int tryQty = 0;
	
	private int catchQty = 0;

	public void visit(TryStatement node) {
		tryQty++;
	}

	public void visit(CatchClause node) {
		catchQty++;
	}
	
	@Override
	public void setResult(CKMethodResult result) {
		result.setTryQty(tryQty);
		result.setCatchQty(catchQty);

	}

	@Override
	public void setResult(CKClassResult result) {
		result.setTryQty(tryQty);
		result.setCatchQty(catchQty);
	}
}
