package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static enums.Enums.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumsTest {

    @Nested
    @DisplayName("Test related to auditorium numbers")
    class ShowNumberTest {
        @Test
        @DisplayName("should have total 3 number of auditoriums")
         void shouldHaveTotalThreeNoOfAuditoriums() {
            ShowNumber[] showNumber = ShowNumber.values();
            assertEquals(3, showNumber.length);
        }

        @Test
        @DisplayName("Should Initialze second auditorium number")
         void shouldInitialiseSecondAudiNo() {
            ShowNumber showNumber = ShowNumber.AUDI2;
            assertEquals(String.valueOf(2), showNumber.getAudiNo());
        }

    }

    @Nested
    @DisplayName("Test related to type of ticket")
    class TicketTypeTest {

        @Test
        @DisplayName("should have total 3 number of category")
         void shouldHaveTotalThreeNoOfCategory(){
            TicketType[] ticketTypes = TicketType.values();
            assertEquals(3, ticketTypes.length);
        }

        @Test
        @DisplayName("price of platinum ticket should be 320")
        void checkPricePlatinum(){
            TicketType ticketType = TicketType.PLATINUM;
            assertEquals(320, ticketType.getPrice());
        }

        @Test
        @DisplayName("price of silver ticket should be 240")
         void checkPriceSilver(){
            TicketType ticketType = TicketType.SILVER;
            assertEquals(240, ticketType.getPrice());
        }

    }

}