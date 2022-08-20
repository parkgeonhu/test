package com.example.test.common.support;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;

import java.time.Duration;

public class Bucket4jTrafficControlSupport implements TrafficControlSupport {

    private final Bucket bucket;

    public Bucket4jTrafficControlSupport(int capacity, int refillTokens, Duration duration) {
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
