package com.hdbank.bankingcommon.event;

public class BankAccountCreateEvent extends  Event
{
    public BankAccountCreateEvent(Object payload) {
        super(EventType.ACCOUNT_CREATE, payload);
    }
}
