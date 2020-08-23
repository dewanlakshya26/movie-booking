
public class Enums {
    public enum ShowNumber {
        AUDI1("1"), AUDI2("2"), AUDI3("3");
        private String showNumber;

        public String getAudiNo() {
            return showNumber;
        }

        ShowNumber(String audiNo) {
            this.showNumber = audiNo;
        }
    }

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
}
