package com.gildedrose.item;

import static com.gildedrose.util.GildedRoseHelperUtil.increaseQualityCheck;

import com.gildedrose.behavior.IncreaseQualityBehavior;
import com.gildedrose.behavior.UpdateQualityBehavior;
import com.gildedrose.behavior.UpdateQualitySellInPassedBehaviour;

public class BackstagePassesItem extends Item implements UpdateQualityBehavior, IncreaseQualityBehavior,
    UpdateQualitySellInPassedBehaviour {

  public BackstagePassesItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void increaseQuality(Item item) {
		if (increaseQualityCheck(item.quality)) {
			item.quality = item.quality + 1;
		}
  }

  @Override
  public void updateQualitySellInPassed(Item item) {
    item.quality = item.quality - item.quality;
  }

  @Override
  public void updateQuality(Item item) {
    increaseQuality(item);

    if (item.sellIn < 11) {
      increaseQuality(item);
    }
    if (item.sellIn < 6) {
      increaseQuality(item);
    }

    item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			updateQualitySellInPassed(item);
		}
  }

}
