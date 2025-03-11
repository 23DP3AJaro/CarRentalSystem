package lv.rvt;

import java.util.*;


public class Main 
{
    public static void main( String[] args ) throws Exception
    {
     
        Klienti klients = new Klienti("Artjoms", "Jarockis", 040707);
        Cars car = new Cars("BMW", "M5", "Red", "MM-5643", 6345);

        Manager.addKlients(klients);
        Manager.addCar(car);
    }
}
