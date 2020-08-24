package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class ProductFactoryTest {

    @Test
    public void InitNormalProductTest(){
        ProductFactory productFactory = new ProductFactory();
        IProduct iProduct =  productFactory.createInstance(10, 20, "normalProduct");
        iProduct.getClass();
        Assert.assertEquals(NormalProduct.class, iProduct.getClass());
        int actualQuality = iProduct.checkQuality(9);
        Assert.assertEquals(19, actualQuality);
    }

    public void InitSpecialProductTest(){
        ProductFactory productFactory = new ProductFactory();
        IProduct iProduct =  productFactory.createInstance(15, 20, "performanceTicket");
        iProduct.getClass();
        Assert.assertEquals(PerformanceTickets.class, iProduct.getClass());
        iProduct.checkQuality(14);
        int actualQuality = iProduct.checkQuality(14);
        Assert.assertEquals(21, actualQuality);
    }
}
