package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 50, 9) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void testerQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 9) };
        GildedRoseRefactor app = new GildedRoseRefactor(items);
        app.updateQuality();
        if(app.items[0].sellIn<10) {
            if (app.items[0].sellIn < 0) {
                assertEquals(0, app.items[0].quality);
            } else if (app.items[0].sellIn < 5) {
                assertEquals(12, app.items[0].quality);
            } else assertEquals(11, app.items[0].quality);
        }else{
             assertEquals(10,app.items[0].quality);
        }

    }
    @Test
    void testerNegativeQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 9) };
        GildedRose app = new GildedRose(items);
        assertEquals(app.items[0].quality>=0,true);
    }
    @Test
    void testerQualityNeverMoreThanFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        assertEquals(app.items[0].quality>=50,false);
    }
}
