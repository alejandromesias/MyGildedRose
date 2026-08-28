package com.gildedrose;

public class AnyItemRule implements ItemRule{
    public void applyRule(Item item) {
        item.quality--;
        if (item.sellIn <= 0) item.quality--;
        commonUpdate(item);
    }
}
