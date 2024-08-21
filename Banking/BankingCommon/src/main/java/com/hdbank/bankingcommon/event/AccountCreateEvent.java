package com.hdbank.bankingcommon.event;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends Event {
    public AccountCreateEvent(Object payload) {
        super(EventType.ACCOUNT_CREATE, payload);
    }
}
