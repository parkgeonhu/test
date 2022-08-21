package com.example.test.common.support;

import java.time.Duration;

public interface TrafficControlSupport {
    boolean tryRequest();
    void setBucket(int capacity, int refillTokens, Duration duration);
}
