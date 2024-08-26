package com.hdbank.bankingcommon.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.repository.BankAccountRepository;
import com.hdbank.bankingcommon.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountQueryService extends QueryService<BankAccount> {


    BankAccount getById(long bank_account_id);
}
