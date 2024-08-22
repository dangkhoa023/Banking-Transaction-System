package com.hdbank.bankingeventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // Bean này cấu hình kèm bean Transaction (tìm hiêểu thêm trên gg)
@EnableJpaRepositories(basePackages = {
		"com.hdbank.bankingcommon.repository",
		"com.hdbank.bankingeventhandler.*"
}) // bean naày quét các repository trong các package được chỉ định
@EntityScan(basePackages = "com.hdbank.bankingcommon.domain.*") // Bean này quét các entity trong các package được chỉ định
public class BankingEventHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingEventHandlerApplication.class, args);
	}

}
