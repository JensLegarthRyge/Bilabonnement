package com.example.bilabonnement.services;

import com.example.bilabonnement.repositories.LeaseReportRepository;
import com.example.bilabonnement.repositories.PickupLocationRepository;
import org.springframework.ui.Model;

public class ModelService {
    //Bliver ikke brugt. Skal den slettes mads?
    public Model fillModel(Model model) {
        model.addAttribute("allLeaseReports", new LeaseReportRepository().getAll());
        model.addAttribute("allPickupLocations", new PickupLocationRepository().getAll());
        return model;
    }
}
