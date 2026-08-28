package com.gildedrose;

public interface ItemRule {
    void applyRule(Item item);

    default void commonUpdate(Item item){
        item.quality = Math.min(item.quality, 50);
        item.quality = Math.max(item.quality, 0);
        item.sellIn--;
    }
}
