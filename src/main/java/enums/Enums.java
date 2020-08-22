package enums;

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
}
