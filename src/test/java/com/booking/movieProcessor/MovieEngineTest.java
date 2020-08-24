package com.booking.movieProcessor;

import com.booking.enums.TicketType;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class MovieEngineTest {


    private MovieEngine movieEngineInstance = new MovieEngine();
    private final ByteArrayOutputStream outputConsoleData = new ByteArrayOutputStream();


    @Test
    @DisplayName("remove seleted seats from auditorium after purchase")
    void removeSelectedSeats() {
        HashMap<String, TicketType> dummyList = new HashMap<>();
        dummyList.put("A1", TicketType.PLATINUM);
        Set<String> dummySet = new HashSet<>();
        dummySet.add("A1");
        movieEngineInstance.removeSelectedSeatsFromAuditorium(dummyList, dummySet);
        assertTrue(dummyList.isEmpty());
    }

    @Test
    @DisplayName("should return false if auditorium is not empty")
    void checkIfAuditoriumIsEmpty() {
        HashMap<String, TicketType> dummyList = new HashMap<>();
        dummyList.put("A1", TicketType.PLATINUM);
        assertFalse(movieEngineInstance.isAuditoriumEmpty(dummyList));
    }


    @Test
    @DisplayName("system should shutDown when called")
    void shouldShutDown() throws Exception {
        SystemLambda.catchSystemExit(() -> {
            movieEngineInstance.shutDown();
            assertEquals("Shutting don the booking counter", outputConsoleData.toString());
        });
    }


}