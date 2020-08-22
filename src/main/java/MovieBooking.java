
import enums.ShowNo;
import enums.TicketType;
import sun.security.krb5.internal.Ticket;

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
            printTotalRevenue();
            shutDown();
        }
        driveCustomer(scanner, showNo);

    }

    private void driveCustomer(Scanner scanner, String showNo) {

        while (true)
            if (showNo.equals(ShowNo.AUDI1.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi1, scanner, showNo);
            } else if (showNo.equals(ShowNo.AUDI2.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi2, scanner, showNo);
            } else if (showNo.equals(ShowNo.AUDI3.getAudiNo())) {
                continueMovieBooking(MovieLoader.audi3, scanner, showNo);
            } else {
                System.out.println("Please select shows between 1,2 and 3");
                shutDown();
            }
//        ShowNo.valueOf(showNo)   can be dynamic
       // Map<ShowNo, Map<String, TicketType>>
    }

    private void shutDown() {
        System.out.println("Shutting down the booking counter");
        System.exit(0);
    }

    private void printTotalRevenue() {
        double revenue = new TotalRevenue().getRevenue();
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs." + revenue);
        System.out.println("Service Tax: Rs. " + PricesUtility.getServiceTax(revenue));
        System.out.println("Swachh Bharat Cess: Rs. " + PricesUtility.getSwachhBharatTax(revenue));
        System.out.println("Krishi Kalyan Cess: Rs. " + PricesUtility.getKrishiKalyanTax(revenue));

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
            continueWithPriceDescription(audi, seatNumbersSet, showNo);
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

    private void continueWithPriceDescription(Map<String, TicketType> audi, Set seatNumbers, String showNo) {
        System.out.println("Print: Successfully Booked - Show" + showNo);
        double price = PricesUtility.getPrice(audi, seatNumbers);
        double serviceTax = PricesUtility.getServiceTax(price);
        double swatchBharatTax = PricesUtility.getSwachhBharatTax(price);
        double krishiKalyanTax = PricesUtility.getKrishiKalyanTax(price);
        double totalAmount = price + serviceTax + swatchBharatTax + krishiKalyanTax;
        System.out.println("Subtotal: Rs. " + price);
        System.out.println("Service Tax @14%: Rs." + serviceTax);
        System.out.println("Swachh Bharat Cess @0.5%: Rs." + swatchBharatTax);
        System.out.println("Krishi Kalyan Cess @0.5%" + krishiKalyanTax);
        System.out.println("Total: Rs." + totalAmount);

    }


}
