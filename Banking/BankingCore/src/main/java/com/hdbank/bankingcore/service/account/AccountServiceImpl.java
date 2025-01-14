package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.repository.AccountRepository;
import com.hdbank.bankingcommon.service.account.AccountQueryService;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceRequest;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceResponse;
import com.hdbank.bankingcore.domain.dto.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountCommandService commandService;
    private final AccountMapper mapper;
    private final AccountQueryService queryService;
    private final AccountRepository accountRepository;

//    @Override
//    public void createAccount(AccountRequest newAccount) {
//
//        try {
//            if (newAccount.balance() < 0) {
//                throw new ResourceNotFoundException("Balance cannot be negative.");
//            }
//            if (newAccount.clientId() <= 0) {
//                throw new ResourceNotFoundException("Client ID cannot be null.");
//            }
//            Account account = mapper.toEntity(newAccount);
//            commandService.save(account);
//
//        } catch (ResourceNotFoundException exception) {
//            throw exception;
//        }
//    }

    @Transactional
    @Override
    public UpdateBalanceResponse updateBalance(UpdateBalanceRequest updateBalance) {

        Account account = queryService.getById(updateBalance.accountId());

        if (account == null) {
            throw new ResourceNotFoundException("Account with ID not found.");
        }
        // Cập nhật số dư tài khoản
        long newBalance = account.getBalance() + updateBalance.amount();

        // Cập nhật lại số dư
        account.setBalance(newBalance);

        if (newBalance < 0) {
            throw new ResourceNotFoundException(" Balance cannot go below zero.");
        }
        // Lưu lại account đã cập nhật
        commandService.save(account);
         return new UpdateBalanceResponse(account.getAccountId(), newBalance);
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
  //TODO
        //fixme
    }
}
