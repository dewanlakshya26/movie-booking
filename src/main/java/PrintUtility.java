import static enums.Enums.*;

import java.util.Map;
import java.util.Set;

public class PrintUtility {
    static void printTotalRevenue() {
        double revenue = new TotalRevenue().getRevenue();
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs." + revenue);
        System.out.println("Service Tax: Rs. " + PricesUtility.getServiceTax(revenue));
        System.out.println("Swachh Bharat Cess: Rs. " + PricesUtility.getSwachhBharatTax(revenue));
        System.out.println("Krishi Kalyan Cess: Rs. " + PricesUtility.getKrishiKalyanTax(revenue));

    }

    static void continueWithPriceDescription(Map<String, TicketType> audi, Set seatNumbers, String showNo) {
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
