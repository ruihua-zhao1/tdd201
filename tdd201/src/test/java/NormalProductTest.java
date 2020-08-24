import cn.xpbootcamp.gildedrose.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NormalProductTest {

    @Test
    public void happyCase(){
        List<int[]> datas = new ArrayList<>();
        datas.add(new int[]{10, 20, 9, 19});
        datas.add(new int[]{2, 0, 1, 0});
        datas.add(new int[]{3, 6, 2, 5});
        datas.add(new int[]{0, 6, -1, 4});
        datas.add(new int[]{-1, 6, -2, 4});
        for (int[] data : datas) {
            verifyQuality(data[0],data[1],data[2],data[3]);
        }
    }


    private void verifyQuality(int sellIn, int quality, int updatedSellIn, int updatedQuality){
        Product product = new Product(sellIn, quality);
        int actualUpdatedQuality =  product.checkQuality(updatedSellIn);
        assertEquals(updatedQuality, actualUpdatedQuality );
    }
}
