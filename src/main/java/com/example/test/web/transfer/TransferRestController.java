package com.example.test.web.transfer;

import com.example.test.common.support.Bucket4jTrafficControlSupport;
import com.example.test.common.support.TrafficControlSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.Duration;

@RestController
public class TransferRestController {

    Logger log = LoggerFactory.getLogger(TransferRestController.class);

    @Value("${transfer.trafficControl}")
    boolean trafficControl;

    TrafficControlSupport trafficControlSupport = null;

    public TransferRestController() {
    }

    @PostConstruct
    public void setUp() {
        if (trafficControl) {
            trafficControlSupport = new Bucket4jTrafficControlSupport(1, 1, Duration.ofSeconds(5));
        }
    }


    // [TO-DO] AspectJ를 이용해 부가기능으로 빼기
    @GetMapping("/register/auto-transfer")
    public ResponseEntity<?> registerAutoTransfer() {
        if (trafficControl == true && !trafficControlSupport.tryRequest()) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too Many Requests");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Register auto-transfer");
    }
}
