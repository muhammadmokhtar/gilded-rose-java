package com.gildedrose.item;

import com.gildedrose.behavior.UpdateQualityBehavior;

public class SulfurasItem extends Item implements UpdateQualityBehavior {

	public SulfurasItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality(Item item) {
		// No changes for this legendary item
	}

}
