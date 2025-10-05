package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            // Handle Sulfuras
            if (item.name.contains("Sulfuras")) {
                continue;
            }

            if (item.name.equals("Aged Brie")) {
                item.quality = increaseQuality(item.quality);
            } else if (item.name.contains("Backstage passes")) {
                item.quality = increaseQuality(item.quality);
                if (item.sellIn < 11) item.quality = increaseQuality(item.quality);
                if (item.sellIn < 6) item.quality = increaseQuality(item.quality);
            } else {
                item.quality = decreaseQuality(item.quality);
            }

            // Decrease day
            item.sellIn = item.sellIn - 1;

            // Sell by date has passed
            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    item.quality = increaseQuality(item.quality);
                } else if (item.name.contains("Backstage passes")) {
                    item.quality = 0;
                } else {
                    item.quality = decreaseQuality(item.quality);
                }
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
