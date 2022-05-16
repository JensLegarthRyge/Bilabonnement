package com.example.bilabonnement.services;

import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.IncidentReportRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;
import org.springframework.web.context.request.WebRequest;

import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManualUpload {

    public boolean uploadManualLease(WebRequest dataFromForm, int userId){
        LeaseReportRepository leaseRep = new LeaseReportRepository();
        IncidentReportRepository insicentRep = new IncidentReportRepository();
        int carId = Integer.parseInt(dataFromForm.getParameter("carId"));
        int customerId = Integer.parseInt(dataFromForm.getParameter("customerId"));
        int period = Integer.parseInt(dataFromForm.getParameter("period"));
        boolean deliveryInsurance = (dataFromForm.getParameter("deliveryInsurance") == null) ? false : true;
        boolean lowDeductableInsurance = (dataFromForm.getParameter("lowDeductableInsurance") == null) ? false : true;
        boolean isLimited = (dataFromForm.getParameter("isLimited") == null) ? false : true;
        int pickudLocationId = Integer.parseInt(dataFromForm.getParameter("pickupAddress"));
        LocalDate startDate = LocalDate.parse(dataFromForm.getParameter("startDate"));

        LeaseReport currentLease = new LeaseReport(carId, customerId, userId, period, deliveryInsurance, lowDeductableInsurance, isLimited, pickudLocationId, startDate);
        boolean success = leaseRep.create(currentLease);
        if(success){
            ArrayList<LeaseReport> allLeases = leaseRep.getAll();
            int leaseReportId = allLeases.get(allLeases.size() - 1).getId();
            IncidentReport currentIncident = new IncidentReport(leaseReportId);
            insicentRep.create(currentIncident);
        }
        return success;
    }
}
