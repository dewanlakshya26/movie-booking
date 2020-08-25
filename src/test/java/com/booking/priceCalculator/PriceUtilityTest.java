package com.booking.priceCalculator;

import com.booking.model.CustomerBillModel;
import com.booking.model.enums.TicketType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceUtilityTest {
    private PriceUtility priceHandler = new PriceUtility();


    @Test
    @DisplayName("service tax should be 14 percent")
    void checkServiceTest() {
        double serviceTax = priceHandler.getServiceTax(100.0);
        assertEquals(14.0, serviceTax);
    }

    @Test
    @DisplayName("swacch bharat tax should be 0.5 percent")
    void checkSwatchBharatTest() {
        double swatchBharatTax = priceHandler.getSwachhBharatTax(100.0);
        assertEquals(0.5, swatchBharatTax);
    }

    @Test
    @DisplayName("krishi kalyan tax should be 0.5 percent")
    void checkKrishiKalyanTest() {
        double krishiKalyanTax = priceHandler.getKrishiKalyanTax(100.0);
        assertEquals(0.5, krishiKalyanTax);
    }

    @Test
    @DisplayName("should be able to get price after selecting movie seats")
    void getPriceAfterSeatSelection() {
        Map<String, TicketType> movieList = new HashMap<>();
        movieList.put("B1", TicketType.GOLD);
        Set<String> selectedSeat = new HashSet<>();
        selectedSeat.add("B1");
        double price = priceHandler.getPrice(movieList, selectedSeat);
        assertEquals(280, price);

    }

    @Test
    @DisplayName("should give customer details model when provided with seat numbers")
    void getCustomerDetailedModel() {
        CustomerBillModel expectedCustomerBillModel = new CustomerBillModel(39.2, 1.4, 1.4, 280.0, 321.99999999999994);
        Map<String, TicketType> movieList = new HashMap<>();
        movieList.put("B1", TicketType.GOLD);
        Set<String> selectedSeat = new HashSet<>();
        selectedSeat.add("B1");
        CustomerBillModel customerBillModel = priceHandler.getPriceForSelectedSeats(movieList, selectedSeat);
        assertEquals(expectedCustomerBillModel, customerBillModel);

    }
}