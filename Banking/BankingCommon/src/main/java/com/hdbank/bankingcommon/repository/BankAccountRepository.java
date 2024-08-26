package com.hdbank.bankingcommon.repository;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
}
