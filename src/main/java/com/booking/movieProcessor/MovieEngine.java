package com.booking.movieProcessor;

import com.booking.enums.ShowNumber;
import com.booking.enums.TicketType;
import com.booking.model.CustomerBillModel;
import com.booking.priceCalculator.PriceUtility;
import com.booking.printExecutor.PrintUtility;

import java.util.*;

public class MovieEngine {
    private Scanner scanner = new Scanner(System.in);
    private boolean seatAvailable = false;
    private PrintUtility printHandler = new PrintUtility();
    private PriceUtility priceHandler = new PriceUtility();


    void bookingEngine() {
        System.out.println("Enter Show no");
        final String showNo = scanner.next();
        bookTickets(showNo);
    }

    void bookTickets(String showNumber) {
        MovieLoader movieLoader = MovieLoader.initiateSingletonInstance();

        try {
            if (Integer.parseInt(showNumber) != 0 && Integer.parseInt(showNumber) <= ShowNumber.values().length) {
                continueMovieBooking(movieLoader.getAuditoriumWiseSeatList(Integer.parseInt(showNumber)), showNumber);
            } else {
                System.out.println("Please select shows between 1,2 and 3");
                shutDown();
            }
        } catch (Exception e) {
            System.out.println("Please select shows between 1,2 and 3");
            shutDown();
        }
    }

    private void continueMovieBooking(Map<String, TicketType> audi, String showNo) {
        if (isAuditoriumEmpty(audi)) {
            System.out.println("No more seats available in this auditorium");
            shutDown();
        }
        Set selectedSeats = fetchSelectedSeats(audi);
        if (selectedSeats.isEmpty()) {
            continueMovieBooking(audi, showNo);
        }
        CustomerBillModel customerBillModel = priceHandler.getPriceForSelectedSeats(audi, selectedSeats);
        printHandler.printCustomerBill(customerBillModel);
        removeSelectedSeatsFromAuditorium(audi, selectedSeats);

        System.out.println("Press 0 to exit");
        bookingEngine();
    }


    private Set fetchSelectedSeats(Map<String, TicketType> audi) {
        System.out.println("Please select movies from below list");
        System.out.println(Arrays.toString(audi.keySet().toArray()));
        System.out.println("Enter Seats");
        String[] seatNumbers = scanner.next().split(",");
        Set selectedSeats = new HashSet<>(Arrays.asList(seatNumbers));

        for (Object seatNo : selectedSeats) {
            seatAvailable = audi.containsKey(seatNo);
            if (!seatAvailable) {
                break;
            }
        }
        if (seatAvailable) {
            return selectedSeats;
        } else {
            for (String seatNo : seatNumbers) {
                if (!audi.containsKey(seatNo)) {
                    System.out.println(seatNo + " Not available, Please select different seats");
                }
            }
            return Collections.emptySet();
        }
    }

    void removeSelectedSeatsFromAuditorium(Map<String, TicketType> audi, Set selectedSeats) {
        selectedSeats.forEach(seat -> audi.remove(seat));
    }

    boolean isAuditoriumEmpty(Map<String, TicketType> audi) {
        return audi.isEmpty();
    }

    void shutDown() {
        System.out.println("Shutting down the booking counter");
        printHandler.printTotalRevenue(priceHandler.getTotalRevenue());
        System.exit(0);
    }
}
