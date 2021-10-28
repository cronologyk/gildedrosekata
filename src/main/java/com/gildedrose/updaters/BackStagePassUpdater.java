package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackStagePassUpdater extends StandardItemUpdater {

    @Override
    public void updateQuality(Item item) {
        int increment = 1;

        if (item.sellIn <= 0) {
            item.quality = 0;
            return;
        }

        if (item.sellIn < 11) {
            increment+=1;
        }

        if (item.sellIn < 6) {
            increment+=1;
        }

        item.quality = Math.min(DEFAULT_MAX_QUALITY, item.quality + increment);
    }
}
