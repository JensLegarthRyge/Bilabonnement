package com.example.bilabonnement.repositories.testRepositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class LeaseTestRepository implements CRUDInterface<LeaseReport> {
    EmployeeTestRepository etr = new EmployeeTestRepository();
    CustomerTestRepository ctr = new CustomerTestRepository();

    LocalDate idag = LocalDate.of(2022,5,10);

    ArrayList<LeaseReport> allLeaseReports = new ArrayList<>(
            Arrays.asList(
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, "BS32454", 3, etr.getSingleById(2),ctr.getSingleById(3),
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, "BS32454", 578, etr.getSingleById(3),ctr.getSingleById(1),
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, "BS32454", 3, etr.getSingleById(1),ctr.getSingleById(2),
                            idag, 120, true, true, "Kovej 29", false, 12999, idag)
            )
    );

    @Override
    public boolean create(LeaseReport entity) {
        return false;
    }

    @Override
    public ArrayList<LeaseReport> getAll() {
        return allLeaseReports;
    }

    @Override
    public LeaseReport getSingleById(int id) {
        for (LeaseReport clr:allLeaseReports) {
            if (clr.getId()==id){
                return clr;
            }
        }
        return null;
    }

    @Override
    public boolean update(LeaseReport entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
