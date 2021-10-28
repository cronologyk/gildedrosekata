package com.gildedrose.updaters;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;


public class UpdaterFactory {

    Map<Class<? extends Item>, Updater<? extends Item>> registeredUpdaters = new HashMap<>();

    public void register(Class<? extends Item> clazz, Updater<? extends Item> updater) {
        this.registeredUpdaters.put(clazz, updater);
    }

    public Updater<? extends Item> getUpdater(Class<? extends Item> clazz) {
        return registeredUpdaters.get(clazz);
    }
}
