package com.gildedrose.items;

public class StandardItem extends BaseItem implements ConjurableItem {

    public static final int DEFAULT_SELLIN_DECREMENT = 1;
    public static final int DEFAULT_QUALITY_DECREMENT = 1;
    public static final int EXPIRED_QALITY_DECREMENT = 2;

    StandardItem(Item originalItem) {
        super(originalItem);
    }

    @Override
    public void updateQuality() {
        int decrement = isExpired() ? EXPIRED_QALITY_DECREMENT : DEFAULT_QUALITY_DECREMENT;

        changeQualityBy(-decrement);
    }

    @Override
    public void updateSellIn() {
        decreaseSellInBy(DEFAULT_SELLIN_DECREMENT);
    }

    @Override
    public boolean isConjured() {
        return false;
    }
}
