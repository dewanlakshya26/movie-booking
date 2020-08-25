package com.booking.model.enums;

public enum TicketType {
    PLATINUM(320), GOLD(280), SILVER(240);
    private int price;

    public int getPrice() {
        return price;
    }

    TicketType(int price) {
        this.price = price;
    }
}
