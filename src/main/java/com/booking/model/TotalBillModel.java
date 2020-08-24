package com.booking.model;

import java.util.Objects;

public class TotalBillModel extends BillModel{
  double totalRevenue;

    public TotalBillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax, double totalRevenue) {
        super(serviceTax, swatchBharatTax, krishiKalyanTax);
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "TotalBillModel{" +
                "totalRevenue=" + totalRevenue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TotalBillModel that = (TotalBillModel) o;
        return Double.compare(that.totalRevenue, totalRevenue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalRevenue);
    }
}
