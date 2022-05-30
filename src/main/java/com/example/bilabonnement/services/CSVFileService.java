package com.example.bilabonnement.services;
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
//Mads Nielsen
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
            System.out.println("in try catch");
            Scanner sc = new Scanner(leaseReportFile);
            sc.nextLine();
            while (sc.hasNextLine()){
                String leaseReportDetails = sc.nextLine();
                String[] stringAsArray = leaseReportDetails.split(";");
                int carId = carRepo.getCarByChassisNumber(stringAsArray[0]);
                int customerID = Integer.parseInt(stringAsArray[1]);
                int employeeID = Integer.parseInt(stringAsArray[2]);
                int period = Integer.parseInt(stringAsArray[3]);
                boolean hasDeliveryInsurance = isTrue(Integer.parseInt(stringAsArray[4]));
                boolean hasLowDeductable = isTrue(Integer.parseInt(stringAsArray[5]));
                boolean isLimited = isTrue(Integer.parseInt(stringAsArray[6]));
                int pickupLocationId = Integer.parseInt(stringAsArray[7]);

                String dateToFormat = stringAsArray[8];
                String[] dateToFormatAsArray = dateToFormat.split("/");
                int year = Integer.parseInt(dateToFormatAsArray[2]);
                int month = Integer.parseInt(dateToFormatAsArray[0]);
                int day = Integer.parseInt(dateToFormatAsArray[1]);
                LocalDate date = LocalDate.of(year,month,day);

                System.out.println("carid" + carId);
                System.out.println("customerid" + customerID);
                System.out.println("employeeid" + employeeID);
                System.out.println("period" + period);
                System.out.println("hasdeliveryinsurance" + hasDeliveryInsurance);
                System.out.println("haslowdeduct " + hasLowDeductable);
                System.out.println("islimited " + isLimited);
                System.out.println("pickuplocationId " + pickupLocationId);

                LeaseReport tmp = new LeaseReport(carId, customerID, employeeID, period, hasDeliveryInsurance, hasLowDeductable, isLimited, pickupLocationId, date);
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
