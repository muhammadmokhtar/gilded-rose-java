package com.gildedrose.item;

import static com.gildedrose.util.GildedRoseHelperUtil.decreaseQualityCheck;

import com.gildedrose.behavior.DecreaseQualityBehavior;
import com.gildedrose.behavior.UpdateQualityBehavior;
import com.gildedrose.behavior.UpdateQualitySellInPassedBehaviour;

public class TypicalItem extends Item implements UpdateQualityBehavior, DecreaseQualityBehavior, UpdateQualitySellInPassedBehaviour {

  public TypicalItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void decreaseQuality(Item item) {
    if (decreaseQualityCheck(item.quality)) {
      item.quality = item.quality - 1;
    }
  }

  @Override
  public void updateQuality(Item item) {
    decreaseQuality(item);
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      updateQualitySellInPassed(item);
    }
  }

  @Override
  public void updateQualitySellInPassed(Item item) {
    decreaseQuality(item);
  }

}
