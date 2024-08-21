package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcore.service.CommandService;
import org.springframework.stereotype.Service;

@Service
public interface AccountCommandService extends CommandService<Account> {
}
