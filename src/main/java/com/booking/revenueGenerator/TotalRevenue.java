package com.booking.revenueGenerator;

public class TotalRevenue {
    private double revenue = 0;
    private static TotalRevenue totalRevenueInstance = null;

    private TotalRevenue() {
    }

    public static TotalRevenue getSingletonInstance(){
        if (totalRevenueInstance == null){
            totalRevenueInstance = new TotalRevenue();
        }
        return totalRevenueInstance;
    }


    public void addRevenue(double incomingrevenue) {
        revenue += incomingrevenue;
    }

    public double getRevenue() {
        return revenue;
    }
}


