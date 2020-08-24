package com.booking.model;

import java.util.Objects;

public class CustomerBillModel extends BillModel {
    private double price;
    private double totalBill;

    public CustomerBillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax, double price, double totalBill) {
        super(serviceTax, swatchBharatTax, krishiKalyanTax);
        this.price = price;
        this.totalBill = totalBill;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBillModel that = (CustomerBillModel) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.totalBill, totalBill) == 0;
    }

    @Override
    public String toString() {
        return "CustomerBillModel{" +
                "price=" + price +
                ", totalBill=" + totalBill +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, totalBill);
    }
}
