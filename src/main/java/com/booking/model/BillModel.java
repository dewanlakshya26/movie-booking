package com.booking.model;

public class BillModel {
    private double serviceTax;
    private double swatchBharatTax;

    public double getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }

    public double getSwatchBharatTax() {
        return swatchBharatTax;
    }

    public void setSwatchBharatTax(double swatchBharatTax) {
        this.swatchBharatTax = swatchBharatTax;
    }

    public double getKrishiKalyanTax() {
        return krishiKalyanTax;
    }

    public void setKrishiKalyanTax(double krishiKalyanTax) {
        this.krishiKalyanTax = krishiKalyanTax;
    }

    public BillModel(double serviceTax, double swatchBharatTax, double krishiKalyanTax) {
        this.serviceTax = serviceTax;
        this.swatchBharatTax = swatchBharatTax;
        this.krishiKalyanTax = krishiKalyanTax;
    }

    private double krishiKalyanTax;
}
