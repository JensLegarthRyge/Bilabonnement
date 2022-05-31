package com.example.bilabonnement.models;

//Jens Legarth Ryge

public class Customer extends User {
    private String address;
    private int zipCode;
    private String mobile;
    private long cprNumber;
    private long registrationNumber;
    private int accountNumber;

    public Customer(int id, String firstName, String lastName, String address, int zipCode, String email, String mobile, long cpr, long regNum, int accountNum) {
        super(id,firstName,lastName,email);
        this.address = address;
        this.zipCode = zipCode;
        this.mobile = mobile;
        this.cprNumber = cpr;
        this.registrationNumber = regNum;
        this.accountNumber = accountNum;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getMobile() {
        return mobile;
    }

    public long getCprNumber() {
        return cprNumber;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
