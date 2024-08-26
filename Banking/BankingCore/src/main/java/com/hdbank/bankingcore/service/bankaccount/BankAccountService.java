package com.hdbank.bankingcore.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcore.domain.dto.BankingAccountRequest;
import com.hdbank.bankingcore.service.CommandService;

public interface BankAccountService extends QueryService<BankAccount> , CommandService<BankAccount> {
    void createBankAccount(BankingAccountRequest newBankAccount);
    BankAccount getById(long bank_account_id);

}
