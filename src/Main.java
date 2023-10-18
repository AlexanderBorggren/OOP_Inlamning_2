import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private ReadFile read;
    private CustomerStatus customerStatus;
    private List<Person> personList;
    private List<PT> ptList;

    public static void main(String[] args) {
        Main main = new Main();
        while(true) {
            main.run();
        }
    }
    public Main() {
        read = new ReadFile();
        customerStatus = new CustomerStatus();
        personList = new ArrayList<>();
        ptList = new ArrayList<>();
    }

    public void run() {
        personList = read.readFile("./src/customers.txt");
        String searchValue = askForInput();
        Person foundPerson = read.findPerson(searchValue, personList);

        if (foundPerson != null) {
            handleFoundPerson(foundPerson);
        } else {
            System.out.println("Kunden finns inte i filen, är ej behörig");
        }
    }

    public String askForInput() {
        System.out.println("Skriv kundens personnummer eller fullständiga namn: ");
        Scanner scan = new Scanner(System.in);
        String searchValue = scan.nextLine();
        searchValue = searchValue.trim();
        return searchValue;
    }

    public void handleFoundPerson(Person foundPerson) {
        String status = customerStatus.getCustomerStatus(foundPerson);
        System.out.println(status);
        if (status.contains("är en kund")) {
            ptList.add(new PT(foundPerson.getName(), foundPerson.getPersonnummer()));
            System.out.println("Lägger till kund till PT listan");
        }
    }
}
