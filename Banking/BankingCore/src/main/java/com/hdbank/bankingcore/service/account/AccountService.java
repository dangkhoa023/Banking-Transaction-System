package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.service.AccountQueryService;
import org.springframework.stereotype.Service;

@Service
public interface AccountService extends AccountCommandService, AccountQueryService {
}
