package com.example.test.repository;

import com.example.test.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorJpaRepository extends VisitorRepository, JpaRepository<Visitor, String> {
    @Query("select count(distinct v.userAgent) from Visitor v")
    int countDistinctVisitor();

}
