package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.ck.MethodInvocationService;
import java.util.*;
import java.util.stream.Collectors;

//we ignore invocations in the super class, because they are always outside the current class and can never return
@RunAfter(metrics={RFC.class, MethodLevelFieldUsageCount.class})
public class MethodInvocationsLocal implements CKASTVisitor, ClassLevelMetric {


    private MethodInvocationService invocationService;

    public MethodInvocationsLocal() {
        this.invocationService = new MethodInvocationService();
    }

    public void setResult(CKClassResult result) {
        //extract all direct local invocations for all methods in the current class
        Set<CKMethodResult> methods = result.getMethods();
        Map<String, Set<String>> methodInvocationsLocal = invocationService.extractLocalInvocations(methods);

        for (CKMethodResult method : methods) {
            method.setMethodInvocationLocal(methodInvocationsLocal.get(method.getQualifiedMethodName()));
        }

        Map<String, Map<String, Set<String>>> methodInvocationsIndirectLocal = invocationService.invocationsIndirect(methods, methodInvocationsLocal);
        for (CKMethodResult method : methods) {
            method.setMethodInvocationsIndirectLocal(methodInvocationsIndirectLocal.get(method.getQualifiedMethodName()));
        }
    }
}