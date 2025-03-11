package lv.rvt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;

import lv.rvt.tools.Helper;

public class Manager {
    
    public static void addKlients(Klienti klients) throws Exception{
        BufferedWriter writer = Helper.getWriter("klienti.csv", StandardOpenOption.APPEND);

        writer.newLine();
        writer.write(klients.getName() + ", " + klients.getSurname() + ", " + klients.getBirthDate()); 
        writer.close();
    }

    public static void addCar(Cars car) throws Exception{
        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.APPEND);

        writer.newLine();
        writer.write(car.getBrand() + ", " + car.getModel() + ", " + car.getLicensePlate() + ", " + car.getMileage()); 
        writer.close();
    }
}
