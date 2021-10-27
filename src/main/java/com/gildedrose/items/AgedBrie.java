package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends StandardItem {

    public static final int DEFAULT_QUALITY_INCREMENT = 1;
    public static final int DOUBLED_QUALITY_INCREMENT = DEFAULT_QUALITY_INCREMENT * 2;

    AgedBrie(Item originalItem) {
        super(originalItem);
    }

    @Override
    public void updateQuality() {
        int increment = DEFAULT_QUALITY_INCREMENT;

        if (isExpired()) {
            increment = DOUBLED_QUALITY_INCREMENT;
        }

        changeQualityBy(increment);
    }
}
