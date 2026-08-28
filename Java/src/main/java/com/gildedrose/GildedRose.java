package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name){
                case "Sulfuras, Hand of Ragnaros" :
                    return;
                case "Aged Brie":
                    items[i].quality++;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i].quality++;
                    if (items[i].sellIn <= 10) items[i].quality++;
                    if (items[i].sellIn <= 5) items[i].quality++;
                    if (items[i].sellIn <= 0) items[i].quality=0;
                    break;
                default:
                    items[i].quality--;
                    if (items[i].sellIn <= 0) items[i].quality-- ;
            }

            items[i].quality = Math.min(items[i].quality, 50);
            items[i].quality = Math.max(items[i].quality, 0);
            items[i].sellIn--;
        }
    }
}
