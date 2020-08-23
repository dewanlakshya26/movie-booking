package com.booking.movieProcessor;

public class MovieBooking {

    public static void main(String... args) {
        MovieLoader.getMovieLoaderSingletonInstance();
        new MovieEngine().bookingEngine();
    }
}
