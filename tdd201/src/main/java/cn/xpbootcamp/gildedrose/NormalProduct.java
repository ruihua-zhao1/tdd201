package cn.xpbootcamp.gildedrose;

public class NormalProduct {
    private int sellIn;
    private int quality;

    public NormalProduct(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int checkQuality(int updatedSellIn) {
        int updatedQuality;
        if (quality == 0) {
            return 0;
        }

        if (sellIn <= 0) {
            updatedQuality = quality - (sellIn - updatedSellIn) * 2;
            return updatedQuality;
        }

        updatedQuality = quality - (sellIn - updatedSellIn);
        return updatedQuality;
    }
}
