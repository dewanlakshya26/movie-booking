package com.booking.movieProcessor;

import com.booking.enums.ShowNumber;
import com.booking.enums.TicketType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


class MovieLoader {
    static Map<String, TicketType> audi1 = new HashMap<>();
    static Map<String, TicketType> audi2 = new HashMap<>();
    static Map<String, TicketType> audi3 = new HashMap<>();

    MovieLoader() {
        loadMovieFromSeed();
    }

    void loadMovieFromSeed() {
        JSONParser jsonParser = new JSONParser();

        String showListPath = new File("").getAbsolutePath() + "/src/main/resources/movie-list.json";
        try (FileReader reader = new FileReader(showListPath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject showList = (JSONObject) obj;

            loadSeatsPerAudi(showList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    void loadSeatsPerAudi(JSONObject showList) {
        EnumSet.allOf(ShowNumber.class)
                .forEach(showNumber -> loadSeat((JSONObject) showList.get(showNumber.getAudiNo()), showNumber));
    }


    private void loadSeat(JSONObject movieObject, ShowNumber show) {
        switch (show) {
            case AUDI1:
                loadSeatsInAudi(movieObject, audi1);
                break;
            case AUDI2:
                loadSeatsInAudi(movieObject, audi2);
                break;
            case AUDI3:
                loadSeatsInAudi(movieObject, audi3);
                break;
        }


    }

    private void loadSeatsInAudi(JSONObject movieObject, Map<String, TicketType> audi) {
        EnumSet.allOf(TicketType.class).forEach(category ->
                loadSeatWithCategory(audi, (String) movieObject.get(category.name()), category));
    }

    private void loadSeatWithCategory(Map<String, TicketType> audi, String seatList, TicketType ticketType) {
        String[] segregatedSeats = seatList.split(",");
        for (String seat : segregatedSeats) {
            audi.put(seat, ticketType);
        }
    }


}





