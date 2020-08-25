package com.booking.movieProcessor;

public class MovieBooking {

    public static void main(String... args) {
        MovieLoader.initiateSingletonInstance();
        new MovieEngine().bookingEngine();
    }
}
