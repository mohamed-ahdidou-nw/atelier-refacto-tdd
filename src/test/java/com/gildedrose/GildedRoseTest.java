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
    void conjured() {
        Item[] items = new Item[] { new Item("Conjured", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assert( app.items[0].quality<5);
    }
    @Test
    void Aged() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assert( app.items[0].quality==12);
    }

    @Test
    void quant() {
        Item[] items = new Item[] { new Item("Sulfuras", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
      //  quality( app.items[0].quality);
        assert(app.items[0].quality>=0);
        assert(app.items[0].quality<50);
    }


}
