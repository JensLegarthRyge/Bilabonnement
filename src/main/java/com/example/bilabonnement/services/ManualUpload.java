package com.example.bilabonnement.services;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

public class ManualUpload {

    public void uploadManualLease(WebRequest dataFromForm, int userId){
//        int carID = Integer.parseInt(dataFromForm.getParameter("carID"));
//        int customerID = Integer.parseInt(dataFromForm.getParameter("customerID"));
//        int period = Integer.parseInt(dataFromForm.getParameter("period"));

        System.out.println(dataFromForm.getParameter("carID"));
        System.out.println(dataFromForm.getParameter("customerID"));
        System.out.println(dataFromForm.getParameter("period"));
        System.out.println(dataFromForm.getParameter("deliveryInsurance"));
        System.out.println(dataFromForm.getParameter("lowDeductableInsurance"));
        System.out.println(dataFromForm.getParameter("isLimited"));
        System.out.println(dataFromForm.getParameter("pickupAddress"));
        System.out.println(dataFromForm.getParameter("startDate"));



    }
}
