package com.booking.printExecutor;

import com.booking.model.CustomerBillModel;
import com.booking.model.TotalBillModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintUtilityTest {

    private final ByteArrayOutputStream outputConsoleData = new ByteArrayOutputStream();
    private PrintUtility printHandler = new PrintUtility();


    @Test
    @DisplayName("should print total amount and taxes when booking counter shutdown without booking any tickets")
    void printDetails() {
        TotalBillModel emptyTotalBuildModel = new TotalBillModel(0.0, 0.0, 0.0, 0.0);

        System.setOut(new PrintStream(outputConsoleData));
        printHandler.printTotalRevenue(emptyTotalBuildModel);
        assertEquals("Total Sales:\n" +
                "Revenue: Rs. 0.0\n" +
                "Service Tax: Rs. 0.0\n" +
                "Swachh Bharat Cess: Rs. 0.0\n" +
                "Krishi Kalyan Cess: Rs. 0.0\n", outputConsoleData.toString());
    }

    @Test
    @DisplayName("should print total amount and taxes when book tickets and then shutdown")
    void printDetailsWithSeatsSelected() {
        TotalBillModel totalBillModelDummy = new TotalBillModel(14.0, 0.5, 0.5, 100.0);
        System.setOut(new PrintStream(outputConsoleData));
        printHandler.printTotalRevenue(totalBillModelDummy);
        assertEquals("Total Sales:\n" +
                "Revenue: Rs. 100.0\n" +
                "Service Tax: Rs. 14.0\n" +
                "Swachh Bharat Cess: Rs. 0.5\n" +
                "Krishi Kalyan Cess: Rs. 0.5\n", outputConsoleData.toString());
    }

    @Test
    @DisplayName("should print total amount and taxes when ticket is booked")
    void printCustomerDetails() {
        CustomerBillModel dummyCustomerBillModel = new CustomerBillModel(39.2, 1.4, 1.4, 280, 322);

        System.setOut(new PrintStream(outputConsoleData));
        printHandler.printCustomerBill(dummyCustomerBillModel);
        assertEquals("Subtotal: Rs. 280.0\n" +
                "Service Tax @14%: Rs. 39.2\n" +
                "Swachh Bharat Cess @0.5%: Rs. 1.4\n" +
                "Krishi Kalyan Cess @0.5%: Rs. 1.4\n" +
                "Total: Rs.322.0\n", outputConsoleData.toString());
    }
}