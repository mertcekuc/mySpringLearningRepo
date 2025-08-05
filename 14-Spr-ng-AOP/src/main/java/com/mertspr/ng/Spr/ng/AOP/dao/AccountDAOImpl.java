package com.mertspr.ng.Spr.ng.AOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(int i,int j) {
        System.out.println(getClass() + " ACCOUNT ADDING TO DB FROM DAO!!!!");
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
