class Person {

    private String personnummer;
    private String name;
    private String datePaymentLastRegistered;

    Person(String personnummer, String name, String dateRegistered) {
        this.personnummer = personnummer;
        this.name = name;
        this.datePaymentLastRegistered = dateRegistered;
    }
    Person(String personnummer, String name) {
        this.personnummer = personnummer;
        this.name = name;

    }
    @Override
    public String toString() {
        return personnummer + ", " + name + "\n" + datePaymentLastRegistered;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public String getName() {
        return name;
    }

    public String getDatePaymentLastRegistered() {
        return datePaymentLastRegistered;
    }
}