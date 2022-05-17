package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.repositories.IncidentRepository;
import org.springframework.web.context.request.WebRequest;

public class IncidentService {
    IncidentRepository ir = new IncidentRepository();
    public void createNewIncident(WebRequest dataFromForm){
        int incidentReportId = Integer.parseInt(dataFromForm.getParameter("incidentReportId"));
        int incidentTypeId = Integer.parseInt(dataFromForm.getParameter("incident"));
        ir.create(new Incident(incidentReportId, incidentTypeId));
    }

    public void deleteIncident(WebRequest dataFromForm){
        int incidentId = Integer.parseInt(dataFromForm.getParameter("incidentId"));
        ir.delete(incidentId);
    }


}
