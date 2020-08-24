package com.booking.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxTest {

    @Test
    @DisplayName("should have total 3 different kinds of taxes")
    void shouldHaveThreeTotalTaxes() {
        Tax[] taxType = Tax.values();
        assertEquals(3, taxType.length);
    }

    @Test
    @DisplayName("percentage of service tax should be 14%")
    void checkServiceTaxPercentage() {
        Tax taxType = Tax.SERVICE_TAX;
        assertEquals(new Double(14.0), taxType.getTax());
    }

    @Test
    @DisplayName("percentage of swacch bharat tax should be 0.5%")
    void checkSwatchBharatTaxPercentage() {
        Tax taxType = Tax.SWACHHBHARAT_TAX;
        assertEquals(new Double(0.5), taxType.getTax());
    }
}

