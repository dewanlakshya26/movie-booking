package com.booking.model;

public class CustomerBillModel extends BillModel {
    private double price;
    private double totalBill;

    public CustomerBillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax, double price, double totalBill) {
        super(serviceTax, swatchBharatTax, krishiKalyanTax);
        this.price = price;
        this.totalBill = totalBill;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
