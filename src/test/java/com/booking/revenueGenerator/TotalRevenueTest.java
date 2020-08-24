package com.booking.revenueGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TotalRevenueTest {

    @Test
    @DisplayName("should update the total revenue")
    void addRevenue() {
        TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();

        revenueHandler.addRevenue(100);
        assertTrue(revenueHandler.getRevenue() > 0);
    }

    @Test
    @DisplayName("should get the same instance every time and check some revenue is always be there")
    void checkRevenue() {
        TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();

        assertTrue(revenueHandler.getRevenue() > 0);
    }

}
