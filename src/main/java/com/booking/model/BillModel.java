package com.booking.model;

import java.util.Objects;

public class BillModel {
    private double serviceTax;
    private double swatchBharatTax;

    public double getServiceTax() {
        return serviceTax;
    }

    public double getSwatchBharatTax() {
        return swatchBharatTax;
    }

    public double getKrishiKalyanTax() {
        return krishiKalyanTax;
    }

    public BillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax) {
        this.serviceTax = serviceTax;
        this.swatchBharatTax = swatchBharatTax;
        this.krishiKalyanTax = krishiKalyanTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillModel billModel = (BillModel) o;
        return Double.compare(billModel.serviceTax, serviceTax) == 0 &&
                Double.compare(billModel.swatchBharatTax, swatchBharatTax) == 0 &&
                Double.compare(billModel.krishiKalyanTax, krishiKalyanTax) == 0;
    }

    @Override
    public String toString() {
        return "BillModel{" +
                "serviceTax=" + serviceTax +
                ", swatchBharatTax=" + swatchBharatTax +
                ", krishiKalyanTax=" + krishiKalyanTax +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceTax, swatchBharatTax, krishiKalyanTax);
    }

    private double krishiKalyanTax;
}
