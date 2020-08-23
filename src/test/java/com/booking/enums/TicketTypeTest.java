package com.booking.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTypeTest {

    @Test
    @DisplayName("should have total 3 number of category")
    void shouldHaveTotalThreeNoOfCategory(){
        TicketType[] ticketTypes = TicketType.values();
        assertEquals(3, ticketTypes.length);
    }

    @Test
    @DisplayName("price of platinum ticket should be 320")
    void checkPricePlatinum(){
        TicketType ticketType = TicketType.PLATINUM;
        assertEquals(320, ticketType.getPrice());
    }

    @Test
    @DisplayName("price of silver ticket should be 240")
    void checkPriceSilver(){
        TicketType ticketType = TicketType.SILVER;
        assertEquals(240, ticketType.getPrice());
    }

}