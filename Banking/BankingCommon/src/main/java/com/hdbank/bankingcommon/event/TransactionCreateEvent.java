package com.hdbank.bankingcommon.event;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TransactionCreateEvent extends Event {
    public TransactionCreateEvent(Object payload) {
        super(EventType.TRANSACTION_CREATE, payload);
    }
}
