package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.IncidentReportRepository;
import com.example.bilabonnement.repositories.IncidentRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.ArrayList;


//Jens Legarth Ryge
public class LeaseReportService {
    LeaseReportRepository lrr = new LeaseReportRepository();
    IncidentReportRepository irr = new IncidentReportRepository();

    public ArrayList<LeaseReport> getActiveLeaseReports(){
        ArrayList<LeaseReport> allActiveLeaseReports = new ArrayList<>();

        for (LeaseReport currentLeaseReport: lrr.getAll()) {
            LocalDate leaseReportStartDate = currentLeaseReport.getStartDate();
            int period = currentLeaseReport.getPeriod();
            //Adds only active lease reports
            if (leaseReportStartDate.plusDays(period).isAfter(LocalDate.now())
                    && leaseReportStartDate.isBefore(LocalDate.now())){
                allActiveLeaseReports.add(currentLeaseReport);
            }
        }
        return allActiveLeaseReports;
    }


    //Johannes Forsting
    public void removeLeaseReport(int id){

        int incidentReportId = irr.getSpecificByLeaseReportId(id).getId();
        removeIncidentReport(incidentReportId);
        lrr.delete(id);

    }

    public void removeIncidentReport(int id){
        removeIncidents(id);
        irr.delete(id);
    }

    public void removeIncidents(int id){
        IncidentRepository incidentRepository = new IncidentRepository();
        ArrayList<Incident> incidents = incidentRepository.getALlSpecific(id);
        for (int i = 0; i < incidents.size(); i++) {
            incidentRepository.delete(incidents.get(i).getId());
        }
    }



    public boolean uploadManualLease(WebRequest dataFromForm, int userId){
        int carId = Integer.parseInt(dataFromForm.getParameter("carId"));
        int customerId = Integer.parseInt(dataFromForm.getParameter("customerId"));
        boolean deliveryInsurance = (dataFromForm.getParameter("deliveryInsurance") == null) ? false : true;
        boolean lowDeductableInsurance = (dataFromForm.getParameter("lowDeductableInsurance") == null) ? false : true;
        boolean isLimited = (dataFromForm.getParameter("isLimited") == null) ? false : true;
        int period = dataFromForm.getParameter("period").equals("") ? 0 : Integer.parseInt(dataFromForm.getParameter("period"));
        int pickudLocationId = Integer.parseInt(dataFromForm.getParameter("pickupAddress"));
        LocalDate startDate = LocalDate.parse(dataFromForm.getParameter("startDate"));

        LeaseReport currentLease = new LeaseReport(carId, customerId, userId, period, deliveryInsurance, lowDeductableInsurance, isLimited, pickudLocationId, startDate);
        boolean success = lrr.create(currentLease);
        if(success){
            ArrayList<LeaseReport> allLeases = lrr.getAll();
            int leaseReportId = allLeases.get(allLeases.size() - 1).getId();
            IncidentReport currentIncident = new IncidentReport(leaseReportId);
            irr.create(currentIncident);
        }
        return success;
    }

    //Mads Nielsen
    public void uploadUpdatedLease(WebRequest dataFromForm) {
        int id = Integer.parseInt(dataFromForm.getParameter("lease-id"));
        int carId = Integer.parseInt(dataFromForm.getParameter("car-chassis"));
        int customerId = Integer.parseInt(dataFromForm.getParameter("customer-id"));
        int employeeId = Integer.parseInt(dataFromForm.getParameter("employee-id"));
        boolean hasReturnInsurance = Boolean.parseBoolean(dataFromForm.getParameter("return-insurance"));
        boolean hasLowDeductable = Boolean.parseBoolean(dataFromForm.getParameter("has-deductable"));
        boolean isLimited = Boolean.parseBoolean(dataFromForm.getParameter("is-limited"));
        int pickupLocationId = Integer.parseInt(dataFromForm.getParameter("pickup-address"));
        LocalDate startDate = LocalDate.parse(dataFromForm.getParameter("start-date"));
        LocalDate createdDate = LocalDate.parse(dataFromForm.getParameter("created-date"));
        int period = Integer.parseInt(dataFromForm.getParameter("period"));

        LeaseReport leaseReport = new LeaseReport(id,carId,customerId,employeeId,period,hasReturnInsurance,hasLowDeductable,isLimited,pickupLocationId,startDate, createdDate);
        lrr.update(leaseReport);
    }
}
