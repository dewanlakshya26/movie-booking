
import static enums.Enums.*;

import java.util.*;

public class MovieBooking {
    private static boolean seatAvailiable = false;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        new MovieLoader();
        new MovieBooking().play();
    }

    private void play() {
        System.out.println("Enter Show no");
        final String showNo = scanner.next();
        if (showNo.equals("0")) {
            shutDown();
        }
        driveCustomer(showNo);

    }

    private void driveCustomer(String showNumber) {

        while (true)
            if (showNumber.equals(ShowNumber.AUDI1.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi1, showNumber);
            } else if (showNumber.equals(ShowNumber.AUDI2.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi2, showNumber);
            } else if (showNumber.equals(ShowNumber.AUDI3.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi3, showNumber);
            } else {
                System.out.println("Please select shows between 1,2 and 3");
                shutDown();
            }
    }

    private void continueMovieBooking(Map<String, TicketType> audi, String showNo) {
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
            driveCustomer(showNo);
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
