package com.gildedrose.item;

import com.gildedrose.behavior.UpdateQualityBehavior;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String CONJURED = "Conjured Mana Cake";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  private final Map<String, UpdateQualityBehavior> cache = new HashMap<>();

  public ItemFactory() {
    cache.put(AGED_BRIE, new AgedBrieItem(AGED_BRIE, 0, 0));
    cache.put(CONJURED, new ConjuredItem(CONJURED, 0, 0));
    cache.put(SULFURAS, new SulfurasItem(SULFURAS, 0, 0));
    cache.put(BACKSTAGE_PASSES, new BackstagePassesItem(BACKSTAGE_PASSES, 0, 0));
  }

  public UpdateQualityBehavior factoryMethod(Item item) {
      return cache.getOrDefault(item.name, new TypicalItem(item.name, item.sellIn, item.quality));
  }

}
