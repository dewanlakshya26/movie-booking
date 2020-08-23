import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DriveCustomerTest {


    DriveCustomer driveCustomerInstance;
    Map<String, Enums.TicketType> audi;
    private final ByteArrayOutputStream outputConsoleData = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeAll
    void init() {
        System.setOut(new PrintStream(outputConsoleData));
        driveCustomerInstance = new DriveCustomer();
        audi = new HashMap<>();
    }

    @AfterAll
     void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("system should shutDown if no seats are available in selected auditorium")
    void shouldShutDown() throws Exception {
        SystemLambda.catchSystemExit(() ->
                driveCustomerInstance.checkAvailableSeats(Collections.emptyMap()));
    }

    @Test
    @DisplayName("exit the system when shutdown is called and print the total revenue and tax details")
    void printRevenueDetails() throws Exception {

        SystemLambda.catchSystemExit(() -> {
            driveCustomerInstance.shutDown();
            assertEquals("Shutting down the booking counter", outputConsoleData.toString());
            Mockito.verify(driveCustomerInstance, Mockito.times(1)).shutDown();
        });
    }






}