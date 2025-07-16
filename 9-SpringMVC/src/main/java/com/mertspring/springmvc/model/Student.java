package com.mertspring.springmvc.model;


import java.util.List;

public class Student {
    private String firstName, lastName, country, favLang;
    private List<String> favOs;

    public List<String> getFavOs() {
        return favOs;
    }

    public void setFavOs(List<String> favOs) {
        this.favOs = favOs;
    }

    public Student(){};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavLang() {
        return favLang;
    }

    public void setFavLang(String favLang) {
        this.favLang = favLang;
    }
}
