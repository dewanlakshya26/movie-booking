package com.booking.model;

import java.util.Objects;

public class BillModel {
    private double serviceTax;
    private double swacchBharatTax;
    private double krishiKalyanTax;


    public double getServiceTax() {
        return serviceTax;
    }

    public double getSwacchBharatTax() {
        return swacchBharatTax;
    }

    public double getKrishiKalyanTax() {
        return krishiKalyanTax;
    }

    BillModel(double serviceTax, double swacchBharatTax, double krishiKalyanTax) {
        this.serviceTax = serviceTax;
        this.swacchBharatTax = swacchBharatTax;
        this.krishiKalyanTax = krishiKalyanTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillModel billModel = (BillModel) o;
        return Double.compare(billModel.serviceTax, serviceTax) == 0 &&
                Double.compare(billModel.swacchBharatTax, swacchBharatTax) == 0 &&
                Double.compare(billModel.krishiKalyanTax, krishiKalyanTax) == 0;
    }

    @Override
    public String toString() {
        return "BillModel{" +
                "serviceTax=" + serviceTax +
                ", swatchBharatTax=" + swacchBharatTax +
                ", krishiKalyanTax=" + krishiKalyanTax +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceTax, swacchBharatTax, krishiKalyanTax);
    }

}
