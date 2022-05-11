package com.example.bilabonnement.services;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.LeaseReportRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class ManualUpload {

    public void uploadManualLease(WebRequest dataFromForm, int userId){
        LeaseReportRepository leaseRep = new LeaseReportRepository();
        int carId = Integer.parseInt(dataFromForm.getParameter("carId"));
        int customerId = Integer.parseInt(dataFromForm.getParameter("customerId"));
        int period = Integer.parseInt(dataFromForm.getParameter("period"));
        boolean deliveryInsurance = (dataFromForm.getParameter("deliveryInsurance") == null) ? false : true;
        boolean lowDeductableInsurance = (dataFromForm.getParameter("lowDeductableInsurance") == null) ? false : true;
        boolean isLimited = (dataFromForm.getParameter("isLimited") == null) ? false : true;
        String pickupAddress = dataFromForm.getParameter("pickupAddress");
        LocalDate startDate = LocalDate.parse(dataFromForm.getParameter("startDate"));

        LeaseReport currentLease = new LeaseReport(carId, customerId, userId, period, deliveryInsurance, lowDeductableInsurance, isLimited, pickupAddress, startDate);
        boolean success = leaseRep.create(currentLease);

    }
}
