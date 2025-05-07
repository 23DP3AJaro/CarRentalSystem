
package lv.rvt;
import lv.rvt.tools.Helper;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;



public class ManagerTest {

    @Test
    public void testGetLastIdFromCsv() throws Exception {

        int lastId = Manager.getLastIdFromCsv("cars.csv");

        assertEquals(1, lastId);
    }

    @Test
    public void testAddRentalToFile() throws Exception {

        Rental rental = new Rental(1, 1, "2023-01-01", "2023-01-10", 100.0);


        Manager.addRentalToFile(rental);

        BufferedReader reader = Helper.getReader("rental.csv");
        reader.readLine(); 

        String line = reader.readLine();
        reader.close();
        assertEquals("1, 1, 1, 2023-01-01, 2023-01-10, 100.0, true", line);
    }

    @Test
    public void testDeleteCar() throws Exception {

        BufferedWriter writer = Helper.getWriter("cars.csv", StandardOpenOption.APPEND);
        writer.write("90, Honda, Civic, 2019, Black, XYZ789, 60000, 45.0, true");
        writer.newLine();
        writer.close();


        Manager.deleteCar(90);


        BufferedReader reader = Helper.getReader("cars.csv");
        reader.readLine(); 
        String line = reader.readLine();
        reader.close();
        assertEquals("1, Toyota, Camry, 2020, Blue, ABC1234, 15000, 50.0, true", line);
    }

}