package com.gildedrose;
import java.util.HashMap;

class GildedRose {
    Item[] items;
    HashMap<String, ItemRule> ruleContainer = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        this.ruleContainer.put("Sulfuras, Hand of Ragnaros",new SulfuraRule());
        this.ruleContainer.put("Aged Brie",new AgedBrieRule());
        this.ruleContainer.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesRule());
    }
    public void updateQuality() {
        for (Item item : items) {
            var rule = ruleContainer.getOrDefault(item.name, new AnyItemRule());
            rule.applyRule(item);
        }
    }
}
