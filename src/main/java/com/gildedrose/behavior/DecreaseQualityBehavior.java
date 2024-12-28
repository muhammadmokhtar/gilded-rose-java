package com.gildedrose.behavior;

import com.gildedrose.item.Item;
@FunctionalInterface
public interface DecreaseQualityBehavior {
	void decreaseQuality(Item item);
}
