package com.github.mauricioaniche.ck;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import java.util.*;
import java.util.stream.Collectors;

public class MethodInvocationService {

    //Extract all local(inner-class) method invocations and save them in a HashMap
    public Map<String, Set<String>> extractLocalInvocations(Set<CKMethodResult> methods) {
        Map<String, Set<String>> methodInvocationsLocal = new HashMap<>();
        Set<String> methodNames = methods.stream().map(CKMethodResult::getQualifiedMethodName).collect(Collectors.toSet());

        //extract all indirect local invocations for all methods in the current class
        for (CKMethodResult method : methods) {
            //extract all local invocations for the current method
            Set<String> invokedLocal = method.getLocalInvocations(methodNames);
            methodInvocationsLocal.put(method.getQualifiedMethodName(), invokedLocal);
        }
        return methodInvocationsLocal;
    }

    //Generate an indirect method invocations map
    //Method contains all methods of interest
    //Invocations contains all indirect method invocations of interest with the calling method
    public Map<String, Map<String, Set<String>>> invocationsIndirect(Set<CKMethodResult> methods, Map<String, Set<String>> methodInvocationsLocal) {
        Map<String, Map<String, Set<String>>> methodInvocationsIndirectLocal = new HashMap<>();

        for (CKMethodResult method : methods) {
            Map<String, Set<String>> localInvocations = invocations(method.getQualifiedMethodName(), new HashMap<>(), methodInvocationsLocal);
            methodInvocationsIndirectLocal.put(method.getQualifiedMethodName(), localInvocations);
        }
        return methodInvocationsIndirectLocal;
    }

    //Recursively extract all method invocations starting with the given method
    //Explored contains all previously explored invocations
    //Invocations contains all direct method invocations of interest
    //The algorithm is a depth first search
    private Map<String, Set<String>> invocations(String invokedMethod, Map<String, Set<String>> explored, Map<String, Set<String>> invocations) {
        //only explore local method invocations that were not previously explored
        Set<String> exploredKeys = explored.keySet();
        Set<String> nextInvocations = invocations.get(invokedMethod).stream()
                .filter(invoked -> !exploredKeys.contains(invoked) && !invoked.equals(invokedMethod))
                .collect(Collectors.toSet());
        if (!nextInvocations.isEmpty()) {
            explored.put(invokedMethod, nextInvocations);

            for (String nextInvocation : nextInvocations) {
                explored = invocations(nextInvocation, explored, invocations);
            }
        }
        
        //Stops when all invocations are explored: there are no more invocations to be explored
        return explored;
    }
}
