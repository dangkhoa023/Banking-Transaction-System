package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.event.ClientCreateEvent;
import com.hdbank.bankingeventhandler.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;

    private final Gson gson;

    @Override
    public void handle(JsonObject json) {
        ClientCreateEvent event = gson.fromJson(
                json,
                ClientCreateEvent.class
        );

        Client client = gson.fromJson(gson.toJson(event.getPayload()), Client.class); // chuyen doi doi tuong tu json ve thanh account

        clientService.createClient(client);

    }
}
