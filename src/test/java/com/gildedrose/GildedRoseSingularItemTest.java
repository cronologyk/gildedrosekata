package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseSingularItemTest {

    private static final String SULFURAS_ITEM_KEY = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_ITEM_KEY = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE_CHEESE_KEY = "Aged Brie";

    private static final int DEFAULT_MAX_QUALITY = 50;
    private static final int SULFURAS_QUALITY = 80;
    private static final int BACKSTAGE_PASSES_DOUBLE_VALUE_INCREASE_SELLIN = 10;
    private static final int BACKSTAGE_PASSES_TRIPLE_VALUE_INCREASE_SELLIN = 5;

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo item", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo item", app.items[0].name);
    }

    @Test
    void itDecreasesSellInValue() {
        Item[] items = new Item[] { new Item("foo item", 1, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].sellIn);
    }

    @Test
    void itDecreasesQualityWhileSellInValueHasNotPassed() {
        Item[] items = new Item[] { new Item("foo item", 1, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }
    @Test
    void itDecreasesQualityTwiceWhenSellInValueHasPassed() {
        Item[] items = new Item[] { new Item("foo item", -1, 2) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    void qualityCannotBeNegative() {
        int testQuality = 0;
        Item[] items = new Item[] { new Item("foo item", -1, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(testQuality, items[0].quality);
    }

    @Test
    void qualityCannotExceed50ForAgedBrie() {
        Item[] items = new Item[] { new AgedBrie( 1, DEFAULT_MAX_QUALITY) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(DEFAULT_MAX_QUALITY, items[0].quality);
    }


    @Test
    void agedBrieSellInDecreasesByOneWhenSellInPositive() {
        int testSellIn = 30;
        int expectedSellIn = testSellIn - 1;

        Item[] items = new Item[] { new AgedBrie( testSellIn, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedSellIn, items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQualityForPositiveSellIn() {
        int testQuality = 1;
        int expectedQuality = testQuality + 1;
        Item[] items = new Item[] { new AgedBrie( 1, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void agedBrieIncreasesDoubleInQualityForNegativeSellIn() {
        int testQuality = 1;
        int expectedQuality = 3;
        Item[] items = new Item[] { new AgedBrie( -1, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void sulfurasDoesNotDecreaseInQuality() {
        Item[] items = new Item[] { new Sulfuras() };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SULFURAS_QUALITY, items[0].quality);
    }


    @Test
    void sulfurasDoesNotDecreaseInSellIn() {
        int expectedSellIn = 0;

        Item[] items = new Item[] { new Sulfuras() };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedSellIn, items[0].sellIn);
    }

    @Test
    void backStagePassesIncreaseByOneForSellInHigherThanTen() {
        int testQuality = 30;
        int expectedQuality = testQuality + 1;
        Item[] items = new Item[] { new BackstagePass( 11, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void backStagePassesSellInDecreasesByOneWhenSellInPositive() {
        int testSellIn = 30;
        int expectedSellIn = testSellIn - 1;

        Item[] items = new Item[] { new BackstagePass( testSellIn, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedSellIn, items[0].sellIn);
    }

    @Test
    void backStagePassesIncreaseByTwoForSellEqualTen() {
        int testQuality = 30;
        int expectedQuality = testQuality + 2;
        Item[] items = new Item[] { new BackstagePass( BACKSTAGE_PASSES_DOUBLE_VALUE_INCREASE_SELLIN, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void backStagePassesIncreaseByTwoForSellEqualNine() {
        int testQuality = 30;
        int expectedQuality = testQuality + 2;
        Item[] items = new Item[] { new BackstagePass( BACKSTAGE_PASSES_DOUBLE_VALUE_INCREASE_SELLIN - 1, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void backStagePassesIncreaseByTwoForSellEqualSix() {
        int testQuality = 30;
        int expectedQuality = testQuality + 2;
        Item[] items = new Item[] { new BackstagePass( BACKSTAGE_PASSES_TRIPLE_VALUE_INCREASE_SELLIN + 1, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void backStagePassesIncreaseByTwoForSellEqualOne() {
        int testQuality = 30;
        int expectedQuality = testQuality + 3;
        Item[] items = new Item[] { new BackstagePass( BACKSTAGE_PASSES_TRIPLE_VALUE_INCREASE_SELLIN, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void backStagePassesHaveZeroValueAfterSellIn() {
        int testQuality = 30;
        int expectedQuality = 0;
        Item[] items = new Item[] { new BackstagePass( 0, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    @Test
    void conjurableStandardItemQualityDegradesTwiceAsFast() {
        int testQuality = 30;
        int expectedQuality = 28;

        Item[] items = new Item[] { new ConjurableStandardItem("Satanic pie", 20, testQuality) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }
}
