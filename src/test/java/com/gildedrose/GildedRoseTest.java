package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testAgedBrieShouldIncreaseWithTime(){

        int qualityBefore = 22;
        Item[] items = new Item[]{new Item("Aged Brie", 9, qualityBefore)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // the result quality never have to be changed
        assertEquals(qualityBefore < items[0].quality, true);
    }

    @Test
    void testAnyNegativeQualitiesAfterUpdating(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 9), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 10), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4)
        };

        GildedRose app = new GildedRose(items);
        for (int i =0; i<50; i++){
            app.updateQuality();
        }

        for(Item item: items){
            assertEquals(item.quality > 50, false);
        }
    }

    @Test
    void testConjuredDegradeInQualityTwice(){

        int conjuredQualityBefore = 40;
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 2, 80),
            new Item("Aged Brie", 10, 30)
            //new Item("Conjured", 5, conjuredQualityBefore)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[2].quality, conjuredQualityBefore/2);

    }


}
