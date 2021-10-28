package com.gildedrose;

import com.gildedrose.updaters.AgedBrieUpdater;
import com.gildedrose.updaters.BackStagePassUpdater;
import com.gildedrose.updaters.ConjurableUpdater;
import com.gildedrose.updaters.StandardItemUpdater;
import com.gildedrose.updaters.SulfurasUpdater;
import com.gildedrose.updaters.Updater;
import com.gildedrose.updaters.UpdaterFactory;

public class GildedRose {

    Item[] items;

    public static UpdaterFactory updaterFactory = new UpdaterFactory();

    static {
        updaterFactory.register(Sulfuras.class, new SulfurasUpdater());
        updaterFactory.register(StandardItem.class, new StandardItemUpdater());
        updaterFactory.register(BackstagePass.class, new BackStagePassUpdater());
        updaterFactory.register(AgedBrie.class, new AgedBrieUpdater());
        updaterFactory.register(Item.class, new StandardItemUpdater());
        updaterFactory.register(ConjurableStandardItem.class, new ConjurableUpdater());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Updater<Item> updater = (Updater<Item>) updaterFactory.getUpdater(item.getClass());

            updater.updateQuality(item);
            updater.updateSellIn(item);
        }
    }
}
