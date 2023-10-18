import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class PTTest {

    @Test
    void testConstructor() {
        PT pt = new PT("Test Name", "1234567890");
        assertEquals("Test Name", pt.getName());
        assertEquals("1234567890", pt.getPersonnummer());
    }

    @Test
    void testToString() {
        PT pt = new PT("Test tester", "1234567890");
        String expected = "Personnummer: 1234567890 | Namn: Test tester | Var senast på gymmet: " + pt.dateAtGym +
                "\n-----------------------------------------------------------------------------------------\n";
        assertEquals(expected, pt.toString());
    }
    @Test
    void testPrintToFile() {
        PT pt = new PT("Test teser", "1234567890");
        // Skriv ut objektet till en fil
        pt.printToFile();

        try (BufferedReader reader = new BufferedReader(new FileReader("./src/PT.txt"))) {
            String lastLine = "", line;

            // Läs filen rad för rad
            while ((line = reader.readLine()) != null) {
                lastLine = line;
                if ((line = reader.readLine()) != null) {
                    lastLine += "\n" + line + "\n";
                }
            }

            // Kontrollera att det som skrivits till filen matchar objektets toString-metod
            assertEquals(pt.toString(), lastLine);
        } catch (IOException e) {
            // Om något går fel, misslyckas testet med ett felmeddelande
            fail("Error: " + e.getMessage());
        } finally {
            try {
                // Försök att ta bort filen, oavsett om testet lyckades eller inte
                Files.deleteIfExists(Paths.get("./src/PT.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}