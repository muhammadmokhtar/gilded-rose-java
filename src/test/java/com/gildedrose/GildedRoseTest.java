package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    // should_not_update_sellIn_and_quality_for_sulfares_items
    @Test
    void firstTestCase() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }
    
    // should_not_increase_quality_above_50_except_for_sulfares_items_never_alter
    @Test
    void secondTestCase() {
    	Item[] items = new Item[] {
    			new Item("Sulfuras, Hand of Ragnaros", 1, 80),
    			new Item("Aged Brie", 3, 50),
    			new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }
    
    // should_increase_quality_by_two_when_sell_In_is_less_that_eleven_BackStage_passes_items
    @Test
    void thirdTestCase() {
    	Item[] items = new Item[] {
    			new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    
    //should_increase_quality_by_three_when_sell_In_is_less_than_six_BackStage_passes_Aged_brie_items
    @Test
    void forthTestCase() {
    	Item[] items = new Item[] {
    			new Item("Backstage passes to a TAFKAL80ETC concert", 4, 4)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
}
