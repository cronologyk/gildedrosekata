package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.api.LegendaryItem;

public class Sulfuras extends BaseItem implements LegendaryItem {

    Sulfuras(Item originalItem) {
        super(originalItem);
    }

    @Override
    public void updateQuality() {
        // Sulfuras never changes in quality
    }

    @Override
    public void updateSellIn() {
        // Sulfuras never changes sellin
    }
}
