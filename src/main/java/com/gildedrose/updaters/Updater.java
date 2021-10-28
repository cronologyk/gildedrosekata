package com.gildedrose.updaters;

import com.gildedrose.Item;

public interface Updater<T extends Item> {

    int DEFAULT_MAX_QUALITY = 50;

    void updateSellIn(T item);

    void updateQuality(T item);
}
