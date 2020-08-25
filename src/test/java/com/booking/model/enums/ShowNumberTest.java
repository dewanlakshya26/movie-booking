package com.booking.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowNumberTest {

    @Test
    @DisplayName("should have total 3 number of auditoriums")
    void shouldHaveTotalThreeNoOfAuditoriums() {
        ShowNumber[] showNumber = ShowNumber.values();
        assertEquals(3, showNumber.length);
    }

    @Test
    @DisplayName("Should Initialize second auditorium number")
    void shouldInitialiseSecondAudiNo() {
        ShowNumber showNumber = ShowNumber.AUDI2;
        assertEquals(String.valueOf(2), showNumber.getAudiNo());
    }

}