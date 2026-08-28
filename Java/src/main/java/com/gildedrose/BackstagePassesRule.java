package com.gildedrose;

public class BackstagePassesRule implements ItemRule {
    public void applyRule(Item item) {
        item.quality++;
        if (item.sellIn <= 10) item.quality++;
        if (item.sellIn <= 5) item.quality++;
        if (item.sellIn <= 0) item.quality = 0;
        commonUpdate(item);
    }
}
