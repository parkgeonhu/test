package com.example.test.controller;

import com.example.test.model.Visitor;
import com.example.test.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    Logger log = LoggerFactory.getLogger(VisitorController.class);

    @GetMapping("/api/visitor")
    public ResponseEntity<String> visitor(HttpServletRequest httpServletRequest){
        String userAgent = httpServletRequest.getHeader("user-agent");
        Visitor visitor = new Visitor();
        visitor.setUserAgent(userAgent);
        visitorService.save(visitor);
        return ResponseEntity.ok("good");
    }

    @GetMapping("/api/visitors")
    public ResponseEntity<Integer> visitor(){
        int count = visitorService.count();
        return ResponseEntity.ok(count);
    }
}
