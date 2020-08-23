package com.booking.revenueGenerator;

import com.booking.enums.TicketType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TotalRevenueTest {


    @Test
    @DisplayName("total revenue should be 0 if non tickets were booked")
    void zeroRevenue(){
        TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();
        double revenue =  revenueHandler.getRevenue();
        assertEquals(0,revenue);
    }

    @Test
    @DisplayName("total revenue should added up on each movie booking")
    void addRevenue(){
        TotalRevenue revenueHandler = TotalRevenue.getSingletonInstance();

        revenueHandler.addRevenue(TicketType.PLATINUM.getPrice());
        revenueHandler.addRevenue(TicketType.SILVER.getPrice());

        assertEquals(560.0,revenueHandler.getRevenue());
    }

}
