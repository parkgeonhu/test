package com.example.test.core.visitor.application;

import com.example.test.core.visitor.domain.Visitor;

public interface VisitorService {
    public int count();

    public void save(Visitor visitor);
}
