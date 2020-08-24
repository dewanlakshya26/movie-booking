package com.booking.priceCalculator;

import com.booking.enums.Tax;
import com.booking.enums.TicketType;
import com.booking.model.CustomerBillModel;
import com.booking.model.TotalBillModel;
import com.booking.revenueGenerator.TotalRevenue;

import java.util.Map;
import java.util.Set;

public class PriceUtility {
     double getServiceTax(double price) {
        return (price * Tax.SERVICE_TAX.getTax()) / 100;
    }

     double getSwachhBharatTax(double price) {
        return (price * Tax.SWACHHBHARAT_TAX.getTax()) / 100;
    }

     double getKrishiKalyanTax(double price) {
        return (price * Tax.KRISHIKALYAN_TAX.getTax()) / 100;
    }

     double getPrice(Map<String, TicketType> audi, Set seatNumbers) {
        double price = 0;
        for (Object seatNo : seatNumbers) {
            price += audi.get(seatNo).getPrice();
        }
        TotalRevenue.getSingletonInstance().addRevenue(price);
        return price;
    }


    public CustomerBillModel getPriceForSelectedSeats(Map<String, TicketType> audi, Set selectedSeats) {
        double price = getPrice(audi, selectedSeats);
        double serviceTax = getServiceTax(price);
        double swatchBharatTax = getSwachhBharatTax(price);
        double krishiKalyanTax = getKrishiKalyanTax(price);
        double totalBill = price + serviceTax + swatchBharatTax + krishiKalyanTax;
        return new CustomerBillModel(serviceTax, swatchBharatTax, krishiKalyanTax, price, totalBill);
    }

    public TotalBillModel getTotalRevenue() {
        double revenue = TotalRevenue.getSingletonInstance().getRevenue();
        double serviceTax = getServiceTax(revenue);
        double swatchBharatTax = getSwachhBharatTax(revenue);
        double krishiKalyanTax = getKrishiKalyanTax(revenue);
        return new TotalBillModel(serviceTax, swatchBharatTax, krishiKalyanTax, revenue);
    }
}
