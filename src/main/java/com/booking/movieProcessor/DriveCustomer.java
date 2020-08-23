package com.booking.movieProcessor;

import com.booking.enums.ShowNumber;
import com.booking.enums.TicketType;
import com.booking.printExecutor.PrintUtility;

import java.util.*;

public class DriveCustomer {
    private Scanner scanner = new Scanner(System.in);
    private boolean seatAvailiable = false;
    private PrintUtility printHandler = new PrintUtility();


    void play() {
        System.out.println("Enter Show no");
        final String showNo = scanner.next();
        bookingEngine(showNo);
    }

    void bookingEngine(String showNumber) {
        MovieLoader movieLoader = MovieLoader.getMovieLoaderSingletonInstance();

        while (true) {

            if (Integer.parseInt(showNumber) != 0 && Integer.parseInt(showNumber) <= ShowNumber.values().length) {
                continueMovieBooking(movieLoader.getAuditoriumWiseSeatList(Integer.parseInt(showNumber)), showNumber);
            } else {
                System.out.println("Please select shows between 1,2 and 3");
                shutDown();
            }
        }
    }

    private void continueMovieBooking(Map<String, TicketType> audi, String showNo) {
        checkAvailableSeats(audi);
        System.out.println("Please select movies from below list");
        System.out.println(Arrays.toString(audi.keySet().toArray()));
        System.out.println("Enter Seats");
        String[] seatNumbers = scanner.next().split(",");
        Set seatNumbersSet = new HashSet<>(Arrays.asList(seatNumbers));

        for (Object seatNo : seatNumbersSet) {
            seatAvailiable = audi.containsKey(seatNo);
            if (!seatAvailiable) {
                break;
            }
        }
        if (seatAvailiable) {
            printHandler.continueWithPriceDescription(audi, seatNumbersSet, showNo);
        } else {
            for (String seatNo : seatNumbers) {
                if (!audi.containsKey(seatNo)) {
                    System.out.println(seatNo + " Not available, Please select different seats");
                }
            }
            bookingEngine(showNo);
        }
        System.out.println();
        System.out.println("Press 0 to exit");
        play();

    }

    void checkAvailableSeats(Map<String, TicketType> audi) {
        if (audi.isEmpty()) {
            System.out.println("No more seats available in this auditorium");
            shutDown();
        }
    }

    void shutDown() {
        System.out.println("Shutting down the booking counter");
        printHandler.printTotalRevenue();
        System.exit(0);
    }
}
