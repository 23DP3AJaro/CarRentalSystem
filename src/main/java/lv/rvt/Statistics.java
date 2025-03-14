package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import lv.rvt.tools.Helper;

public class Statistics {
    public static void AverageMilleage() throws Exception {
        BufferedReader reader = Helper.getReader("cars.csv");
        String line;
        reader.readLine();

        int sum = 0;
        int count = 0;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            
            sum = sum + Integer.parseInt(parts[4]);
            count++;
            }
            

        reader.close();

        System.out.println("Average milleage: " + sum / count);
        }
    };
