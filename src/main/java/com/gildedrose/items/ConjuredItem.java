package com.gildedrose.items;

import com.gildedrose.api.IBaseItem;
import com.gildedrose.api.IConjuredItem;

public class ConjuredItem implements IBaseItem, IConjuredItem {

    IBaseItem baseItem;

    ConjuredItem(IBaseItem baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public void updateQuality() {
        baseItem.updateQuality();
        baseItem.updateQuality();

    }

    @Override
    public void updateSellIn() {
        baseItem.updateSellIn();
    }
}
