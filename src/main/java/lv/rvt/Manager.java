package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import lv.rvt.tools.Helper;

public class Manager {

    public static int getLastIdFromCsv(String filename) throws Exception {
        
        BufferedReader reader = Helper.getReader(filename);
        String line;
        int lastId = 0;

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length > 0) { 
                int currentId = Integer.parseInt(parts[0].trim()); 
                if (currentId > lastId) {
                    lastId = currentId;
                }
            }
        }

        return lastId;
    }

    public static void addRentalToFile(Rental rental) throws Exception {
        BufferedWriter writer = Helper.getWriter("rental.csv", StandardOpenOption.APPEND);

        writer.write(rental.getRentalId() + ", " + rental.getClientId() + ", " + rental.getCarId() + ", " + rental.getStartDate() + ", " + rental.getEndDate() + ", " + rental.getTotalPrice() + ", " + rental.isActive());
        writer.newLine();
        writer.close();
    }

    
    private static void addKlients(Klienti klients) throws Exception{
        BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.APPEND);


        writer.write(klients.getId() + ", " + klients.getName() + ", " + klients.getSurname() + ", " + klients.getBirthDate()); 
        writer.newLine();
        writer.close();
    }

    private static void addCar(Cars car) throws Exception{
        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.APPEND);

        writer.write(car.getId() + ", " + car.getBrand() + ", " + car.getModel() + ", "  + car.getYearOfManufacture() + ", "+ car.getColor() +", " + car.getLicensePlate() + ", " + car.getMileage() + ", " + car.getRentalPrice() + ", " + car.isAvailable()); 
        writer.newLine();
        writer.close();
    }


    public static void userAddKlients() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String inputName = scanner.nextLine();

        System.out.println("Surname: ");
        String inputSurname = scanner.nextLine();

        System.out.println("Birth date: "); 
        String inputBirthDate = scanner.nextLine();
        
        Klienti klients = new Klienti(inputName, inputSurname, inputBirthDate);

        addKlients(klients);
    }

    public static void userAddCars() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Brand: ");
        String inputBrand = scanner.nextLine();

        System.out.println("Model: ");
        String inputModel = scanner.nextLine();

        int inputYearOfManufacture;
        while (true) {
            System.out.println("Year of manufacture: ");
            try {
                inputYearOfManufacture = Integer.parseInt(scanner.nextLine());
                break;
                
                
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Enter a number.");
            }
        }

        System.out.println("Color: ");
        String inputColor = scanner.nextLine();

        System.out.println("License plate: ");
        String inputLicensePlate = scanner.nextLine();

        int inputMileage;
        while (true) {
            System.out.println("Mileage: ");
            try {
                inputMileage = Integer.parseInt(scanner.nextLine());
                if (inputMileage >= 0) {
                    break;
                } else {
                    System.out.println("Invalid mileage. Must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }

        double inputRentalPrice;
        while (true) {
            System.out.println("Rental price: ");
            try {
                inputRentalPrice = Double.parseDouble(scanner.nextLine());
                if (inputRentalPrice >= 0) {
                    break;
                } else {
                    System.out.println("Invalid rental price. Must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }

        Cars car = new Cars(inputBrand, inputModel, inputYearOfManufacture, inputColor, inputLicensePlate, inputMileage, inputRentalPrice);

        addCar(car);
    }


    public static void deleteCar(int carId) throws Exception {
        if (carId > getLastIdFromCsv("cars.csv")) {
            System.out.println("Invalid car ID.");
            return;
        }
        else if (carId < 0) {
            System.out.println("Invalid car ID.");
            return;
        }
        
        List<String> lines = Files.readAllLines(Paths.get("data/cars.csv"));
    
        List<String> newLines = new ArrayList<>();
        newLines.add(lines.get(0)); 
        
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(", ");
            if (parts.length > 0) {
                    int currentId = Integer.parseInt(parts[0].trim());
                    if (currentId != carId) {
                        newLines.add(line);
                    }
            }
        }
    
    
        Files.write(Paths.get("data/cars.csv"), newLines, 
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.WRITE);
    }

    public static void editCar(int carId) throws Exception {
        if (carId > getLastIdFromCsv("cars.csv")) {
            System.out.println("Invalid car ID.");
            return;
        }
        else if (carId < 0) {
            System.out.println("Invalid car ID.");
            return;
        }

        List<String> lines = Files.readAllLines(Paths.get("data/cars.csv"));
        Scanner scanner = new Scanner(System.in);
        
        List<String> newLines = new ArrayList<>();
        newLines.add(lines.get(0)); 
        
        
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(", ");
            int currentId = Integer.parseInt(parts[0].trim());
            
            if (currentId == carId) {
                if (parts[8].trim().equals("false")) {
                    System.out.println("Car with ID " + carId + " is not available for editing.");
                    return;
                }
                System.out.println("Editing car ID: " + carId);
                String[] newParts = getUpdatedCarData(parts, scanner);
                newLines.add(String.join(", ", newParts));
            } else {
                newLines.add(line);
                
            }
        }
        
        Files.write(Paths.get("data/cars.csv"), newLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("Car with ID " + carId + " updated successfully");
    }
    
    private static String[] getUpdatedCarData(String[] oldParts, Scanner scanner) {
        String[] newParts = new String[oldParts.length];
        newParts[0] = oldParts[0].trim();
        
        System.out.println("Current brand: " + oldParts[1].trim() + ". New brand (enter to keep):");
        newParts[1] = getInputOrDefault(scanner, oldParts[1].trim());
        
        System.out.println("Current model: " + oldParts[2].trim() + ". New model (enter to keep):");
        newParts[2] = getInputOrDefault(scanner, oldParts[2].trim());
        
        System.out.println("Current year of manufacture: " + oldParts[3].trim() + ". New year of manufacture (enter to keep):");
        newParts[3] = getInputOrDefault(scanner, oldParts[3].trim());

        System.out.println("Current color: " + oldParts[4].trim() + ". New color (enter to keep):");
        newParts[4] = getInputOrDefault(scanner, oldParts[4].trim());

        System.out.println("Current license plate: " + oldParts[5].trim() + ". New license plate (enter to keep):");
        newParts[5] = getInputOrDefault(scanner, oldParts[5].trim());

        System.out.println("Current mileage: " + oldParts[6].trim() + ". New mileage (enter to keep):");
        newParts[6] = getInputOrDefault(scanner, oldParts[6].trim());

        System.out.println("Current rental price: " + oldParts[7].trim() + ". New rental price (enter to keep):");
        newParts[7] = getInputOrDefault(scanner, oldParts[7].trim());
        
        newParts[8] = oldParts[8].trim(); 
        return newParts;
    }
    
    private static String getInputOrDefault(Scanner scanner, String defaultValue) {
        String input = scanner.nextLine(); 
        
        if (input.isEmpty()) {  
            return defaultValue; 
        } else {                
            return input;       
        }
    }
}
