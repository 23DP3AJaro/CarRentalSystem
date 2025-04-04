package lv.rvt;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import lv.rvt.tools.Helper;

public class UImethods {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

        } else if (position.equals("3")) {

        } else if (position.equals("4")) {
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

        } else if (position.equals("3")) {

        } else if (position.equals("4")) {

        } else if (position.equals("5")) {
            UI.MainMenu();
        } else {
            UI.ShowClientControlIncorrectPosition();
            ChangePositionClientControl();
        }
    }

    public static void ChangePositionRent() throws Exception {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIevadiet poziciju: ");

        String position = scanner.nextLine();

        if (position.equals("1")) {

        } else if (position.equals("2")) {

        } else if (position.equals("3")) {

        } else if (position.equals("4")) {

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
            
        } else if (position.equals("4")) {
            UI.ShowClientControl();
        } else {
            UI.PrintPersonTableIncorrectPosition();
            ChangePositionPersonTable();
        }
    }

}
