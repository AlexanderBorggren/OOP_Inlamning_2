import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PT extends Person {
    String dateAtGym;
    List<Person> PTList = new ArrayList<>();

    PT(String name, String personnummer) {
        super(personnummer, name);
        LocalDateTime currentDateTime = java.time.LocalDateTime.now();
        this.dateAtGym = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        PTList.add(this);
        printToFile();
    }
    @Override
    public String toString(){
        return "Personnummer: " + getPersonnummer() + " | Namn: " + getName() + " | Var senast på gymmet: " + this.dateAtGym +
                "\n-----------------------------------------------------------------------------------------\n";
    }

    void printToFile() {
        try (FileWriter writer = new FileWriter("./src/PT.txt", true)) {
            for (Person person : PTList) {
                writer.write(person.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
