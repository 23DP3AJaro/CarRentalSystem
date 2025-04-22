package lv.rvt;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import lv.rvt.tools.Helper;

public class UImethods {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void PrintCsvTable(String csv) throws Exception {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        BufferedReader reader = Helper.getReader(csv);
        String[] headers = reader.readLine().split(", ");
        int[] maxLengths = new int[headers.length];

        // Initialize maxLengths with header lengths
        for (int i = 0; i < headers.length; i++) {
            maxLengths[i] = headers[i].length();
        }

        // Read data and calculate max lengths for each column
        String line;
        StringBuilder dataBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(", ");
            dataBuilder.append(line).append("\n");
            for (int i = 0; i < values.length; i++) {
                maxLengths[i] = Math.max(maxLengths[i], values[i].length());
            }
        }

        // Print headers with proper spacing
        for (int i = 0; i < headers.length; i++) {
            System.out.printf(ANSI_GREEN + "%-" + (maxLengths[i] + 2) + "s" + ANSI_RESET, headers[i]);
            if (i < headers.length - 1) {
                System.out.print("|");
            }
        }
        System.out.println();

        // Print data rows with proper spacing
        String[] rows = dataBuilder.toString().split("\n");
        for (String row : rows) {
            String[] values = row.split(", ");
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%-" + (maxLengths[i] + 2) + "s", values[i]);
                if (i < values.length - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
    }

    public static void ChangePositionStatistics() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            Statistics.AverageMilleage();
            ChangePositionStatistics();
        } else if (position.equals("2")) {
            Statistics.Income();
            ChangePositionStatistics();
        } else if (position.equals("3")) {
            Statistics.AverageRentalPrice();
            ChangePositionStatistics();
        } else if (position.equals("4")) {
            Statistics.maxPrice();
            ChangePositionStatistics();
        } else if (position.equals("5")) {
            UI.MainMenu();
        } else {
            UI.ShowStatisticsIncorrectPosition();
            ChangePositionStatistics();
        }
    };

    public static void ChangePositionMainMenu() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            UI.ShowCarControl();
        } else if (position.equals("2")) {
            UI.ShowClientControl();
        } else if (position.equals("3")) {
            UI.ShowRentControl();
        } else if (position.equals("4")) {
            UI.ShowStatistics();
        } else {
            UI.MainMenuIncorrectPosition();
            ChangePositionMainMenu();
        }
    }

    public static void ChangePositionCarControl() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            UI.PrintCarsTable();

        } else if (position.equals("2")) {
            Manager.userAddCars();
            System.out.println("\n" + ANSI_GREEN + "Mašīna pievienota!" + ANSI_RESET);
            UI.ShowCarControl();
        } else if (position.equals("3")) {
            System.out.println("\n" + "Ievadiet mašīnas ID, kuru vēlaties izdzēst: ");
            int carId = Integer.valueOf(scanner.nextLine());
            System.out.println("\nVai vēlaties izdzēst mašīnu ar ID " + carId + "? (y/n)");
            String confirm = scanner.nextLine();
            while (!confirm.equals("y" ) && !confirm.equals("n")) {
                System.out.println("\nLūdzu ievadiet 'y' vai 'n': ");
                confirm = scanner.nextLine();
            }

            if (confirm.equals("y")) {
                Manager.deleteCar(carId);
                System.out.println(ANSI_RED + "\nMašīna ar ID " + carId + " tiks izdzēsta." + ANSI_RESET);
                TimeUnit.SECONDS.sleep(3);
            } else {
                
            }
            UI.ShowCarControl();
        } else if (position.equals("4")) {
            System.out.println("\nIevadiet mašīnas ID, kuru vēlaties rediģēt: ");
            int carId = Integer.valueOf(scanner.nextLine());
            Manager.editCar(carId);
            UI.ShowCarControl();
        } else if (position.equals("5")) {
            UI.MainMenu();
        } else {
            UI.ShowCarControlIncorrectPosition();
            ChangePositionCarControl();
        }
    }

    public static void ChangePositionClientControl() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            UI.PrintPersonTable();
        } else if (position.equals("2")) {
            Manager.userAddKlients();
            System.out.println("\n" + ANSI_GREEN + "Klients pievienots!" + ANSI_RESET);
            TimeUnit.SECONDS.sleep(3);
            UI.ShowClientControl();
        } else if (position.equals("3")) {
            Manager.deleteKlienti();
            System.out.println("\n" + ANSI_RED + "Klients tiks izdzēsts." + ANSI_RESET);
            TimeUnit.SECONDS.sleep(3);
            UI.ShowClientControl();
        } else if (position.equals("4")) {
            Manager.editKlients();
            System.out.println("\n" + ANSI_GREEN + "Klients rediģēts!" + ANSI_RESET);
            TimeUnit.SECONDS.sleep(3);
            UI.ShowClientControl();
        } else if (position.equals("5")) {
            UI.MainMenu();
        } else {
            UI.ShowClientControlIncorrectPosition();
            ChangePositionClientControl();
        }
    }

    public static void ChangePositionRentalTable() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            UI.RentalFilters();
        } else if (position.equals("2")) {
            UI.ShowRentControl();
        } else {
            UI.PrintRentalTableIncorrectPosition();
            ChangePositionRentalTable();
        }
    }

    public static void ChangePositionRent() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {
            UI.PrintRentalTable();
            
        } else if (position.equals("2")) {
            Rental.createRental();
            UI.ShowRentControl();
        } else if (position.equals("3")) {
            Manager.deleteRental();
            UI.ShowRentControl();
        } else if (position.equals("4")) {
            Manager.editRental();
            UI.ShowRentControl();
        } else if (position.equals("5")) {
            UI.MainMenu();
        } else {
            UI.ShowRentControlIncorrectPosition();
            ChangePositionRent();
        }
    }

    public static void ChangePositionCarTable() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");
        String position = scanner.nextLine();
        if (position.equals("1")) {
            UI.PrintCarsTableSearch();
            ChangePositionCarTable();
        } else if (position.equals("2")) {

        } else if (position.equals("3")) {
            UI.PrintSortedCars();
        } else if (position.equals("4")) {
            UI.ShowCarControl();
            ChangePositionCarControl();
        } else {
            UI.PrintCarsTableIncorrectPosition();
            ChangePositionMainMenu();
        }
    }

    public static void ChangePositionPersonTable() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");
        String position = scanner.nextLine();
        if (position.equals("1")) {
            UI.PrintPersonTableSearch();
        } else if (position.equals("2")) {

        } else if (position.equals("3")) {
            UI.ShowClientControl();
        } else {
            UI.PrintPersonTableIncorrectPosition();
            ChangePositionPersonTable();
        }
    }

}
