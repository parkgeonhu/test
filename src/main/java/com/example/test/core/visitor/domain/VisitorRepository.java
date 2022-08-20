package com.example.test.core.visitor.domain;

import com.example.test.core.visitor.domain.Visitor;

public interface VisitorRepository {
    int countDistinctVisitor();

    Visitor save(Visitor visitor);
}
