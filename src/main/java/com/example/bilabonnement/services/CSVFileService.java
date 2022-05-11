package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.CustomerRepository;
import com.example.bilabonnement.repositories.EmployeeRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;
import com.opencsv.CSVWriter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileService {

    public static void writeDataToFile(MultipartFile file) throws IOException {
        LeaseReportRepository lr = new LeaseReportRepository();

        byte[] tmp = file.getBytes();
        String decoded = new String(tmp, StandardCharsets.UTF_8);
        FileOutputStream fos = new FileOutputStream("src/main/resources/static/csvFiles/temp");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        CSVWriter writer = new CSVWriter(osw);
        String[] row = {decoded};

        writer.writeNext(row);
        writer.close();
        osw.close();

        ArrayList<LeaseReport> leaseReportList = formatDataFromFile();
        for (int i = 0; i < leaseReportList.size(); i++) {


        }


        new FileOutputStream("src/main/resources/static/csvFiles/temp").close();
    }

    static ArrayList<LeaseReport> formatDataFromFile()  {
        EmployeeRepository er = new EmployeeRepository();
        CustomerRepository cr = new CustomerRepository();
        ArrayList<LeaseReport> leaseReportList = new ArrayList<LeaseReport>();
        File leaseReportFile = new File("src/main/resources/static/csvFiles/temp");
        try {
            Scanner sc = new Scanner(leaseReportFile);
            sc.nextLine();
            while (sc.hasNextLine()){
                String leaseReportDetails = sc.nextLine();
                String[] stringAsArray = leaseReportDetails.split(",");
                String registrationNumber = stringAsArray[0];

                int employeeID = Integer.parseInt(stringAsArray[1]);
                Employee currentEmployee = er.getSingleById(employeeID);

                int customerID = Integer.parseInt(stringAsArray[2]);
                Customer currentCustomer = cr.getSingleById(customerID);

                int period = Integer.parseInt(stringAsArray[3]);
                boolean hasDeliveryInsurance = isTrue(Integer.parseInt(stringAsArray[4]));
                boolean hasLowDeductable = isTrue(Integer.parseInt(stringAsArray[5]));
                String pickupAddress = stringAsArray[7];
                boolean isLimited = isTrue(Integer.parseInt(stringAsArray[6]));
                double price = Double.parseDouble(stringAsArray[8]);

                String dateToFormat = stringAsArray[9];
                String[] dateToFormatAsArray = dateToFormat.split("/");
                int year = Integer.parseInt(dateToFormatAsArray[3]);
                int month = Integer.parseInt(dateToFormatAsArray[1]);
                int day = Integer.parseInt(dateToFormatAsArray[2]);
                LocalDate date = LocalDate.of(year,month,day);

                //LeaseReport tmp = new LeaseReport(registrationNumber, currentEmployee, currentCustomer, period, hasDeliveryInsurance, hasLowDeductable, pickupAddress, isLimited, price, date);
                //leaseReportList.add(tmp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return leaseReportList;
    }

    static boolean isTrue (int numberToBoolean) {
        boolean isTrue;
        if (numberToBoolean == 1) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }
}
