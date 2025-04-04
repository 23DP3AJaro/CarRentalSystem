package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lv.rvt.tools.Helper;

public class Rental {

    private int rentalId;
    private int clientId;
    private int carId;
    private String startDate;
    private String endDate;
    private double totalPrice;
    private boolean isActive;

    public Rental (int clientId, int carId, String startDate, String endDate, double totalPrice) throws Exception {
        this.rentalId = Manager.getLastIdFromCsv("rental.csv") + 1;
        this.clientId = clientId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.isActive = true;
    }

    public static void createRental() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client ID: ");
        int clientId = Integer.parseInt(scanner.nextLine());
        while (clientId > Manager.getLastIdFromCsv("klienti.csv")) {
            System.out.println("Client ID does not exist. Please enter a valid client ID: ");
            clientId = Integer.parseInt(scanner.nextLine());;
        }

        System.out.println("Enter car ID: ");
        int carId = Integer.parseInt(scanner.nextLine());
        while (carId > Manager.getLastIdFromCsv("cars.csv")) {
            System.out.println("Car ID does not exist. Please enter a valid car ID: ");
            Integer.parseInt(scanner.nextLine());
        }

        if (isCarAvailable(carId) == false) {
            System.out.println("This car is not available for rent.");
            return;
        }

        System.out.println("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.println("Enter total price: ");
        double totalPrice = Double.parseDouble(scanner.nextLine());
        
        Rental rental = new Rental(clientId, carId, startDate, endDate, totalPrice);

        Manager.addRentalToFile(rental);

        markCarAsRented(carId, false);

        System.out.println("Rental created successfully!");
    }


    private static boolean isCarAvailable(int carId) throws Exception {
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        boolean isAvailable = true;

        reader.readLine();

        for (int i = 0; i < carId; i++) {
            line = reader.readLine();
            String[] parts = line.split(", ");
            if (parts.length > 0) { 
                isAvailable = Boolean.parseBoolean(parts[8].trim()); 
            }
            else {
                return false;
            }
        }

        return isAvailable;
    }

    private static void markCarAsRented(int carId, boolean available) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("data/cars.csv"));
        
        List<String> newLines = new ArrayList<>();
        newLines.add(lines.get(0)); 
        
        
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(", ");
            int currentId = Integer.parseInt(parts[0].trim());
            
            if (currentId == carId) {
                
                newLines.add(line.replace(parts[8], String.valueOf(available)));
            } else {
                newLines.add(line);
                
            }
        }
        
        Files.write(Paths.get("data/cars.csv"), newLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("Car with ID " + carId + " updated successfully");
    }
    

    public static void returnCar() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rental ID: ");
        int rentalId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter car ID: ");
        int carId = Integer.parseInt(scanner.nextLine());


        updateRentalStatus(rentalId);

        markCarAsRented(carId, true);

        System.out.println("Car returned successfully!");
    }

    private static void updateRentalStatus(int rentalId) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("data/rental.csv"));
        
        List<String> newLines = new ArrayList<>();
        newLines.add(lines.get(0)); 
        
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(", ");
            int currentId = Integer.parseInt(parts[0].trim());
            
            if (currentId == rentalId) {
                newLines.add(line.replace(parts[6], String.valueOf(false)));
            } else {
                newLines.add(line);
                
            }
        }
        
        Files.write(Paths.get("data/rental.csv"), newLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("Rental with ID " + rentalId + " updated successfully");

    }


    public int getRentalId() {
        return rentalId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getCarId() {
        return carId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isActive() {
        return isActive;
    }
}