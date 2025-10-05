package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            // Handle Sulfuras
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = decreaseQuality(item.quality);
            } else {
                item.quality = increaseQuality(item.quality);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        item.quality = increaseQuality(item.quality);
                    }

                    if (item.sellIn < 6) {
                        item.quality = increaseQuality(item.quality);
                    }
                }
            }

            item.sellIn = item.sellIn - 1; // Decrease day

            if (item.sellIn < 0) { // Sell by date has passed
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = decreaseQuality(item.quality);
                    } else {
                        item.quality = 0;
                    }
                } else {
                    item.quality = increaseQuality(item.quality);
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
