package cn.xpbootcamp.gildedrose;

public class ProductFactory {
    public IProduct createInstance(int sellIn, int quality, String productType) {
         if(productType.equals("normalProduct")){
         return new NormalProduct(sellIn, quality);
         }
         else if(productType.equals("performanceTicket")) {
         return new PerformanceTickets(sellIn, quality);
         }
         else{
         return (IProduct) new Exception();
         }
    }
}
