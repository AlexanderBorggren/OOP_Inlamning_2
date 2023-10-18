import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerStatusTest {

        @Test
        void testGetCustomerStatus() {
            CustomerStatus customerStatus = new CustomerStatus();
            Person person = new Person("1234567890", "Test Name", "2023-07-01");

            String status = customerStatus.getCustomerStatus(person);
            assertTrue(status.contains("är en kund"));
            assertFalse(status.contains("har varit en kund tidigare"));
        }

        @Test
        void testGetCustomerStatusInvalidDate() {
            CustomerStatus customerStatus = new CustomerStatus();
            Person person = new Person("1234567890", "Test Name", "invalid-date");

            String status = customerStatus.getCustomerStatus(person);
            assertEquals("Error: Invalid date format for Test Name", status);
        }
    }

