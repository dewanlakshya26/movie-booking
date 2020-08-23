package com.booking.priceCalculator;

import com.booking.enums.Tax;
import com.booking.enums.TicketType;
import com.booking.revenueGenerator.TotalRevenue;

import java.util.Map;
import java.util.Set;

public class PriceUtility {
    public double getServiceTax(double price) {
        return (price * Tax.SERVICE_TAX.getTax()) / 100;
    }

    public double getSwachhBharatTax(double price) {
        return (price * Tax.SWACHHBHARAT_TAX.getTax()) / 100;
    }

    public double getKrishiKalyanTax(double price) {
        return (price * Tax.KRISHIKALYAN_TAX.getTax()) / 100;
    }

    public double getPrice(Map<String, TicketType> audi, Set seatNumbers) {
        double price = 0;
        for (Object seatNo : seatNumbers) {
            price += audi.get(seatNo).getPrice();
            audi.remove(seatNo);
        }
        TotalRevenue.getSingletonInstance().addRevenue(price);
        return price;
    }
}
