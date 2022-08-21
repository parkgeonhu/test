package com.example.test.common.support;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope("prototype")
public class Bucket4jTrafficControlSupport implements TrafficControlSupport {

    Bucket bucket;

    public void setBucket(int capacity, int refillTokens, Duration duration){
        Bandwidth limit = Bandwidth.classic(capacity, Refill.intervally(refillTokens, duration));
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();

    }

    public boolean tryRequest() {
        if (bucket.tryConsume(1)) {
            return true;
        }
        return false;
    }
}
