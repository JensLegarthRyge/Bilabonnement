package com.example.bilabonnement.models;

//Jens Legarth Ryge

public class Customer extends User {
    private String address;
    private City city;
    private String mobile;
    private String cprNumber;
    private String registrationNumber;
    private String accountNumber;

    public Customer(int id, String firstName, String lastName, String address, City city, String mobile, String cprNumber, String registrationNumber, String accountNumber, String email) {
        super(id, firstName, lastName, email);
        this.address = address;
        this.city = city;
        this.mobile = mobile;
        this.cprNumber = cprNumber;
        this.registrationNumber = registrationNumber;
        this.accountNumber = accountNumber;
    }
}
