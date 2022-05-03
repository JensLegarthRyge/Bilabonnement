package com.example.bilabonnement.models;

//Jens Legarth Ryge

import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport {
    private int incidentReportId;
    private int leaseReportId;
    private ArrayList<Incident> allIncidents;
    private LocalDate date;
    private double price;
    private double customerPrice;

}
