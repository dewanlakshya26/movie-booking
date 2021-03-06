package com.booking.movieProcessor;

import com.booking.model.enums.ShowNumber;
import com.booking.model.enums.TicketType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public class MovieLoader {
    private ArrayList<HashMap<String, TicketType>> auditoriumLoaderList = new ArrayList<>();
    private static MovieLoader movieLoaderSingletonInstance = null;

    private MovieLoader() {
        loadMovieFromSeed();
    }


    public static MovieLoader getInstance() {
        if (movieLoaderSingletonInstance == null) {
            movieLoaderSingletonInstance = new MovieLoader();
        }
        return movieLoaderSingletonInstance;
    }

    Map<String, TicketType> getAuditoriumWiseSeatList(int auditoriumNo) {
        return auditoriumLoaderList.get(auditoriumNo - 1);
    }

    private void loadMovieFromSeed() {
        JSONParser jsonParser = new JSONParser();

        String showListPath = new File("").getAbsolutePath() + "/src/main/resources/movie-list.json";
        try (FileReader reader = new FileReader(showListPath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject showList = (JSONObject) obj;

            loadSeatsPerAuditorium(showList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    private void loadSeatsPerAuditorium(JSONObject showList) {
        EnumSet.allOf(ShowNumber.class)
                .forEach(showNumber -> {
                    HashMap<String, TicketType> movieListPerAuditorium = new HashMap<>();
                    EnumSet.allOf(TicketType.class).forEach(category ->
                            movieListPerAuditorium.putAll(loadSeatWithCategory((String) ((JSONObject) showList.get(showNumber.getAudiNo())).get(category.name()), category)));
                    auditoriumLoaderList.add(movieListPerAuditorium);
                });
    }


    HashMap<String, TicketType> loadSeatWithCategory(String seatList, TicketType category) {
        HashMap<String, TicketType> movieListPerCategory = new HashMap<>();
        String[] segregatedSeats = seatList.split(",");
        for (String seat : segregatedSeats) {
            movieListPerCategory.put(seat, category);
        }
        return movieListPerCategory;
    }


}






