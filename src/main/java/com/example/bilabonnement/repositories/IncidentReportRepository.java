package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;

//Jens Legarth Ryge

public class IncidentReportRepository implements CRUDInterface<IncidentReport> {
    @Override
    public boolean create(IncidentReport entity) {
        return false;
    }

    @Override
    public ArrayList<IncidentReport> getAll() {
        return null;
    }

    @Override
    public IncidentReport getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(IncidentReport entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
