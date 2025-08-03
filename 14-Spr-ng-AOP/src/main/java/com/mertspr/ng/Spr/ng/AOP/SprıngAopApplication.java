package com.mertspr.ng.Spr.ng.AOP;

import com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprıngAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprıngAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
		return runner ->{
			demoTheBeforeAdvice(accountDAO);
		};

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();
		System.out.println("\nTesting again...\n");
		accountDAO.addAccount();

	}
}
