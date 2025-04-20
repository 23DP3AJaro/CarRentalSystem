package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardCopyOption;
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


        writer.write(klients.getId() + ", " + klients.getName() + ", " + klients.getSurname() + ", " + klients.getPhoneNumber()); 
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

        System.out.println("Vards: ");
        String inputName = scanner.nextLine();

        System.out.println("Uzvards: ");
        String inputSurname = scanner.nextLine();

        System.out.println("Phone number: "); 
        String inputPhoneNumber = scanner.nextLine();
        
        Klienti klients = new Klienti(inputName, inputSurname, inputPhoneNumber);

        addKlients(klients);
    }

    public static void userAddCars() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Brands: ");
        String inputBrand = scanner.nextLine();

        System.out.println("Modelis: ");
        String inputModel = scanner.nextLine();

        int inputYearOfManufacture;
        while (true) {
            System.out.println("Ražots gads: ");
            try {
                inputYearOfManufacture = Integer.parseInt(scanner.nextLine());
                break;
                
                
            } catch(NumberFormatException e){
                System.out.println("Nepareizs ievads. Ievadiet skaitli.");
            }
        }

        System.out.println("Krasa: ");
        String inputColor = scanner.nextLine();

        System.out.println("Numurs: ");
        String inputLicensePlate = scanner.nextLine();

        int inputMileage;
        while (true) {
            System.out.println("Nobraukums: ");
            try {
                inputMileage = Integer.parseInt(scanner.nextLine());
                if (inputMileage >= 0) {
                    break;
                } else {
                    System.out.println("Nepareizs nobraukums. Tam jabut pozitīvam skaitlim.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nepareizs ievads. Ievadiet skaitli.");
            }
        }

        double inputRentalPrice;
        while (true) {
            System.out.println("Iznomāšanas cena: ");
            try {
                inputRentalPrice = Double.parseDouble(scanner.nextLine());
                if (inputRentalPrice >= 0) {
                    break;
                } else {
                    System.out.println("Nepareiza cena. Tam jabut pozitīvam skaitlim.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nepareizs ievads. Ievadiet skaitli.");
            }
        }

        Cars car = new Cars(inputBrand, inputModel, inputYearOfManufacture, inputColor, inputLicensePlate, inputMileage, inputRentalPrice);

        addCar(car);
    }


    public static void deleteCar(int carId) throws Exception {
        
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
            if (parts.length > 0) {
                int currentId = Integer.parseInt(parts[0].trim());
                if (currentId != carId) {
                    newLines.add(line);
                }
            }
        }

        reader.close();

        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.TRUNCATE_EXISTING);

        for (int i = 0; i < newLines.size(); i++) {
            String l = newLines.get(i);
            writer.write(l);
            writer.newLine();
        }

        writer.close();
    }


    public static void editCar(int carId) throws Exception {
        if (carId > Manager.getLastIdFromCsv("cars.csv") || carId < 0) {
            System.out.println("Nepareizi auto ID.");
            return;
        }

        BufferedReader reader = Helper.getReader("cars.csv");
        Scanner scanner = new Scanner(System.in);

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
                if (parts[8].trim().equals("false")) {
                    System.out.println("Auto ar ID " + carId + " nav pieejams rediģēšanai.");
                    reader.close();
                    return;
                }

                System.out.println("Rediģē auto ID: " + carId);
                String[] newParts = getUpdatedCarData(parts, scanner);
                newLines.add(String.join(", ", newParts));
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
    
    private static String[] getUpdatedCarData(String[] oldParts, Scanner scanner) {
        String[] newParts = new String[oldParts.length];
        newParts[0] = oldParts[0].trim();
        
        System.out.println("Pašreizējais brands: " + oldParts[1].trim() + ". Jauns brands (nospiediet Enter, lai saglabātu esošo):");
        newParts[1] = getInputOrDefault(scanner, oldParts[1].trim());
        
        System.out.println("Pašreizējais modelis: " + oldParts[2].trim() + ". Jauns modelis (nospiediet Enter, lai saglabātu esošo):");
        newParts[2] = getInputOrDefault(scanner, oldParts[2].trim());
        
        System.out.println("Pašreizējais ražošanas gads: " + oldParts[3].trim() + ". Jauns ražošanas gads (nospiediet Enter, lai saglabātu esošo):");
        newParts[3] = getInputOrDefault(scanner, oldParts[3].trim());

        System.out.println("Pašreizējā krāsa: " + oldParts[4].trim() + ". Jauna krāsa (nospiediet Enter, lai saglabātu esošo):");
        newParts[4] = getInputOrDefault(scanner, oldParts[4].trim());

        System.out.println("Pašreizējais numura zīme: " + oldParts[5].trim() + ". Jauna numura zīme (nospiediet Enter, lai saglabātu esošo):");
        newParts[5] = getInputOrDefault(scanner, oldParts[5].trim());

        System.out.println("Pašreizējais nobraukums: " + oldParts[6].trim() + ". Jauns nobraukums (nospiediet Enter, lai saglabātu esošo):");
        newParts[6] = getInputOrDefault(scanner, oldParts[6].trim());

        System.out.println("Pašreizējā iznomāšanas cena: " + oldParts[7].trim() + ". Jauna iznomāšanas cena (nospiediet Enter, lai saglabātu esošo):");
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




public static void deleteKlienti() throws Exception {
    
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ievadiet klients ID, kuru vēlaties dzēst: ");
    int klientsId = Integer.parseInt(scanner.nextLine());

    if (klientsId > Manager.getLastIdFromCsv("klienti.csv") || klientsId < 0) {
        System.out.println("Nepareizi klients ID.");
        return;
    }

    BufferedReader reader = Helper.getReader("klienti.csv");

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
        if (parts.length > 0) {
            int currentId = Integer.parseInt(parts[0].trim());
            if (currentId != klientsId) {
                newLines.add(line);
            }
        }
    }

    reader.close();

    BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.TRUNCATE_EXISTING);
    for (int i = 0; i < newLines.size(); i++) {
        writer.write(newLines.get(i));
        writer.newLine();
    }
    writer.close();

    System.out.println("Klients ar ID " + klientsId + " veiksmīgi izdzēsts.");
}

public static void editKlients() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ievadiet klients ID, kuru vēlaties rediģēt: ");
    int klientsId = Integer.parseInt(scanner.nextLine());

    if (klientsId > Manager.getLastIdFromCsv("klienti.csv") || klientsId < 0) {
        System.out.println("Nepareizi klients ID.");
        return;
    }

    BufferedReader reader = Helper.getReader("klienti.csv");

    List<String> newLines = new ArrayList<>();
    String line;
    boolean isFirstLine = true;

    while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
            newLines.add(line); 
            isFirstLine = false;
            continue;
        }

        String[] parts = line.split(",\\s*");
        int currentId = Integer.parseInt(parts[0].trim());

        if (currentId == klientsId) {
            System.out.println("Rediģēt klienta ID: " + klientsId);
            String[] newParts = getUpdatedKlientsData(parts, scanner);
            newLines.add(String.join(", ", newParts));
        } else {
            newLines.add(line);
        }
    }

    reader.close();

    BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.TRUNCATE_EXISTING);
    for (int i = 0; i < newLines.size(); i++) {
        writer.write(newLines.get(i));
        writer.newLine();
    }
    writer.close();

    System.out.println("Klients ar ID " + klientsId + " veiksmīgi atjaunots!");
}

private static String[] getUpdatedKlientsData(String[] oldParts, Scanner scanner) {
    String[] newParts = new String[oldParts.length];
    newParts[0] = oldParts[0].trim();
    
    System.out.println("Pašreizējais vārds: " + oldParts[1].trim() + ". Jauns vārds (nospiediet Enter, lai saglabātu esošo):");
    newParts[1] = getInputOrDefault(scanner, oldParts[1].trim());
    
    System.out.println("Pašreizējais uzvārds: " + oldParts[2].trim() + ". Jauns uzvārds (nospiediet Enter, lai saglabātu esošo):");
    newParts[2] = getInputOrDefault(scanner, oldParts[2].trim());
    
    System.out.println("Pašreizējais tālruņa numurs: " + oldParts[3].trim() + ". Jauns tālruņa numurs (nospiediet Enter, lai saglabātu esošo):");
    newParts[3] = getInputOrDefault(scanner, oldParts[3].trim());
    return newParts;
}


public static void deleteRental() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ievadiet iznomāšanas ID, kuru vēlaties dzēst: ");
    int rentalId = Integer.parseInt(scanner.nextLine());

    if (rentalId > Manager.getLastIdFromCsv("rental.csv") || rentalId < 0) {
        System.out.println("Nepareizi iznomāšanas ID.");
        return;
    }

    BufferedReader reader = Helper.getReader("rental.csv");

    List<String> newLines = new ArrayList<>();
    String line;
    boolean isFirstLine = true;

    while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
            newLines.add(line); // заголовок
            isFirstLine = false;
            continue;
        }

        String[] parts = line.split(",\\s*");
        if (parts.length > 0) {
            int currentId = Integer.parseInt(parts[0].trim());
            if (currentId != rentalId) {
                newLines.add(line);
            }
        }
    }

    reader.close();

    BufferedWriter writer = Helper.getWriter("rental.csv", StandardOpenOption.TRUNCATE_EXISTING);
    for (int i = 0; i < newLines.size(); i++) {
         writer.write(newLines.get(i));
         writer.newLine();
    }
    writer.close();

    System.out.println("Iznomāšana ar ID " + rentalId + " veiksmīgi izdzēsta!");
}

public static void editRental() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ievadiet iznomāšanas ID, kuru vēlaties rediģēt: ");
    int rentalId = Integer.parseInt(scanner.nextLine());

    if (rentalId > Manager.getLastIdFromCsv("rental.csv") || rentalId < 0) {
        System.out.println("Nepareizi iznomāšanas ID.");
        return;
    }

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

        String[] parts = line.split(",\\s*");
        int currentId = Integer.parseInt(parts[0].trim());

        if (currentId == rentalId) {
            if (parts[6].trim().equals("true")) {
                System.out.println("Iznomāšana ar ID " + rentalId + " nav pieejama rediģēšanai.");
                reader.close();
                return;
            }

            System.out.println("Rediģē iznomāšanas ID: " + rentalId);
            String[] newParts = getUpdatedRentalData(parts, scanner);
            newLines.add(String.join(", ", newParts));
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

    System.out.println("Iznomāšana ar ID " + rentalId + " veiksmīgi atjaunota");
}

private static String[] getUpdatedRentalData(String[] oldParts, Scanner scanner) {
    String[] newParts = new String[oldParts.length];
    newParts[0] = oldParts[0].trim();
    
    newParts[1] = oldParts[1].trim(); 
    
    newParts[2] = oldParts[2].trim(); 
    
    System.out.println("Pašreizējais sākuma datums: " + oldParts[3].trim() + ". Jauns sākuma datums (nospiediet Enter, lai saglabātu esošo):");
    newParts[3] = getInputOrDefault(scanner, oldParts[3].trim());

    System.out.println("Pašreizējais beigu datums: " + oldParts[4].trim() + ". Jauns beigu datums (nospiediet Enter, lai saglabātu esošo):");
    newParts[4] = getInputOrDefault(scanner, oldParts[4].trim());

    System.out.println("Pašreizējā kopējā cena: " + oldParts[5].trim() + ". Jauna kopējā cena (nospiediet Enter, lai saglabātu esošo):");
    newParts[5] = getInputOrDefault(scanner, oldParts[5].trim());
    
    newParts[6] = oldParts[6].trim(); 
    return newParts;
}}