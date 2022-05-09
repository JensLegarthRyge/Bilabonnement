package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;

//Jens Legarth Ryge

public class LeaseReportRepository implements CRUDInterface<LeaseReport> {
    @Override
    public boolean create(LeaseReport entity) {
        return false;
    }

    @Override
    public ArrayList<LeaseReport> getAll() {
        return null;
    }

    @Override
    public LeaseReport getSingleById(int id) {
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
