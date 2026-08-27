package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void original_name_remains_the_same() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void quality_and_sellin_should_have_decreased_by_1_for_a_regular_item_before_sell_date(){
        Item testitem = new Item("foo", 2, 2);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void quality_should_have_decreased_by_2_for_a_regular_item_after_sell_date(){
        Item testitem = new Item("foo", 0, 3);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void quality_should_never_be_negative_for_any_item(){
        Item testitem = new Item("foo", 2, 0);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void quality_should_have_increased_by_1_for_Brie(){
        Item testitem = new Item("Aged Brie", 2, 0);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void quality_should_not_have_increased_above_50_for_Brie(){
        Item testitem = new Item("Aged Brie", 2, 50);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void values_should_not_vary_for_sulfuras(){
        Item testitem = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void quality_should_increase_by_one_for_backstage_passes_sellin_above_10(){
        Item testitem = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 12);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void quality_should_increase_by_two_for_backstage_passes_sellin_from_10(){
        Item testitem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 11);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void quality_should_increase_by_three_for_backstage_passes_sellin_from_5(){
        Item testitem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void quality_should_not_increase_above_50_for_backstage_passes(){
        Item testitem = new Item("Backstage passes to a TAFKAL80ETC concert", 40, 50);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(39, app.items[0].sellIn);
    }

    @Test
    void quality_should_drop_to_0_for_backstage_passes_after_concert(){
        Item testitem = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        Item[] items = new Item[] {testitem};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


}
