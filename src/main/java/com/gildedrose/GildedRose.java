package com.gildedrose;


import com.gildedrose.api.IBaseItem;
import com.gildedrose.items.ItemFactory;

import java.util.LinkedList;
import java.util.List;

public class GildedRose {

    Item[] items;

    List<IBaseItem> workerItems = new LinkedList<>();

    public GildedRose(Item[] items) {
        this.items = items;

        for (Item item : this.items) {
            workerItems.add(ItemFactory.createItem(item));
        }
    }

    public void updateQuality() {
        workerItems.forEach(item -> {
            item.updateQuality();
            item.updateSellIn();
        });
    }
}
