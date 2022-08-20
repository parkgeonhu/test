package com.example.test.service.impl;

import com.example.test.model.Visitor;
import com.example.test.repository.VisitorRepository;
import com.example.test.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAgentVisitorService implements VisitorService {
    @Autowired
    public VisitorRepository visitorRepository;

    public void save(Visitor visitor){
        visitorRepository.save(visitor);
    }

    public int count() {
        return visitorRepository.countDistinctVisitor();
    }

}
