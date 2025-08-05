package com.mertspr.ng.Spr.ng.AOP;

import com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO;
import com.mertspr.ng.Spr.ng.AOP.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			demoTheBeforeAdvice(accountDAO,membershipDAO);


		};

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		//accountDAO.addAccount(1,2);
		System.out.println();
		System.out.println("Adding membership");
		membershipDAO.addMembership();

		//call getter setters
		accountDAO.setName("mert");
		accountDAO.getName();
		accountDAO.setServiceCode("1234ABCD");
		accountDAO.getServiceCode();
	}
}
