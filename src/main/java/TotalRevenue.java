class TotalRevenue {
    private static double revenue = 0;

    static void addRevenue(double incomingrevenue) {
        revenue += incomingrevenue;
    }

    double getRevenue() {
        return revenue;
    }
}


