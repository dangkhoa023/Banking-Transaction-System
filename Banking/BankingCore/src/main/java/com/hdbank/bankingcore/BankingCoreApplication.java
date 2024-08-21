package com.hdbank.bankingcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.hdbank.bankingcommon.domain.model")
public class BankingCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingCoreApplication.class, args);
	}

}
