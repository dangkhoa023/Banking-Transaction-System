package com.hdbank.bankingeventhandler.handler;

import com.google.gson.JsonObject;

public interface EventHandler {
    void handle(JsonObject json);

}
