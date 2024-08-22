package com.hdbank.bankingeventhandler.service;

public interface EventConsumer {
    void process(String payload);
}
