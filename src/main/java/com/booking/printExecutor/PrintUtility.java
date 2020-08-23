package com.booking.printExecutor;

import com.booking.enums.TicketType;
import com.booking.priceCalculator.PriceUtility;
import com.booking.revenueGenerator.TotalRevenue;

import java.util.Map;
import java.util.Set;

public class PrintUtility {
    PriceUtility priceObject = new PriceUtility();
    public void printTotalRevenue() {
        double revenue =  TotalRevenue.getSingletonInstance().getRevenue();
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs." + revenue);
        System.out.println("Service Tax: Rs. " + priceObject.getServiceTax(revenue));
        System.out.println("Swachh Bharat Cess: Rs. " + priceObject.getSwachhBharatTax(revenue));
        System.out.println("Krishi Kalyan Cess: Rs. " + priceObject.getKrishiKalyanTax(revenue));

    }

    public void continueWithPriceDescription(Map<String, TicketType> audi, Set seatNumbers, String showNo) {
        System.out.println("Successfully Booked - Show" + showNo);
        double price = priceObject.getPrice(audi, seatNumbers);
        double serviceTax = priceObject.getServiceTax(price);
        double swatchBharatTax = priceObject.getSwachhBharatTax(price);
        double krishiKalyanTax = priceObject.getKrishiKalyanTax(price);
        double totalAmount = price + serviceTax + swatchBharatTax + krishiKalyanTax;
        System.out.println("Subtotal: Rs. " + price);
        System.out.println("Service Tax @14%: Rs." + serviceTax);
        System.out.println("Swachh Bharat Cess @0.5%: Rs." + swatchBharatTax);
        System.out.println("Krishi Kalyan Cess @0.5%" + krishiKalyanTax);
        System.out.println("Total: Rs." + totalAmount);

    }
}
