package com.gildedrose.item;

public class ConjuredItem extends TypicalItem {


  private int initialQuality;
  private int qualityDifferrence;

  public ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality(Item item) {
    initialQuality = item.quality;
    super.updateQuality(item);
    qualityDifferrence = initialQuality - item.quality;
    do {
      super.decreaseQuality(item);
      qualityDifferrence--;
    } while (qualityDifferrence > 0);
  }

}
