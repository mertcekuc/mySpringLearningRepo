package com.mertspring.validationdemo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;


    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    @NotNull(message = "This is required")
    @Min(value = 0, message = "Value should be 0 or greater")
    @Max(value=10, message = "Value should be max 10" )
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Postal code is not valid")
    private String postalCode;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

