package com.example.bilabonnement.models;

//Johannes Forsting

import com.example.bilabonnement.repositories.IncidentTypeRepository;

public class Incident {
    private int id;
    private int incidentReportId;
    private int incidentTypeId;
    IncidentTypeRepository itr = new IncidentTypeRepository();


    public Incident(int id, int incidentReportId, int incidentTypeIdc){
        this.id = id;
        this.incidentReportId = incidentReportId;
        this.incidentTypeId = incidentTypeIdc;
    }

    public Incident(int incidentReportId, int incidentTypeId){
        this.incidentReportId = incidentReportId;
        this.incidentTypeId = incidentTypeId;
    }

    public int getId() {
        return id;
    }

    public int getIncidentReportId() {
        return incidentReportId;
    }

    public int getIncidentTypeId() {
        return incidentTypeId;
    }

    public String getType(){
        String type = itr.getSingleById(this.incidentTypeId).getType();
        return type;
    }

    public int getPrice(){
        int price = itr.getSingleById(getIncidentTypeId()).getPrice();
        return price;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", incidentReportId=" + incidentReportId +
                ", incidentTypeId=" + incidentTypeId +
                '}';
    }
}
