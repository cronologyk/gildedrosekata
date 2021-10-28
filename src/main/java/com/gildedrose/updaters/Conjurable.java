package com.gildedrose.updaters;

import com.gildedrose.Item;

public class Conjurable extends Item {
    public Item baseItem;

    public Conjurable(Item conjuredItem) {
        super(null, 0, 0);
        this.baseItem = conjuredItem;
    }

    public Item getBaseItem() {
        return baseItem;
    }
}
