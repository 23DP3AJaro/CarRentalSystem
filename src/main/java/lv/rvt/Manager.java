package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import lv.rvt.tools.Helper;

public class Manager {
    
    private static void addKlients(Klienti klients) throws Exception{
        BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.APPEND);


        writer.write(klients.getName() + ", " + klients.getSurname() + ", " + klients.getBirthDate()); 
        writer.newLine();
        writer.close();
    }

    private static void addCar(Cars car) throws Exception{
        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.APPEND);

        writer.write(car.getBrand() + ", " + car.getModel() + ", " +car.getColor() +", " + car.getLicensePlate() + ", " + car.getMileage() + ", " + car.getRentalPrice()); 
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

        System.out.println("Color: ");
        String inputColor = scanner.nextLine();

        System.out.println("License plate: ");
        String inputLicensePlate = scanner.nextLine();

        System.out.println("Mileage: ");
        int inputMileage = scanner.nextInt();

        System.out.println("Rental price: ");
        int inputRentalPrice = scanner.nextInt();
        
        Cars car = new Cars(inputBrand, inputModel, inputColor, inputLicensePlate, inputMileage, inputRentalPrice);

        addCar(car);
    }
}
