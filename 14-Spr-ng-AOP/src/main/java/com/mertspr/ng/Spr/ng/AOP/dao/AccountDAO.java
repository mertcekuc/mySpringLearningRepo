package com.mertspr.ng.Spr.ng.AOP.dao;

import com.mertspr.ng.Spr.ng.AOP.Account;

import java.util.List;

public interface AccountDAO {

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public void addAccount(int i,int j);
    public List<Account> findAccounts();
}
