package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    @DisplayName("should_not_update_sellIn_and_quality_for_sulfares_items")
    void firstTestCase() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    @DisplayName("should_not_increase_quality_above_50_except_for_sulfares_items_never_altered")
    void secondTestCase() {
    	Item[] items = new Item[] {
    			new Item("Sulfuras, Hand of Ragnaros", 1, 80),
    			new Item("Aged Brie", 3, 50),
    			new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
    			new Item("regular Item", 3, 50)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }
    
    @Test
    @DisplayName("should_increase_quality_by_two_when_sell_In_is_less_than_eleven_for_BackStage_passes_items")
    void thirdTestCase() {
    	Item[] items = new Item[] {
    			new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    
    @Test
    @DisplayName("should_increase_quality_by_three_when_sell_In_is_less_than_six_for_BackStage_passes_items")
    void forthTestCase() {
    	Item[] items = new Item[] {
    			new Item("Backstage passes to a TAFKAL80ETC concert", 4, 4)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
    
    @Test
    @DisplayName("Aged Brie increases in quality by 1 as long as sellIn is not passed")
    void fifthTestCase() {
    	//--Given
    	Item[] items = new Item[] {
    			new Item("Aged Brie", 1, 5)};
    	//--when
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        //--then
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    
    @Test
    @DisplayName("quality is never less than 0")
    void sixthTestCase() {
    	Item[] items = new Item[] {
    			new Item("some item", 1, 0)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(0, app.items[0].sellIn);
    	assertEquals(0, app.items[0].quality);
    }
    
    @Test
    @DisplayName("Aged Brie increases in quality by 2 when sellIn is passed")
    void seventhTestCase() {
    	//--Given
    	Item[] items = new Item[] {
    			new Item("Aged Brie", -1, 5),
    			};
    	//--when
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        //--then
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
    
    @Test
    @DisplayName("Conjured items decreases in quality twice as fast as normal item")
    void eightsTestCase() {
    	Item[] items = new Item[] {
    			new Item("Conjured Mana Cake", 0, 50),
    			new Item("Conjured Mana Cake", 1, 50),
    			new Item("Conjured Mana Cake", 0, 1),
    			new Item("Conjured Mana Cake", 1, 2)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(46, app.items[0].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(48, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
    }
    
    @Test
    @DisplayName("normal items quality decreases by 2 when its the sellIn is passed")
    void ninethTestCase() {
    	Item[] items = new Item[] {
    			new Item("some item", 0, 2),
    			new Item("some item", 0, 1)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(-1, app.items[0].sellIn);
    	assertEquals(0, app.items[0].quality);
    	assertEquals(0, app.items[1].quality);
    }
    
    @Test
    @DisplayName("Backstage items quality drops to 0 after the concert(sellIn < 0)")
    void tenththTestCase() {
    	Item[] items = new Item[] {
    			new Item("Backstage passes to a TAFKAL80ETC concert", 0, 4)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
   
}
