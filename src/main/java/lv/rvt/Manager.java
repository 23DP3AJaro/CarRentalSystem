package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import lv.rvt.tools.Helper;
public class Manager {

    public static int getLastIdFromCsv(String filename) throws Exception {
        
        BufferedReader reader = Helper.getReader(filename);
        String line;
        int lastId = 0;

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0) { 
                int currentId = Integer.parseInt(parts[0].trim()); 
                if (currentId > lastId) {
                    lastId = currentId;
                }
            }
        }

        return lastId;
    }

    
    private static void addKlients(Klienti klients) throws Exception{
        BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.APPEND);


        writer.write(klients.getId() + ", " + klients.getName() + ", " + klients.getSurname() + ", " + klients.getBirthDate()); 
        writer.newLine();
        writer.close();
    }

    private static void addCar(Cars car) throws Exception{
        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.APPEND);

        writer.write(car.getId() + ", " + car.getBrand() + ", " + car.getModel() + ", "  + car.getYearOfManufacture() + ", "+ car.getColor() +", " + car.getLicensePlate() + ", " + car.getMileage() + ", " + car.getRentalPrice()); 
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

        int inputRentalPrice;
        while (true) {
            System.out.println("Rental price: ");
            try {
                inputRentalPrice = Integer.parseInt(scanner.nextLine());
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
}
