
import enums.ShowNumber;
import enums.TicketType;

import java.util.*;

public class MovieBooking {
    private static boolean seatAvailiable = false;

    public static void main(String... args) {
        new MovieLoader();
        new MovieBooking().play();
    }

    private void play() {
        System.out.println("Enter Show no");
        Scanner scanner = new Scanner(System.in);
        final String showNo = scanner.next();
        if (showNo.equals("0")) {
            shutDown();
        }
        driveCustomer(scanner, showNo);

    }

    private void driveCustomer(Scanner scanner, String showNo) {

        while (true)
            if (showNo.equals(ShowNumber.AUDI1.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi1, scanner, showNo);
            } else if (showNo.equals(ShowNumber.AUDI2.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi2, scanner, showNo);
            } else if (showNo.equals(ShowNumber.AUDI3.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi3, scanner, showNo);
            } else {
                System.out.println("Please select shows between 1,2 and 3");
                shutDown();
            }
    }

    private void continueMovieBooking(Map<String, TicketType> audi, Scanner scanner, String showNo) {
        System.out.println("Please select movies from below list");
        System.out.println(Arrays.toString(audi.keySet().toArray()));
        System.out.print("Enter Seats");
        String[] seatNumbers = scanner.next().split(",");
        Set seatNumbersSet = new HashSet<>(Arrays.asList(seatNumbers));


        for (Object seatNo : seatNumbersSet) {
            seatAvailiable = audi.containsKey(seatNo);
            if (!seatAvailiable) {
                break;
            }
        }
        if (seatAvailiable) {
            PrintUtility.continueWithPriceDescription(audi, seatNumbersSet, showNo);
        } else {
            for (String seatNo : seatNumbers) {
                if (!audi.containsKey(seatNo)) {
                    System.out.println(seatNo + " Not available, Please select different seats");
                }
            }
            driveCustomer(new Scanner(System.in), showNo);
        }
        System.out.println("Press 0 to exit");
        play();

    }

    private void shutDown() {
        System.out.println("Shutting down the booking counter");
        PrintUtility.printTotalRevenue();
        System.exit(0);
    }


}
