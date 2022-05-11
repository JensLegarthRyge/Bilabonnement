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
                    new LeaseReport(1, 2, 3, etr.getSingleById(2),3,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 4, 578, etr.getSingleById(3),3,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 5, 3, etr.getSingleById(1),1,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 6, 3, etr.getSingleById(2),2,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 7, 578, etr.getSingleById(3),4,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 9, 3, etr.getSingleById(1),3,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 10, 3, etr.getSingleById(2),6,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 11, 578, etr.getSingleById(3),7,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 12, 3, etr.getSingleById(1),8,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 13, 3, etr.getSingleById(2),9,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 14, 578, etr.getSingleById(3),10,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 15, 3, etr.getSingleById(1),11,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 15, 3, etr.getSingleById(2),13,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 13, 578, etr.getSingleById(3),12,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 12, 3, etr.getSingleById(1),1,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 12, 3, etr.getSingleById(2),15,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 14, 578, etr.getSingleById(3),16,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 19, 3, etr.getSingleById(1),19,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 20, 3, etr.getSingleById(2),21,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 21, 578, etr.getSingleById(3),22,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 22, 3, etr.getSingleById(1),23,
                            idag, 120, true, true, "Kovej 29", false, 12999, idag),
                    new LeaseReport(1, 23, 3, etr.getSingleById(2),24,
                            idag, 120, true, true, "Vølundsgade 29", false, 12999, idag),
                    new LeaseReport(2, 24, 578, etr.getSingleById(3),25,
                            idag, 120, true, false, "Kirkeskovsstræde 339, 1. TH", false, 12999, idag),
                    new LeaseReport(7643, 25, 3, etr.getSingleById(1),26,
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
