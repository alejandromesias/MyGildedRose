package com.gildedrose;

public class AgedBrieRule implements ItemRule{
    public void applyRule(Item item) {
        item.quality++;
        commonUpdate(item);
    }
}
