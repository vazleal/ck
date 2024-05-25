package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CouplingCalculator {
    private static final Logger logger = Logger.getLogger(CouplingCalculator.class.getName());
    private Set<String> coupling = new HashSet<>();

    public void coupleTo(Type type) {
        if (type == null) return;

        ITypeBinding resolvedBinding = type.resolveBinding();
        if (resolvedBinding != null) {
            coupleTo(resolvedBinding);
        } else {
            if (type instanceof SimpleType) {
                SimpleType castedType = (SimpleType) type;
                addToSet(castedType.getName().getFullyQualifiedName());
            } else if (type instanceof QualifiedType) {
                QualifiedType castedType = (QualifiedType) type;
                addToSet(castedType.getName().getFullyQualifiedName());
            } else if (type instanceof NameQualifiedType) {
                NameQualifiedType castedType = (NameQualifiedType) type;
                addToSet(castedType.getName().getFullyQualifiedName());
            } else if (type instanceof ParameterizedType) {
                ParameterizedType castedType = (ParameterizedType) type;
                coupleTo(castedType.getType());
            } else if (type instanceof WildcardType) {
                WildcardType castedType = (WildcardType) type;
                coupleTo(castedType.getBound());
            } else if (type instanceof ArrayType) {
                ArrayType castedType = (ArrayType) type;
                coupleTo(castedType.getElementType());
            } else if (type instanceof IntersectionType) {
                IntersectionType castedType = (IntersectionType) type;
                @SuppressWarnings("unchecked")
                List<Type> types = castedType.types();
                types.stream().forEach(this::coupleTo);
            } else if (type instanceof UnionType) {
                UnionType castedType = (UnionType) type;
                @SuppressWarnings("unchecked")
                List<Type> types = castedType.types();
                types.stream().forEach(this::coupleTo);
            }
        }
    }

    public void coupleTo(SimpleName name) {
        addToSet(name.getFullyQualifiedName());
    }

    public void coupleTo(ITypeBinding binding) {
        if (binding == null || binding.isWildcardType() || binding.isNullType()) return;

        String type = binding.getQualifiedName();
        if (type.equals("null")) return;

        if (isFromJava(type) || binding.isPrimitive()) return;

        String cleanedType = cleanClassName(type);
        addToSet(cleanedType);
    }

    private String cleanClassName(String type) {
        String cleanedType = type.replace("[]", "").replace("\\$", ".");

        if (cleanedType.contains("<"))
            cleanedType = cleanedType.substring(0, cleanedType.indexOf("<"));

        return cleanedType;
    }

    private boolean isFromJava(String type) {
        return type.startsWith("java.") || type.startsWith("javax.");
    }

    public void addToSet(String name) {
        this.coupling.add(name);
    }

    public void clean() {
        Set<String> singleQualifiedTypes = coupling.stream().filter(x -> !x.contains(".")).collect(Collectors.toSet());

        for (String singleQualifiedType : singleQualifiedTypes) {
            long count = coupling.stream().filter(x -> x.endsWith("." + singleQualifiedType)).count();

            boolean theSameFullyQualifiedTypeExists = count > 0;
            if (theSameFullyQualifiedTypeExists)
                coupling.remove(singleQualifiedType);
        }
    }

    public int getCouplingSize() {
        return coupling.size();
    }
}
