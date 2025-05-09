package lv.rvt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import lv.rvt.tools.Helper;


public class RentalTest {

    @Test
    public void testAddRentalToFile() throws Exception {
        BufferedWriter writer = Helper.getWriter("rental.csv", StandardOpenOption.TRUNCATE_EXISTING);
        writer.write("rental_id, client_id, car_id, start_date, end_date, total_price, is_active");
        writer.newLine();
        writer.close();

        Rental rental = new Rental(1, 1, "2023-02-01", "2023-02-10", 200.0);
        Manager.addRentalToFile(rental);

        BufferedReader reader = Helper.getReader("rental.csv");
        reader.readLine(); 
        String line = reader.readLine();
        reader.close();

        assertEquals("1, 1, 1, 2023-02-01, 2023-02-10, 200.0, true", line);
    }
}
