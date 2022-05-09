package com.example.bilabonnement.models;

//Jens Legarth Ryge

public class Customer extends User {
    private String address;
    private int zipCode;
    private String mobile;
    private int cprNumber;
    private int registrationNumber;
    private int accountNumber;

    public Customer(int id, String firstName, String lastName, String address, int zipCode, String mobile, int cprNumber, int registrationNumber, int accountNumber, String email) {
        super(id, firstName, lastName, email);
        this.address = address;
        this.zipCode = zipCode;
        this.mobile = mobile;
        this.cprNumber = cprNumber;
        this.registrationNumber = registrationNumber;
        this.accountNumber = accountNumber;
    }

    public Customer(int id, String firstName, String lastName, String address, int zipCode, String email, String mobile, int cpr, int regNum, int accountNum) {
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

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(int cprNumber) {
        this.cprNumber = cprNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
