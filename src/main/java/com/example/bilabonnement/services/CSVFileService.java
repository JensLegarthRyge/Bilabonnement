package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.*;
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
        IncidentReportRepository ir = new IncidentReportRepository();
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
            lr.create(leaseReportList.get(i));
            ArrayList<LeaseReport> currentLeaseReports = lr.getAll();
            int leaseReportId = currentLeaseReports.get(currentLeaseReports.size() - 1).getId();
            IncidentReport currentIncidentReport = new IncidentReport(leaseReportId);
            ir.create(currentIncidentReport);
        }


        new FileOutputStream("src/main/resources/static/csvFiles/temp").close();
    }

    static ArrayList<LeaseReport> formatDataFromFile()  {

        CarRepository carRepo= new CarRepository();
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
                int carId = carRepo.getCarByChassisNumber(stringAsArray[0]);
                System.out.println(carId);
                int employeeID = Integer.parseInt(stringAsArray[1]);
                System.out.println(employeeID);
                int customerID = Integer.parseInt(stringAsArray[2]);
                System.out.println(customerID);
                int period = Integer.parseInt(stringAsArray[3]);
                System.out.println(period);
                boolean hasDeliveryInsurance = isTrue(Integer.parseInt(stringAsArray[4]));
                System.out.println(hasDeliveryInsurance);
                boolean hasLowDeductable = isTrue(Integer.parseInt(stringAsArray[5]));
                System.out.println(hasLowDeductable);
                String pickupAddress = stringAsArray[7];
                System.out.println(pickupAddress);
                boolean isLimited = isTrue(Integer.parseInt(stringAsArray[6]));
                System.out.println(isLimited);
                double price = Double.parseDouble(stringAsArray[8]);
                System.out.println(price);

                String createdDateToFormat = stringAsArray[9];
                String[] createdDateToFormatAsArray = createdDateToFormat.split("/");
                System.out.println(createdDateToFormat);
                int createdYear = Integer.parseInt(createdDateToFormatAsArray[2]);
                int createdMonth = Integer.parseInt(createdDateToFormatAsArray[0]);
                int createdDay = Integer.parseInt(createdDateToFormatAsArray[1]);
                LocalDate createdDate = LocalDate.of(createdYear,createdMonth,createdDay);

                String dateToFormat = stringAsArray[10];
                String[] dateToFormatAsArray = dateToFormat.split("/");
                System.out.println(dateToFormat);
                int year = Integer.parseInt(dateToFormatAsArray[2]);
                int month = Integer.parseInt(dateToFormatAsArray[0]);
                int day = Integer.parseInt(dateToFormatAsArray[1]);
                LocalDate date = LocalDate.of(year,month,day);

                LeaseReport tmp = new LeaseReport(carId, employeeID, customerID, period, hasDeliveryInsurance, hasLowDeductable, pickupAddress, isLimited, price, createdDate, date);
                leaseReportList.add(tmp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException l) {
            return leaseReportList;
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
