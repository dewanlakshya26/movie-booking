package com.booking.revenueGenerator;

import com.booking.enums.TicketType;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TotalRevenueTest {
    TotalRevenue revenueHandler;

    @Before
    void init() {
        revenueHandler = Mockito.mock(TotalRevenue.class);

    }


    @Test
    @DisplayName("total revenue should be 0 if non tickets were booked")
    void zeroRevenue() {
        Mockito.when(revenueHandler.getRevenue()).thenReturn(0.0);
        double revenue = revenueHandler.getRevenue();
        assertEquals(0, revenue);
    }

    @Test
    @DisplayName("total revenue should added up on each movie booking")
    void addRevenue() {
        TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();

        revenueHandler.addRevenue(TicketType.PLATINUM.getPrice());
        revenueHandler.addRevenue(TicketType.SILVER.getPrice());

        assertEquals(560.0, revenueHandler.getRevenue());
    }

}
