package com.gildedrose.items;

public class ItemFactory {

    private static final String SULFURAS_ITEM_KEY = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_ITEM_KEY = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE_CHEESE_KEY = "Aged Brie";

    public static BaseItem createItem(Item item) {
        switch(item.name) {
            case BRIE_CHEESE_KEY: return new AgedBrie(item);
            case BACKSTAGE_PASSES_ITEM_KEY: return new BackstagePass(item);
            case SULFURAS_ITEM_KEY: return new Sulfuras(item);
            default: return new StandardItem(item);
        }

    }
}
