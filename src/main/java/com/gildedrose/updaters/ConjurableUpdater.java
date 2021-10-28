package com.gildedrose.updaters;

import com.gildedrose.GildedRose;

public class ConjurableUpdater implements Updater<Conjurable> {

    @Override
    public void updateSellIn(Conjurable item) {
        Updater updater = GildedRose.updaterFactory.getUpdater(item.getBaseItem().getClass());

        updater.updateSellIn(item.getBaseItem());
        updater.updateSellIn(item.getBaseItem());
    }

    @Override
    public void updateQuality(Conjurable item) {
        Updater updater = GildedRose.updaterFactory.getUpdater(item.getBaseItem().getClass());

        updater.updateQuality(item);
    }
}
