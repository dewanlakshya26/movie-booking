package com.booking.revenueGenerator;

import com.booking.enums.TicketType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TotalRevenueTest {

    private TotalRevenue totalRevenue;

    @BeforeEach
    void init(){
        totalRevenue = new TotalRevenue();
    }

    @Test
    @Disabled
    @DisplayName("total revenue should be 0 if non tickets were booked")
    void zeroRevenue(){
      double revenue =  totalRevenue.getRevenue();
        assertEquals(0,revenue);
    }

    @Test
    @DisplayName("total revenue should added up on each movie booking")
    void addRevenue(){
        TotalRevenue.addRevenue(TicketType.PLATINUM.getPrice());
        TotalRevenue.addRevenue(TicketType.SILVER.getPrice());

        assertEquals(560.0,totalRevenue.getRevenue());
    }

}
