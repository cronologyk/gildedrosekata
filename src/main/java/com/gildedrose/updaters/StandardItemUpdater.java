package com.gildedrose.updaters;

import com.gildedrose.Item;

public class StandardItemUpdater implements Updater<Item> {

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= 1;
    }

    @Override
    public void updateQuality(Item item) {
        int decrement = item.sellIn >= 0 ? 1 : 2;

        item.quality = Math.max(0, item.quality - decrement);
    }
}
