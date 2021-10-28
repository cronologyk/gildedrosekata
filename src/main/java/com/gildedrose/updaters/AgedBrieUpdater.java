package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends StandardItemUpdater {

    @Override
    public void updateQuality(Item item) {
        int increment = 1;

        if (item.sellIn < 0) {
            increment += 1;
        }

        item.quality = Math.min(DEFAULT_MAX_QUALITY, item.quality + increment);
    }
}
