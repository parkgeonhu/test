package com.example.test.core.visitor.application;

import com.example.test.core.visitor.domain.VisitorRepository;
import com.example.test.core.visitor.domain.Visitor;
import com.example.test.core.visitor.application.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAgentVisitorService implements VisitorService {
    @Autowired
    public VisitorRepository visitorRepository;

    @Override
    public int count() {
        return visitorRepository.countDistinctVisitor();
    }

    @Override
    public void save(Visitor visitor) {
        visitorRepository.save(visitor);
    }
}
