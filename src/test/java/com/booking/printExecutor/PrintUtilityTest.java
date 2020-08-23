package com.booking.printExecutor;

import com.booking.enums.TicketType;
import com.booking.revenueGenerator.TotalRevenue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PrintUtilityTest {
    private final ByteArrayOutputStream outputConsoleData = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PrintUtility printHandler = new PrintUtility();



        @Test
        @DisplayName("should print total amount and taxes when booking counter shutdown without booking any tickets")
        void printDetails(){

            System.setOut(new PrintStream(outputConsoleData));
            printHandler.printTotalRevenue();
            assertEquals("Total Sales:\n" +
                    "Revenue: Rs.0.0\n" +
                    "Service Tax: Rs. 0.0\n" +
                    "Swachh Bharat Cess: Rs. 0.0\n" +
                    "Krishi Kalyan Cess: Rs. 0.0\n", outputConsoleData.toString());
        }

        @Test
        @DisplayName("should print total amount and taxes when book tickets and then shutdown")
        void printDetailsWithSeatsSelected(){
            TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();
            System.setOut(new PrintStream(outputConsoleData));
             revenueHandler.addRevenue(TicketType.PLATINUM.getPrice());
             printHandler.printTotalRevenue();
            assertEquals("Total Sales:\n" +
                    "Revenue: Rs.320.0\n" +
                    "Service Tax: Rs. 44.8\n" +
                    "Swachh Bharat Cess: Rs. 1.6\n" +
                    "Krishi Kalyan Cess: Rs. 1.6\n", outputConsoleData.toString());
        }
}