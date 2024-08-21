package com.hdbank.bankingcommon.event;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ClientCreateEvent extends Event {
    public ClientCreateEvent(Object payload) {
        super(EventType.CLIENT_CREATE, payload);
    }
}
