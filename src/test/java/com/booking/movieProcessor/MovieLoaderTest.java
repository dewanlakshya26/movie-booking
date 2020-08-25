package com.booking.movieProcessor;

import com.booking.model.enums.TicketType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class MovieLoaderTest {


    @Test
    @DisplayName("should get the same instance every time without overriding equals method")
    void checkClassInstance() {
        MovieLoader movieLoaderInstanceFirst = MovieLoader.getInstance();
        MovieLoader movieLoaderInstanceSecond = MovieLoader.getInstance();

        assertEquals(movieLoaderInstanceFirst, movieLoaderInstanceSecond);
    }


    @Test
    @DisplayName("should load movies when we create instance of Loader class")
    void loadMoviesWithCategories() {
        MovieLoader movieLoaderInstance = MovieLoader.getInstance();

        assertFalse(movieLoaderInstance.getAuditoriumWiseSeatList(1).isEmpty());
    }

    @Test
    @DisplayName("should be able to return seats with category")
    void fillSecondAuditorium() {
        HashMap<String, TicketType> expectedList = new HashMap<>();
        expectedList.put("A1", TicketType.PLATINUM);
        MovieLoader movieLoaderInstance = MovieLoader.getInstance();
        String seatList = "A1";
        assertEquals(expectedList, movieLoaderInstance.loadSeatWithCategory(seatList, TicketType.PLATINUM));
    }

}
