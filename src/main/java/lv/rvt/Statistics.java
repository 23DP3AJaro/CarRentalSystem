package lv.rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import lv.rvt.tools.Helper;

public class Statistics {
    public static void AverageMilleage() throws Exception {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        reader.readLine();

        Integer sum = 0;
        Integer count = 0;

        // if ((line = reader.readLine()) == null) {
        // System.out.println(ANSI_RED + "Nav datu" + ANSI_RESET);
        // count = -1;
        // } else {
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 1) {
                System.out.println(ANSI_RED + "Nav datu" + ANSI_RESET);
                count = -1;
                break;
            } else {
                sum = sum + Integer.parseInt(parts[6]);
                count = count + 1;
            }

        }
        // }

        if (count == -1 || count == 0) {
            System.out.println(ANSI_RED + "Nav datu" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Vidējais nobraukums: " + ANSI_RESET + sum / count);
        }

    }

    public static void Income() throws Exception {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        BufferedReader reader = Helper.getReader("rental.csv");
        String line;
        Double totalSum = 0.0;
        reader.readLine();

        while((line = reader.readLine()) != null){
            String[] parts = line.split(", ");

            totalSum = totalSum + Double.parseDouble(parts[5]);
        }

        System.out.println(ANSI_GREEN + "Kopējā peļņa: " + ANSI_RESET + totalSum + " EUR");
    }

    public static void AverageRentalPrice() throws Exception {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        Double sum = 0.0;
        Integer count = 0;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            sum = sum + Double.parseDouble(parts[7]);
            count = count + 1;
        }

        System.out.println(ANSI_GREEN + "Vidējā nomas cena: " + ANSI_RESET + (sum / count) + " EUR");
    }

    public static void maxPrice() throws Exception {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        reader.readLine();
        Double sum = 0.0;

        for (int i = 0; i<1; i++) {
            line = reader.readLine();
            String[] parts = line.split(", ");
            sum = Double.parseDouble(parts[7]);
        }

        while((line = reader.readLine()) != null){
            String[] parts = line.split(", ");
            
            if (sum < Double.parseDouble(parts[7])) {
                sum = Double.parseDouble(parts[7]);
            }
        }

        System.out.println(ANSI_GREEN + "Maksimālā nomas cena: " + ANSI_RESET + sum + " EUR" );
    }
};
