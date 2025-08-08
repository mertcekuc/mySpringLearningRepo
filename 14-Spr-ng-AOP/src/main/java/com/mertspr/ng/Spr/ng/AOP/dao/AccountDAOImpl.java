package com.mertspr.ng.Spr.ng.AOP.dao;

import com.mertspr.ng.Spr.ng.AOP.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(int i,int j) {
        System.out.println(getClass() + " ACCOUNT ADDING TO DB FROM DAO!!!!");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> result = new ArrayList<>();

        Account a1 = new Account("mert","12345");
        Account a2 = new Account("Cekuc","5678");

        result.add(a1);
        result.add(a2);

        return result;
    }

    public String getName() {
        System.out.println(getClass() + "get name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() +"set name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() +"get service code");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() +"set service code");
        this.serviceCode = serviceCode;
    }
}
