package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.api.IBaseItem;

public abstract class BaseItem implements IBaseItem {

    int DEFAULT_MAX_QUALITY = 50;
    int DEFAULT_EXPIRY_THRESHOLD = 0;
    public static final int DEFAULT_SELLIN_DECREMENT = 1;

    private final Item originalItem;

    BaseItem(Item originalItem) {
        this.originalItem = originalItem;
    }

    Item getItem() {
        return originalItem;
    }

    boolean isExpired() {
        return this.getItem().sellIn <= DEFAULT_EXPIRY_THRESHOLD;
    }

    boolean expiresIn(int days) {
        return this.getItem().sellIn - days < DEFAULT_EXPIRY_THRESHOLD;
    }

    void decreaseSellIn() {
        Item item = getItem();

        item.sellIn = item.sellIn - StandardItem.DEFAULT_SELLIN_DECREMENT;
    }

    void changeQualityBy(int qualityChange) {
        Item item = getItem();
        int newQuality = item.quality + qualityChange;

        if (newQuality < 0) {
            item.quality = 0;
        } else {
            item.quality = Math.min(DEFAULT_MAX_QUALITY, item.quality + qualityChange);
        }
    }

    void setQuality(int i) {
        getItem().quality = i;
    }
}
