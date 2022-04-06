package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.Refactoring();
        assertEquals("fixme", app.items[0].name);
    }
    @Test
    void AgedBrieValidatorlessThan10()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.Refactoring();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void AgedBrieValidatorlessthan5()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.Refactoring();
        assertEquals(3, app.items[0].quality);
    }
    @Test
    void sellin()
    {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        GildedRose app = new GildedRose(items);
        app.Refactoring();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void Concert()
    {
        Item[] items = new Item[] {
            new Item("item", -1, 20)
        };
        GildedRose app = new GildedRose(items);
        app.Refactoring();
        assertEquals(18, app.items[0].quality);
    }

}
