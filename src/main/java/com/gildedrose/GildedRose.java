package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemFactory;

class GildedRose {
	
    Item[] items;
    ItemFactory itemFactory = new ItemFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
      for (Item item : items) {
        itemFactory.factoryMethod(item).updateQuality(item);
      }
    }
}