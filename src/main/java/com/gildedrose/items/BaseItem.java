package com.gildedrose.items;

public abstract class BaseItem implements IBaseItem {

    int DEFAULT_MAX_QUALITY = 50;
    int DEFAULT_EXPIRY_THRESHOLD = 0;

    private final Item originalItem;

    BaseItem(Item originalItem) {
        this.originalItem = originalItem;
    }

    private Item getItem() {
        return originalItem;
    }

    boolean isExpired() {
        return this.getItem().sellIn <= DEFAULT_EXPIRY_THRESHOLD;
    }

    boolean expiresIn(int days) {
        return this.getItem().sellIn - days < 0;
    }

    void decreaseSellInBy(int sellInDecrement) {
        Item item = getItem();

        item.sellIn = item.sellIn - sellInDecrement;
    }

    void changeQualityBy(int qualityChange) {
        Item item = getItem();
        item.quality = Math.min(DEFAULT_MAX_QUALITY, item.quality + qualityChange);
    }

    void setQuality(int i) {
        getItem().quality = i;
    }
}
