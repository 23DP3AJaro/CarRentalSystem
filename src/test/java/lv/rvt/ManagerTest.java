
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


        BufferedWriter carsWriter = Helper.getWriter("ForTests.csv", StandardOpenOption.TRUNCATE_EXISTING);
        carsWriter.write("id, brand, model, year_of_manufacture, color, license_plate, mileage, rental_price, available");
        carsWriter.newLine();
        carsWriter.write("1, Toyota, Corolla, 2020, White, 1.8, Automatic, 30000, true");
        carsWriter.newLine();
        carsWriter.write("2, Honda, Accord, 2019, Black, 2.0, Manual, 40000, true");
        carsWriter.close();

        assertEquals(2, Manager.getLastIdFromCsv("ForTests.csv"));


    }
        

}