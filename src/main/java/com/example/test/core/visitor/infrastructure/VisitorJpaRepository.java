package com.example.test.core.visitor.infrastructure;

import com.example.test.core.visitor.domain.Visitor;
import com.example.test.core.visitor.domain.VisitorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorJpaRepository extends VisitorRepository, JpaRepository<Visitor, String> {
    @Query("select count(distinct v.userAgent) from Visitor v")
    int countDistinctVisitor();

}
