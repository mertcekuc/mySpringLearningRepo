package com.mertspr.ng.Spr.ng.AOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " ACCOUNT ADDING TO DB FROM DAO!!!!");
    }
}
