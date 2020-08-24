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
}
