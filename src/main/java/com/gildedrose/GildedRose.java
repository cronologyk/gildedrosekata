package com.gildedrose;


import com.gildedrose.items.IBaseItem;
import com.gildedrose.items.Item;
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
        for (IBaseItem item : workerItems) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}
