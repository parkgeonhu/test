package com.example.test.web.visitor;

import com.example.test.core.visitor.domain.Visitor;
import com.example.test.core.visitor.application.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VisitorRestController {

    @Autowired
    VisitorService visitorService;


    Logger log = LoggerFactory.getLogger(VisitorRestController.class);

    @GetMapping("/api/visitor")
    public ResponseEntity<Visitor> register(HttpServletRequest httpServletRequest){
        String userAgent = httpServletRequest.getHeader("user-agent");
        Visitor visitor = new Visitor();
        visitor.setUserAgent(userAgent);
        visitorService.save(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitor);
    }

    @GetMapping("/api/visitors")
    public ResponseEntity<Integer> register(){
        int count = visitorService.count();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
}
