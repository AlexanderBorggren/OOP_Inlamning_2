import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    ReadFile() {
    }
    public List<Person> readFile(String path) {
        String line;
        List<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] firstLineSplit = line.split(", ");
                String personNummer = firstLineSplit[0];
                String name = firstLineSplit[1];

                String dateRegistered = br.readLine();
                personList.add(new Person(personNummer, name, dateRegistered));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return personList;
    }
    public Person findPerson(String searchValue, List<Person> personList) {
        for (Person person : personList) {
            if (person.getPersonnummer().equalsIgnoreCase(searchValue) || person.getName().equalsIgnoreCase(searchValue)) {
                return person;
            }
        }
        return null;
    }

}
