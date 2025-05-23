package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lv.rvt.tools.Helper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Ievadiet klienta ID: ");
        int clientId = Integer.parseInt(scanner.nextLine());
        while (clientId > Manager.getLastIdFromCsv("klienti.csv")) {
            System.out.println("Klienta ID neeksistē. Lūdzu, ievadiet derīgu klienta ID: ");
            clientId = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Ievadiet automašīnas ID: ");
        int carId = Integer.parseInt(scanner.nextLine());
        while (carId > Manager.getLastIdFromCsv("cars.csv")) {
            System.out.println("Automašīnas ID neeksistē. Lūdzu, ievadiet derīgu automašīnas ID: ");
            Integer.parseInt(scanner.nextLine());
        }

        if (isCarAvailable(carId) == false) {
            System.out.println("Šī automašīna nav pieejama nomai.");
            return;
        }

        String startDateStr;
        while (true) {
            System.out.println("Ievadiet sākuma datumu (GGGG-MM-DD): ");
            startDateStr = scanner.nextLine();
            try {
                LocalDate.parse(startDateStr, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Nepareizs datuma formāts. Lūdzu, ievadiet datumu formātā GGGG-MM-DD.");
            }
        }

        String endDateStr;
        while (true) {
            System.out.println("Ievadiet beigu datumu (GGGG-MM-DD): ");
            endDateStr = scanner.nextLine();
            try {
                LocalDate startDate = LocalDate.parse(startDateStr, formatter);
                LocalDate endDate = LocalDate.parse(endDateStr, formatter);
                if (endDate.isBefore(startDate)) {
                    System.out.println("Beigu datums nevar būt pirms sākuma datuma. Lūdzu, ievadiet derīgu beigu datumu.");
                } else {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Nepareizs datuma formāts. Lūdzu, ievadiet datumu formātā GGGG-MM-DD.");
            }
        }

        System.out.println("Ievadiet kopējo cenu: ");
        double totalPrice = Double.parseDouble(scanner.nextLine());

        Rental rental = new Rental(clientId, carId, startDateStr, endDateStr, totalPrice);

        Manager.addRentalToFile(rental);

        markCarAsRented(carId, false);

        System.out.println("Noma veiksmīgi izveidota!");
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
            } else {
                return false;
            }
        }

        return isAvailable;
    }

    private static void markCarAsRented(int carId, boolean available) throws Exception {
    BufferedReader reader = Helper.getReader("cars.csv");
    List<String> newLines = new ArrayList<>();
    String line;
    boolean isFirstLine = true;

    while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
            newLines.add(line);
            isFirstLine = false;
            continue;
        }

        String[] parts = line.split(", ");
        int currentId = Integer.parseInt(parts[0].trim());

        if (currentId == carId) {
            parts[8] = String.valueOf(available);
            newLines.add(String.join(", ", parts));
        } else {
            newLines.add(line);
        }
    }

    reader.close();

    BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.TRUNCATE_EXISTING);
    for (int i = 0; i < newLines.size(); i++) {
        writer.write(newLines.get(i));
        writer.newLine();
    }
    writer.close();
}

    public static void returnCar() throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = Helper.getReader("rental.csv");
        String line;
        int carId = 0;

        System.out.println("\nIevadiet nomas ID: ");
        int rentalId = Integer.parseInt(scanner.nextLine());

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length > 1) {
                int currentRentalId = Integer.parseInt(parts[0].trim());
                if (currentRentalId == rentalId) {
                    carId = Integer.parseInt(parts[2].trim());
                }
            }
        }

        updateRentalStatus(rentalId);

        markCarAsRented(carId, true);
    }

    private static void updateRentalStatus(int rentalId) throws Exception {
        BufferedReader reader = Helper.getReader("rental.csv");
        List<String> newLines = new ArrayList<>();
        String line;
        boolean isFirstLine = true;
    
        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                newLines.add(line);
                isFirstLine = false;
                continue;
            }
    
            String[] parts = line.split(", ");
            int currentId = Integer.parseInt(parts[0].trim());
    
            if (currentId == rentalId) {
                parts[6] = String.valueOf(false);
                newLines.add(String.join(", ", parts));
            } else {
                newLines.add(line);
            }
        }
    
        reader.close();
    
        BufferedWriter writer = Helper.getWriter("rental.csv", StandardOpenOption.TRUNCATE_EXISTING);
        for (int i = 0; i < newLines.size(); i++) {
            writer.write(newLines.get(i));
            writer.newLine();
        }
        writer.close();

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
