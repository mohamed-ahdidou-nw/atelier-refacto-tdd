package com.gildedrose;

import java.util.ArrayList;
import java.util.Dictionary;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ArrayList<String> itemSpec = new ArrayList<>();
        itemSpec.add("Aged Brie");
        itemSpec.add("Backstage passes to a TAFKAL80ETC concert");
        itemSpec.add("Sulfurs, Hand of Ragnaros");
        for (Item item : items) {
            if ((item.quality > 0) && !itemSpec.contains(item.name)) {
                item.quality = item.quality - 1;
            } else if (item.quality < 50) {
                item.quality = item.quality + 1;
                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)
                    && (item.sellIn < 11)
                    && (item.quality < 50)) {
                    if (item.sellIn >= 6) {
                        item.quality = item.quality + 1;
                    } else {
                        item.quality = item.quality + 2;
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!"Aged Brie".equals(item.name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.name)
                        && !"Sulfuras, Hand of Ragnaros".equals(item.name)
                        && item.quality > 0) {
                        item.quality = item.quality - 1;
                    } else {
                        item.quality = 0;
                    }
                } else if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

            }
        }
    }
}
