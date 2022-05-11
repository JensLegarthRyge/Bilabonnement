package com.example.bilabonnement.models;

//Johannes Forsting

public class Incident {
    private int id;
    private int incidentReportId;
    private int incidentTypeId;

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

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", incidentReportId=" + incidentReportId +
                ", incidentTypeId=" + incidentTypeId +
                '}';
    }
}
