package com.booking.printExecutor;

import com.booking.enums.TicketType;
import com.booking.priceCalculator.PricesUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceUtilityTest {


    @Test
    @DisplayName("service tax should be 14 percent")
    void checkServiceTest() {
        double serviceTax = PricesUtility.getServiceTax(100.0);
        assertEquals(14.0, serviceTax);
    }

    @Test
    @DisplayName("swatch bharat tax should be 0.5 percent")
    void checkSwatchBharatTest() {
        double swatchBharatTax = PricesUtility.getSwachhBharatTax(100.0);
        assertEquals(0.5, swatchBharatTax);
    }

    @Test
    @DisplayName("krishi kalyan tax should be 0.5 percent")
    void checkKrishiKalyanTest() {
        double krishiKalyanTax = PricesUtility.getKrishiKalyanTax(100.0);
        assertEquals(0.5, krishiKalyanTax);
    }

    @Test
    @DisplayName("should be able to get price after selecting movie seats")
    void getPriceAfterSeatSelection() {
        Map<String, TicketType> movieList = new HashMap<>();
        movieList.put("B1", TicketType.GOLD);
        Set<String> selectedSeat = new HashSet<>();
        selectedSeat.add("B1");
        double price = PricesUtility.getPrice(movieList, selectedSeat);
        assertEquals(280, price);

    }

    @Test
    @DisplayName("should remove the seat from available list once it is booked")
    void removeSeatAfterSelection() {
        Map<String, TicketType> movieList = new HashMap<>();
        movieList.put("C1", TicketType.SILVER);
        Set<String> selectedSeat = new HashSet<>();
        selectedSeat.add("C1");
        PricesUtility.getPrice(movieList, selectedSeat);
        assertTrue(movieList.isEmpty());

    }
}