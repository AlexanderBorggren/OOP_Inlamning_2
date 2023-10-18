import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CustomerStatus {
    // En konstant som representerar antalet giltiga månader för en kund
    private static final long VALID_MONTHS = 12;
    public String getCustomerStatus(Person person) {
        // Hämtar dagens datum
        LocalDate currentDate = LocalDate.now();

        try {
            // Omvandlar personens senaste betalningsdatum från en sträng till ett LocalDate-objekt
            LocalDate datePaymentLastRegistered = LocalDate.parse(person.getDatePaymentLastRegistered());

            // Räknar ut antalet månader mellan personens senaste betalningsdatum och dagens datum
            long monthsBetween = ChronoUnit.MONTHS.between(datePaymentLastRegistered, currentDate);

            // Om det är mindre än VALID_MONTHS sedan personen senast betalade, anses de vara en nuvarande kund
            if (monthsBetween < VALID_MONTHS) {
                return person.getName() + " är en kund";
            }
            else {
                return person.getName() + " har varit en kund tidigare";
            }
        } catch (DateTimeParseException e) {
            // Hanterar eventuella fel vid omvandling av datumsträngen
            return "Error: Invalid date format for " + person.getName();
        }
    }
}
