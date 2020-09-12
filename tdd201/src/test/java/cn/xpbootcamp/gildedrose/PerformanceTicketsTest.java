package cn.xpbootcamp.gildedrose;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PerformanceTicketsTest {
    @Test
    public void verifyPerformanceTicket() {
        List<int[]> datas = new ArrayList<>();
        datas.add(new int[]{15, 20, 14, 21});
        datas.add(new int[]{10, 45, 9, 47});
        datas.add(new int[]{9, 45, 8, 47});
        datas.add(new int[]{10, 49, 9, 50});
        datas.add(new int[]{10, 50, 9, 50});
        datas.add(new int[]{5, 49, 4, 50});
        datas.add(new int[]{5, 45, 4, 48});
        datas.add(new int[]{1, 20, 0, 23});
        datas.add(new int[]{0, 20, -1, 0});
        for (int[] data : datas) {
            verifyQuality(data[0], data[1], data[2], data[3]);
        }
    }

    private void verifyQuality(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        PerformanceTickets product = new PerformanceTickets(sellIn, quality);
        int actualUpdatedQuality = product.checkQuality(updatedSellIn);
        assertEquals(updatedQuality, actualUpdatedQuality);
    }
}
