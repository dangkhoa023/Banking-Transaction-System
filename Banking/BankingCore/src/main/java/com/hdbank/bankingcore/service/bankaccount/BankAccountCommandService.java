package com.hdbank.bankingcore.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcore.service.CommandService;

import java.util.concurrent.ConcurrentMap;

public interface BankAccountCommandService extends CommandService<BankAccount> {
}
