package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.service.TransactionQueryService;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService extends TransactionCommandService, TransactionQueryService {

}
