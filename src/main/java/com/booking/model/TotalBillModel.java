package com.booking.model;

public class TotalBillModel extends BillModel{
  double totalRevenue;

    public TotalBillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax, double totalRevenue) {
        super(serviceTax, swatchBharatTax, krishiKalyanTax);
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
