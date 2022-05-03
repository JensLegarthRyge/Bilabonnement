package com.example.bilabonnement.models;

//Jens Legarth Ryge

public class Customer extends User {
    private String address;
    private City city;
    private String email;
    private String mobile;
    private String cprNumber;
    private String registrationNumber;
    private String accountNumber;

    public Customer(int id, String firstName, String lastName, String address, City city, String email, String mobile, String cprNumber, String registrationNumber, String accountNumber) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
        this.cprNumber = cprNumber;
        this.registrationNumber = registrationNumber;
        this.accountNumber = accountNumber;
    }
}
