package com.gildedrose.util;

public class GildedRoseHelperUtil {
	public static boolean decreaseQualityCheck(int quality) {
		return quality > 0;
	} 
	
	public static boolean increaseQualityCheck(int quality) {
		return quality < 50;
	}
}
