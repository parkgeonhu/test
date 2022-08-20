package com.example.test.repository;

import com.example.test.model.Visitor;

import java.util.List;

public interface VisitorRepository {
    int countDistinctVisitor();
    Visitor save(Visitor visitor);
}
