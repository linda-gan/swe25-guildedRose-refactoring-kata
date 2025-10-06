package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.contains("Sulfuras")) {
                continue;
            }

            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isBackstagePass = item.name.contains("Backstage passes");

            if (isAgedBrie) {
                item.quality = increaseQuality(item.quality);
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) item.quality = increaseQuality(item.quality);
            } else if (isBackstagePass) {
                item.quality = increaseQuality(item.quality);
                if (item.sellIn < 11) item.quality = increaseQuality(item.quality);
                if (item.sellIn < 6) item.quality = increaseQuality(item.quality);
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) item.quality = 0;
            } else {
                item.quality = decreaseQuality(item.quality);
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) item.quality = decreaseQuality(item.quality);
            }
        }
    }

    private int decreaseQuality(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }

    private int increaseQuality(int quality) {
        return quality < 50 ? quality + 1 : quality;
    }
}
