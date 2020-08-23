import java.util.Map;
import java.util.Set;

public class PricesUtility {
     static double getServiceTax(double price) {
        return (price * Enums.Tax.SERVICE_TAX.getTax()) / 100;
    }

    static double getSwachhBharatTax(double price) {
        return (price * Enums.Tax.SWACHHBHARAT_TAX.getTax()) / 100;
    }

    static double getKrishiKalyanTax(double price) {
        return (price * Enums.Tax.KRISHIKALYAN_TAX.getTax()) / 100;
    }

    static double getPrice(Map<String, Enums.TicketType> audi, Set seatNumbers) {
        double price = 0;
        for (Object seatNo : seatNumbers) {
            price += audi.get(seatNo).getPrice();
            audi.remove(seatNo);
        }
        TotalRevenue.addRevenue(price);
        return price;
    }
}
