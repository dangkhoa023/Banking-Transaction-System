package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.service.account.AccountQueryService;
import com.hdbank.bankingcore.domain.dto.AccountRequest;
import com.hdbank.bankingcore.domain.dto.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountCommandService commandService;
    private final AccountMapper mapper;
    private final AccountQueryService queryService;

    @Override
    public void createAccount(AccountRequest newAccount) {
        Account account = mapper.toEntity(newAccount);
        commandService.save(account);
    }
    @Override
    public Account getById(final long id
    ) {
        return queryService.getById(id);
    }
    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Account object) {

    }
}
