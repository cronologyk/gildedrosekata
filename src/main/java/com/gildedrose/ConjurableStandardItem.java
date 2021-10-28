package com.gildedrose;

import com.gildedrose.updaters.Conjurable;

public class ConjurableStandardItem extends Conjurable {
    public ConjurableStandardItem(String name, int sellin, int quality) {
        super(new StandardItem(name, sellin, quality));
    }
}
