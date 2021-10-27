package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.api.IBaseItem;

public class ItemFactory {

    private static final String SULFURAS_ITEM_KEY = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_ITEM_KEY = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE_CHEESE_KEY = "Aged Brie";

    private static final String CONJURED_PREFIX = "Conjured ";

    public static IBaseItem createItem(Item item) {
        IBaseItem baseItem;

        String baseName = getBaseName(item.name);

        switch(baseName) {
            case BRIE_CHEESE_KEY: {
                baseItem = new AgedBrie(item);
                break;
            }
            case BACKSTAGE_PASSES_ITEM_KEY: {
                baseItem = new BackstagePass(item);
                break;
            }
            case SULFURAS_ITEM_KEY: {
                baseItem = new Sulfuras(item);
                break;
            }
            default:
                baseItem = new StandardItem(item);
        }

        if (isConjured(item.name)) {
            baseItem = new ConjuredItem(baseItem);
        }

        return baseItem;
    }

    private static String getBaseName(String name) {
        return name.replace(CONJURED_PREFIX, "");
    }

    private static boolean isConjured(String name) {
        return name.startsWith(CONJURED_PREFIX);
    }
}
