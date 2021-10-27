package com.gildedrose.items;

public class BackstagePass extends StandardItem {

    public static final int LAST_MINUTE_SELLIN_THRESHOLD = 6;
    public static final int BOOSTED_SELLIN_THRESHOLD = 11;
    public static final int REGULAR_QUALITY_INCREMENT = 1;
    public static final int BOOSTED_QUALITY_INCREMENT = 2;
    public static final int LAST_MINUTE_QUALITY_INCREMENT = REGULAR_QUALITY_INCREMENT + 2;

    BackstagePass(Item originalItem) {
        super(originalItem);
    }

    @Override
    public void updateQuality() {
        int increment = 1;

        if (isExpired()) {
            setQuality(0);
            return;
        }

        if (expiresIn(BOOSTED_SELLIN_THRESHOLD)) {
            increment = BOOSTED_QUALITY_INCREMENT;
        }

        if (expiresIn(LAST_MINUTE_SELLIN_THRESHOLD)) {
            increment = LAST_MINUTE_QUALITY_INCREMENT;
        }

        changeQualityBy(increment);
    }
}
