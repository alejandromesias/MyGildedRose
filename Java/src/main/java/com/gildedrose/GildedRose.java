package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    continue;
                case "Aged Brie":
                    item.quality++;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality++;
                    if (item.sellIn <= 10) item.quality++;
                    if (item.sellIn <= 5) item.quality++;
                    if (item.sellIn <= 0) item.quality = 0;
                    break;
                default:
                    item.quality--;
                    if (item.sellIn <= 0) item.quality--;
            }

            item.quality = Math.min(item.quality, 50);
            item.quality = Math.max(item.quality, 0);
            item.sellIn--;
        }
    }
}
