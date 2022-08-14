package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
	
    Item[] items;
    
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "Conjured Mana Cake";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    
    static Map<String, Item> itemsMap = new HashMap<String, Item>(); 
    
    private static void setupItems() {
    	itemsMap.put(AGED_BRIE, new AgedBrieItem(AGED_BRIE, 0, 0));
    	itemsMap.put(CONJURED, new ConjuredItem(CONJURED, 0, 0));
    	itemsMap.put(SULFURAS, new SulfurasItem(SULFURAS, 0, 0));
    	itemsMap.put(BACKSTAGE_PASSES, new BackstagePassesItem(BACKSTAGE_PASSES, 0, 0));
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	setupItems();
        for (int i = 0; i < items.length; i++) {
        		Item item = itemsMap.getOrDefault(items[i].name,
        				new TypicalItem(items[i].name, items[i].sellIn, items[i].quality));
        		((UpdateQualityBehavior) item).updateQuality(items[i]);
        
        }
    }
    
}