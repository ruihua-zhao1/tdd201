import cn.xpbootcamp.gildedrose.PerformanceTickets;
import org.junit.Assert;
import org.junit.Test;

public class PerformanceTicketsTest {
    @Test
    public void verifyRise1Before14Days() {
        PerformanceTickets performanceTickets = new PerformanceTickets(15, 20);
        int actualQuality = performanceTickets.updatedQuality(14);
        Assert.assertEquals(21, actualQuality);
    }

    @Test
    public void verifyRise2WhenEqualTo10Days() {
        PerformanceTickets performanceTickets = new PerformanceTickets(10, 45);
        int actualQuality = performanceTickets.updatedQuality(9);
        Assert.assertEquals(47, actualQuality);
    }

    @Test
    public void verifyRise2WhenLessThan10Days() {
        PerformanceTickets performanceTickets = new PerformanceTickets(9, 45);
        int actualQuality = performanceTickets.updatedQuality(8);
        Assert.assertEquals(47, actualQuality);
    }
}
