package com.gildedrose;

public class GildedRoseHelperUtil {
	protected static boolean decreaseQaulityCheck(int quality) {
		return quality > 0;
	} 
	
	protected static boolean increaseQualityCheck(int quality) {
		return quality < 50;
	}
}
