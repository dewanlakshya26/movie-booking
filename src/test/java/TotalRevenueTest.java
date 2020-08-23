
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TotalRevenueTest {

    private TotalRevenue totalRevenue;

    @BeforeEach
    void init(){
        totalRevenue = new TotalRevenue();
    }

    @Test
    @DisplayName("total revenue should be 0 if non tickets were booked")
    void zeroRevenue(){
      double revenue =  totalRevenue.getRevenue();
        assertEquals(0,revenue);
    }

    @Test
    @DisplayName("total revenue should added up on each movie booking")
    void addRevenue(){
        TotalRevenue.addRevenue(Enums.TicketType.PLATINUM.getPrice());
        TotalRevenue.addRevenue(Enums.TicketType.SILVER.getPrice());

        assertEquals(560.0,totalRevenue.getRevenue());
    }

}
