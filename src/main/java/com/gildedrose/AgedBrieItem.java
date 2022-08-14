package com.gildedrose;

import static com.gildedrose.GildedRoseHelperUtil.increaseQualityCheck;

public class AgedBrieItem extends Item implements UpdateQualityBehavior, IncreaseQualityBehavior, UpdateQualitySellInPassedBehaviour {
	
	public AgedBrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality(Item item) {
		increaseQuality(item);
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) updateQualitySellInPassed(item);
		
	}
	
	@Override
	public void increaseQuality(Item item) {
		if (increaseQualityCheck(item.quality)) item.quality = item.quality + 1;
	}

	@Override
	public void updateQualitySellInPassed(Item item) {
		increaseQuality(item);
	}


}
