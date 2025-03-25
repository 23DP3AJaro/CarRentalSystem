package lv.rvt;

import java.io.BufferedReader;

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
        System.out.println("2. Statistika");
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
        System.out.println("2. Statistika");

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
        System.out.println("\n" + "1. Filtrēt mašīnas");
        System.out.println("2. Šķirot mašīnas");
        System.out.println("3. Atpakaļ");

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
        System.out.println("\n" + "1. Filtrēt mašīnas");
        System.out.println("2. Šķirot mašīnas");
        System.out.println("3. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionCarTable();
    }
}
