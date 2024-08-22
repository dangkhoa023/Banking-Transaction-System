package com.hdbank.bankingcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.hdbank.*"
})
@ComponentScan(basePackages = "com.hdbank.*")
@EnableJpaRepositories(basePackages = {
	"com.hdbank.bankingcommon.repository",
	"com.hdbank.bankingcore.repository"
})
public class BankingCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingCoreApplication.class, args);
	}

}
