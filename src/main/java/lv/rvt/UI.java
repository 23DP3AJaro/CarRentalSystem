package lv.rvt;

import java.io.BufferedReader;
import java.util.Scanner;

import lv.rvt.tools.Helper;

public class UI {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void MainMenu() throws Exception {
        UImethods.clearScreen();
        System.out.println("______      _          ______           _                     _______");
        System.out.println("|  _  \\    (_)         | ___ \\         | |                   //  ||\\ \\");
        System.out.println("| | | |_ __ ___   _____| |_/ /___ _ __ | |_            _____//___||_\\ \\___");
        System.out.println("| | | | '__| \\ \\ / / _ \\    // _ \\ '_ \\| __|           )  _          _    \\");
        System.out.println("| |/ /| |  | |\\ V /  __/ |\\ \\  __/ | | | |_            |_/ \\________/ \\___|");
        System.out.println("|___/ |_|  |_| \\_/ \\___\\_| \\_\\___|_| |_|\\__|          ___\\_/________\\_/______");
        System.out.println();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Klientu pārvaldība");
        System.out.println("3. Nomas pārvaldība");
        System.out.println("4. Statistika");
        UImethods.ChangePositionMainMenu();
    }

    public static void MainMenuIncorrectPosition() throws Exception {
        UImethods.clearScreen();
        System.out.println("______      _          ______           _                     _______");
        System.out.println("|  _  \\    (_)         | ___ \\         | |                   //  ||\\ \\");
        System.out.println("| | | |_ __ ___   _____| |_/ /___ _ __ | |_            _____//___||_\\ \\___");
        System.out.println("| | | | '__| \\ \\ / / _ \\    // _ \\ '_ \\| __|           )  _          _    \\");
        System.out.println("| |/ /| |  | |\\ V /  __/ |\\ \\  __/ | | | |_            |_/ \\________/ \\___|");
        System.out.println("|___/ |_|  |_| \\_/ \\___\\_| \\_\\___|_| |_|\\__|          ___\\_/________\\_/______");
        System.out.println();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Klientu pārvaldība");
        System.out.println("3. Nomas pārvaldība");
        System.out.println("4. Statistika");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionMainMenu();
    }

    public static void ShowStatistics() throws Exception {

        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Statistika -> \n" + ANSI_RESET);
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionStatistics();
    }

    public static void ShowStatisticsIncorrectPosition() throws Exception {

        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Statistika -> \n" + ANSI_RESET);
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionStatistics();
    }

    public static void ShowCarControl() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Mašīnu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu saraksts");
        System.out.println("2. Pievienot mašīnu");
        System.out.println("3. Izdzēst mašīnu");
        System.out.println("4. Rediģēt mašīnu");
        System.out.println("5. Atpakaļ");

        UImethods.ChangePositionCarControl();
    }

    public static void ShowCarControlIncorrectPosition() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Mašīnu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu saraksts");
        System.out.println("2. Pievienot mašīnu");
        System.out.println("3. Izdzēst mašīnu");
        System.out.println("4. Rediģēt mašīnu");
        System.out.println("5. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionCarControl();
    }

    public static void ShowClientControl() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Klientu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Klientu saraksts");
        System.out.println("2. Pievienot klientu");
        System.out.println("3. Izdzēst klientu");
        System.out.println("4. Rediģēt klientu");
        System.out.println("5. Atpakaļ");

        UImethods.ChangePositionClientControl();
    }

    public static void ShowClientControlIncorrectPosition() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Klientu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Klientu saraksts");
        System.out.println("2. Pievienot klientu");
        System.out.println("3. Izdzēst klientu");
        System.out.println("4. Rediģēt klientu");
        System.out.println("5. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionClientControl();
    }

    public static void ShowRentControl() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Nomas pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Nomas vēsture");
        System.out.println("2. Pievienot nomu");
        System.out.println("3. Izdzēst nomu");
        System.out.println("4. Rediģēt nomu");
        System.out.println("5. Atpakaļ");

        UImethods.ChangePositionRent();
    }

    public static void ShowRentControlIncorrectPosition() throws Exception {
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Nomas pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Nomas vēsture");
        System.out.println("2. Pievienot nomu");
        System.out.println("3. Izdzēst nomu");
        System.out.println("4. Rediģēt nomu");
        System.out.println("5. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionRent();
    }

    public static void PrintCarsTable() throws Exception {
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| ID", "| Zīmols", "| Modelis",
                "| Ražošanas gads", "| Krāsa ", "| Numura zīme", "| Nobraukums", "| Nomas cena (€ diena)");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String brand;
            String model;
            Integer year;
            String color;
            String plate;
            Integer milleage;
            Double price;
            id = Integer.valueOf(parts[0]);
            brand = parts[1];
            model = parts[2];
            year = Integer.valueOf(parts[3]);
            color = parts[4];
            plate = parts[5];
            milleage = Integer.valueOf(parts[6]);
            price = Double.valueOf(parts[7]);

            System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| " + id, "| " + brand, "| " + model,
                    "| " + year, "| " + color, "| " + plate, "| " + milleage, "| " + price);
        }
        System.out.println("\n" + "1. Atrast mašīnu");
        System.out.println("2. Filtrēt mašīnas");
        System.out.println("3. Šķirot mašīnas");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionCarTable();
    }

    public static void PrintCarsTableIncorrectPosition() throws Exception {
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| ID", "| Zīmols", "| Modelis",
                "| Ražošanas gads", "| Krāsa ", "| Numura zīme", "| Nobraukums", "| Nomas cena (€ diena)");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String brand;
            String model;
            Integer year;
            String color;
            String plate;
            Integer milleage;
            Double price;
            id = Integer.valueOf(parts[0]);
            brand = parts[1];
            model = parts[2];
            year = Integer.valueOf(parts[3]);
            color = parts[4];
            plate = parts[5];
            milleage = Integer.valueOf(parts[6]);
            price = Double.valueOf(parts[7]);

            System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| " + id, "| " + brand, "| " + model,
                    "| " + year, "| " + color, "| " + plate, "| " + milleage, "| " + price);
        }
        System.out.println("\n" + "1. Atrast mašīnu");
        System.out.println("2. Filtrēt mašīnas");
        System.out.println("3. Šķirot mašīnas");
        System.out.println("4. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionCarTable();
    }

    public static void PrintCarsTableSearch() throws Exception {
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        String search;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ievadiet meklēšanas vārdu:");
        search = scanner.nextLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| ID", "| Zīmols", "| Modelis",
                "| Ražošanas gads", "| Krāsa ", "| Numura zīme", "| Nobraukums", "| Nomas cena (€ diena)");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String brand;
            String model;
            Integer year;
            String color;
            String plate;
            Integer milleage;
            Double price;
            id = Integer.valueOf(parts[0]);
            brand = parts[1];
            model = parts[2];
            year = Integer.valueOf(parts[3]);
            color = parts[4];
            plate = parts[5];
            milleage = Integer.valueOf(parts[6]);
            price = Double.valueOf(parts[7]);

            if (parts[0].equals(search) || parts[1].equals(search) || parts[2].equals(search) || parts[3].equals(search)
                    || parts[4].equals(search) || parts[5].equals(search) || parts[6].equals(search)
                    || parts[7].equals(search)) {
                System.out.printf("%-4s %-20s %-20s %-16s %-20s %-13s %-12s %-21s%n", "| " + id, "| " + brand,
                        "| " + model, "| " + year, "| " + color, "| " + plate, "| " + milleage, "| " + price);
            } else {
                
            }
        }
        System.out.println("\n" + "1. Atrast pec cita meklēšanas vārda");
        System.out.println("2. Atpakaļ");

        String position;
        System.out.println("\nIevadiet poziciju:");
        position = scanner.nextLine();

        while (true) {
            if (position.equals("1")) {
            PrintCarsTableSearch();
        } else if (position.equals("2")) {
            PrintCarsTable();
        } else {
            System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
            position = scanner.nextLine();
        }
        }
        
    }

    public static void PrintPersonTable() throws Exception {
        BufferedReader reader = Helper.getReader("klienti.csv");
        String line;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| ID", "| Vārds", "| Uzvārds", "| Tel. numurs", "|");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String name;
            String surname;
            String phone;
            id = Integer.valueOf(parts[0]);
            name = parts[1];
            surname = parts[2];
            phone = parts[3];

            System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| " + id, "| " + name, "| " + surname, "| " + phone,
                    "|");
        }
        System.out.println("\n" + "1. Atrast klientu");
        System.out.println("2. Sakārtot");
        System.out.println("3. Filtrēt");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionPersonTable();
    }

    public static void PrintPersonTableIncorrectPosition() throws Exception {
        BufferedReader reader = Helper.getReader("klienti.csv");
        String line;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| ID", "| Vārds", "| Uzvārds", "| Tel. numurs", "|");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String name;
            String surname;
            String phone;
            id = Integer.valueOf(parts[0]);
            name = parts[1];
            surname = parts[2];
            phone = parts[3];

            System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| " + id, "| " + name, "| " + surname, "| " + phone,
                    "|");
        }
        System.out.println("\n" + "1. Atrast klientu");
        System.out.println("2. Sakārtot");
        System.out.println("3. Filtrēt");
        System.out.println("4. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionPersonTable();
    }

    public static void PrintPersonTableSearch() throws Exception {
        BufferedReader reader = Helper.getReader("klienti.csv");
        String line;
        String search;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ievadiet meklēšanas vārdu:");
        search = scanner.nextLine();
        UImethods.clearScreen();

        System.out.println(ANSI_GREEN);
        System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| ID", "| Vārds", "| Uzvārds", "| Tel. numurs", "|");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            String name;
            String surname;
            String phone;
            id = Integer.valueOf(parts[0]);
            name = parts[1];
            surname = parts[2];
            phone = parts[3];

            if (parts[0].equals(search) || parts[1].equals(search) || parts[2].equals(search) || parts[3].equals(search)) {
                System.out.printf("%-6s %-20s %-20s %-22s %-1s%n", "| " + id, "| " + name, "| " + surname, "| " + phone,
                        "|");
            } else {
                
            }

            
        }
        
        System.out.println("\n" + "1. Atrast pec cita meklēšanas vārda");
        System.out.println("2. Atpakaļ");

        String position;
        System.out.println("\nIevadiet poziciju:");
        position = scanner.nextLine();

        while (true) {
            if (position.equals("1")) {
            PrintPersonTableSearch();
        } else if (position.equals("2")) {
            PrintPersonTable();
        } else {
            System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
            position = scanner.nextLine();
        }
        }
    }

    public static void PrintRentalTable() throws Exception {
        BufferedReader reader = Helper.getReader("rental.csv");
        String line;
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_YELLOW);
        System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "ID", "| Klienta ID", "| Mašīnas ID", "| Sakuma datums", "| Beiguma datums", "| Kopēja cena", "| Aktuālais statuss");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            Integer clientId;
            Integer carId;
            String startDate;
            String endDate;
            Double totalPrice;
            Boolean status;
            id = Integer.valueOf(parts[0]);
            clientId = Integer.valueOf(parts[1]);
            carId = Integer.valueOf(parts[2]);
            startDate = parts[3];
            endDate = parts[4];
            totalPrice = Double.valueOf(parts[5]);
            status = Boolean.valueOf(parts[6]);

            System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "" + id, "| " + clientId, "| " + carId, "| " + startDate, "| " + endDate, "| " + totalPrice, "| " + status);
        }

        System.out.println("\n"+"1. Filtrēt nomas");
        System.out.println("2. Atpakaļ");
        UImethods.ChangePositionRentalTable();
    }

    public static void PrintRentalTableIncorrectPosition() throws Exception {
        BufferedReader reader = Helper.getReader("rental.csv");
        String line;
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        reader.readLine();
        UImethods.clearScreen();

        System.out.println(ANSI_YELLOW);
        System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "ID", "| Klienta ID", "| Mašīnas ID", "| Sakuma datums", "| Beiguma datums", "| Kopēja cena", "| Aktuālais statuss");
        System.out.print(ANSI_RESET);

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");

            Integer id;
            Integer clientId;
            Integer carId;
            String startDate;
            String endDate;
            Double totalPrice;
            Boolean status;
            id = Integer.valueOf(parts[0]);
            clientId = Integer.valueOf(parts[1]);
            carId = Integer.valueOf(parts[2]);
            startDate = parts[3];
            endDate = parts[4];
            totalPrice = Double.valueOf(parts[5]);
            status = Boolean.valueOf(parts[6]);

            System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "" + id, "| " + clientId, "| " + carId, "| " + startDate, "| " + endDate, "| " + totalPrice, "| " + status);
        }

        System.out.println("\n" + "1. Filtrēt nomu");
        System.out.println("2. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionRentalTable();
    }

    public static void RentalFilters() throws Exception {
        BufferedReader reader = Helper.getReader("rental.csv");
        UImethods.clearScreen();
        System.out.println("1. Filtrēt pec aktualās");
        System.out.println("2. Filtrēt pec neaktualās");
        System.out.println("3. Atpakaļ");

        String position;
        String line;
        System.out.println("\nIevadiet poziciju:");
        Scanner scanner = new Scanner(System.in);
        position = scanner.nextLine();

        UImethods.clearScreen();

        if (position.equals("1")) {
            System.out.println(ANSI_YELLOW);
            System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "ID", "| Klienta ID", "| Mašīnas ID", "| Sakuma datums", "| Beiguma datums", "| Kopēja cena", "| Aktuālais statuss");
            System.out.print(ANSI_RESET);
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");

                Integer id;
                Integer clientId;
                Integer carId;
                String startDate;
                String endDate;
                Double totalPrice;
                Boolean status;
                id = Integer.valueOf(parts[0]);
                clientId = Integer.valueOf(parts[1]);
                carId = Integer.valueOf(parts[2]);
                startDate = parts[3];
                endDate = parts[4];
                totalPrice = Double.valueOf(parts[5]);
                status = Boolean.valueOf(parts[6]);

                if (status.equals(true)) {
                    System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "" + id, "| " + clientId, "| " + carId, "| " + startDate, "| " + endDate, "| " + totalPrice, "| " + "Aktuāls");
                }
            }

            System.out.println("\nENTER lai atgrieztos");
            String GoBack = scanner.nextLine();
            PrintRentalTable();
        } else if (position.equals("2")) {
            System.out.println(ANSI_YELLOW);
            System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "ID", "| Klienta ID", "| Mašīnas ID", "| Sakuma datums", "| Beiguma datums", "| Kopēja cena", "| Aktuālais statuss");
            System.out.print(ANSI_RESET);
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");

                Integer id;
                Integer clientId;
                Integer carId;
                String startDate;
                String endDate;
                Double totalPrice;
                Boolean status;
                id = Integer.valueOf(parts[0]);
                clientId = Integer.valueOf(parts[1]);
                carId = Integer.valueOf(parts[2]);
                startDate = parts[3];
                endDate = parts[4];
                totalPrice = Double.valueOf(parts[5]);
                status = Boolean.valueOf(parts[6]);

                if (status.equals(false)) {
                    System.out.printf("%-6s %-14s %-15s %-22s %-22s %-16s %-21s%n", "" + id, "| " + clientId, "| " + carId, "| " + startDate, "| " + endDate, "| " + totalPrice, "| " + "Nav aktuāls");
                }
            }

            System.out.println("\nENTER lai atgrieztos");
            String GoBack = scanner.nextLine();
            PrintRentalTable();
        } else if (position.equals("3")) {
            PrintRentalTable();
        } else {
            System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
            RentalFilters();
        }
    }
}