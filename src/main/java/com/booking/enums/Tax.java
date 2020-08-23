package com.booking.enums;

public enum Tax {
    SERVICE_TAX(14.0), SWACHHBHARAT_TAX(0.5), KRISHIKALYAN_TAX(0.5);
    private Double tax;

    Tax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }
}
