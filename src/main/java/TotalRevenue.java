class TotalRevenue {
    private static double revenue = 0;

    public static void addRevenue(double incomingrevenue) {
        revenue += incomingrevenue;
    }

    public double getRevenue() {
        return revenue;
    }
}


