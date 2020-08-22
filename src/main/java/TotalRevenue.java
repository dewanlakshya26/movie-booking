class TotalRevenue {
    private static double revenue = 0;

    public static void addRevenue(double incomingrevenue) {
        revenue += incomingrevenue;
    }

    public double getRevenue() {
        return revenue;
    }
}

enum Tax {
    SERVICE_TAX(14.0), SWACHHBHARAT_TAX(0.5), KRISHIKALYAN_TAX(0.5);
    private Double tax;

    Tax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }
}
