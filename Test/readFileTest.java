import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class readFileTest {

    @Test
    public void readFileTest() {
        ReadFile read = new ReadFile();
        List<Person> personList = read.readFile(Paths.get("Test/customers.txt").toString());

        assert(read.readFile("Test/customers.txt") != null);
        assertEquals(personList.size(), 3);
        Person firstPerson = personList.get(0);
        assertEquals("7703021234", firstPerson.getPersonnummer());
        assertEquals("Alhambra Aromes", firstPerson.getName());
        assertEquals("2023-07-01", firstPerson.getDatePaymentLastRegistered());

        Person lastPerson = personList.get(2);
        assertEquals("8512021234", lastPerson.getPersonnummer());
        assertEquals("Chamade Coriola", lastPerson.getName());
        assertEquals("2018-03-12", lastPerson.getDatePaymentLastRegistered());

    }

}
