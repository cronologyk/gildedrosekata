package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseMultipleItemsTest {

    @Test
    void allRegularItemsHaveTheirSellInUpdated() {
        int testSellIn1 = 1;
        int testSellIn2 = 2;
        int testSellIn3 = 3;
        Item testItem1 = new Item("testItem1", testSellIn1, testSellIn1);
        Item testItem2 = new Item("testItem2", testSellIn2, testSellIn2);
        Item testItem3 = new Item("testItem3", testSellIn3, testSellIn3);

        Item[] items = new Item[] { testItem1, testItem2, testItem3 };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, testItem1.sellIn);
        assertEquals(1, testItem2.sellIn);
        assertEquals(2,testItem3.sellIn);
    }
}
