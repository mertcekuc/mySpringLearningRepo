package com.mertspr.ng.Spr.ng.AOP;

import com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO;
import com.mertspr.ng.Spr.ng.AOP.dao.MembershipDAO;
import com.mertspr.ng.Spr.ng.AOP.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SprıngAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprıngAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner ->{
			//demoTheBeforeAdvice(accountDAO,membershipDAO);
			//demoForAfterReturn(accountDAO);
			//demoAfterThrowingAdvice(accountDAO);
			//demoForAfterAdvice(accountDAO);
			//demoAroundAdvice(trafficFortuneService);
			aroundAdviceWithHandlingException(trafficFortuneService);
		};

	}

	private void aroundAdviceWithHandlingException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main program:");
		boolean wire = true;
		try {

			String data = trafficFortuneService.getFortune(wire);
			System.out.println(data);
		}
		catch (Exception e){
			System.out.println("Exception handled......" + e);
		}
		System.out.println("Program finished");
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main program:");
		String data = trafficFortuneService.getFortune();
		System.out.println(data);
		System.out.println("Program finished");
	}

	private void demoForAfterAdvice(AccountDAO accountDAO) {
		System.out.println("After throwing advice test");
		List<Account> accs= null;

		try{
			boolean excWire=true;
			accs = accountDAO.findAccounts(excWire);
		}
		catch(Exception e) {
			System.out.println("Exception catched: " + e);
		}
		System.out.println(accs);
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		System.out.println("After throwing advice test");
		List<Account> accs= null;

		try{
			boolean excWire=true;
			accs = accountDAO.findAccounts(excWire);
		}
		catch(Exception e) {
			System.out.println("Exception catched: " + e);
		}
		System.out.println(accs);

	}

	private void demoForAfterReturn(AccountDAO accountDAO) {
		List<Account> accs= accountDAO.findAccounts();
		System.out.println(accs);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		//accountDAO.addAccount(1,2);
		//System.out.println();
		//System.out.println("Adding membership");
		//membershipDAO.addMembership();

		//call getter setters
		//accountDAO.setName("mert");
		//accountDAO.getName();
		//accountDAO.setServiceCode("1234ABCD");
		//accountDAO.getServiceCode();

	}
}
