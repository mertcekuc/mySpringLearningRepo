package com.mertspr.ng.Spr.ng.AOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public int addMembership() {
        System.out.println(getClass() + " MEMBERSHIP ADDING TO DB FROM DAO!!!!");
        return 0;
    }
}
