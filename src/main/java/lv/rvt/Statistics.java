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
        
        //if ((line = reader.readLine()) == null) {
        //    System.out.println(ANSI_RED + "Nav datu" + ANSI_RESET);
        //    count = -1;
        //} else {
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
        //}
        
        if (count == -1 || count == 0) {
            System.out.println(ANSI_RED + "Nav datu" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Vidējais nobraukums: " + ANSI_RESET + sum / count);
        }
        
        }
    };
