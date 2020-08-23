import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumsTest {

    @Nested
    @DisplayName("Test related to auditorium numbers")
    class ShowNumberTest {
        @Test
        @DisplayName("should have total 3 number of auditoriums")
         void shouldHaveTotalThreeNoOfAuditoriums() {
            Enums.ShowNumber[] showNumber = Enums.ShowNumber.values();
            assertEquals(3, showNumber.length);
        }

        @Test
        @DisplayName("Should Initialze second auditorium number")
         void shouldInitialiseSecondAudiNo() {
            Enums.ShowNumber showNumber = Enums.ShowNumber.AUDI2;
            assertEquals(String.valueOf(2), showNumber.getAudiNo());
        }

    }

    @Nested
    @DisplayName("Test related to type of ticket")
    class TicketTypeTest {

        @Test
        @DisplayName("should have total 3 number of category")
         void shouldHaveTotalThreeNoOfCategory(){
            Enums.TicketType[] ticketTypes = Enums.TicketType.values();
            assertEquals(3, ticketTypes.length);
        }

        @Test
        @DisplayName("price of platinum ticket should be 320")
        void checkPricePlatinum(){
            Enums.TicketType ticketType = Enums.TicketType.PLATINUM;
            assertEquals(320, ticketType.getPrice());
        }

        @Test
        @DisplayName("price of silver ticket should be 240")
         void checkPriceSilver(){
            Enums.TicketType ticketType = Enums.TicketType.SILVER;
            assertEquals(240, ticketType.getPrice());
        }

    }
    @Nested
    @DisplayName("Test related to type of tax")
    class TaxTypeTest {

        @Test
        @DisplayName("should have total 3 different kinds of taxes")
        void shouldHaveThreeToatalTaxes(){
            Enums.Tax[] taxType = Enums.Tax.values();
            assertEquals(3, taxType.length);
        }

        @Test
        @DisplayName("percentage of service tax should be 14%")
        void checkServiceTaxPercentage(){
            Enums.Tax taxType = Enums.Tax.SERVICE_TAX;
            assertEquals(new Double(14.0), taxType.getTax());
        }

        @Test
        @DisplayName("percentage of swacch bharat tax should be 0.5%")
        void checkSwatchBharatTaxPercentage(){
            Enums.Tax taxType = Enums.Tax.SWACHHBHARAT_TAX;
            assertEquals(new Double(0.5), taxType.getTax());
        }
    }

}