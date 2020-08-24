package cn.xpbootcamp.gildedrose;

public class PerformanceTickets {
    private int sellIn;
    private int quality;
    public PerformanceTickets(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int updatedQuality(int updatedSellIn	) {
        return  quality + (sellIn - updatedSellIn);
    }
}