package cn.xpbootcamp.gildedrose;

public class PerformanceTickets {
    private int sellIn;
    private int quality;

    public PerformanceTickets(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int checkQuality(int updatedSellIn) {
        int updatedQuality = 0;
        if (updatedSellIn > 10) {
            updatedQuality = quality + (sellIn - updatedSellIn);
        } else if (updatedSellIn <= 5) {
            updatedQuality = quality + (sellIn - updatedSellIn) * 3;
        } else {
            updatedQuality = quality + (sellIn - updatedSellIn) * 2;
        }

        if (updatedQuality > 50) {
            updatedQuality = 50;
        }
        return updatedQuality;
    }
}