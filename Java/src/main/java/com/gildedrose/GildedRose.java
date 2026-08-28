package com.gildedrose;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private final Map<String, ItemRule> ruleContainer = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        ruleContainer.put("Sulfuras, Hand of Ragnaros",new SulfuraRule());
        ruleContainer.put("Aged Brie",new AgedBrieRule());
        ruleContainer.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesRule());
    }
    public void updateQuality() {
        for (Item item : items) {
            var rule = ruleContainer.getOrDefault(item.name, new AnyItemRule());
            rule.applyRule(item);
        }
    }
}
