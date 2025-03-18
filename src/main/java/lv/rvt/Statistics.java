package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import lv.rvt.tools.Helper;

public class Statistics {
    public static void AverageMilleage() throws Exception {
        final String ANSI_RESET = "\u001B[0m"; 
        final String ANSI_GREEN = "\u001B[32m"; 

        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        reader.readLine();

        Integer sum = 0;
        Integer count = 0;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            
            sum = sum + Integer.parseInt(parts[5]);
            count++;
            }
            

        reader.close();
        
        if (count.equals(0)) {
            System.out.println(ANSI_GREEN + "Nav datu" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Vidējais nobraukums: " + ANSI_RESET + sum / count);
        }
        
        }
    };
