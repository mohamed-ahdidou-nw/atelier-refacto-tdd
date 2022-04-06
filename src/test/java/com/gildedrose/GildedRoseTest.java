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
//teste unitaire permetre de tester si le nom de item apres update equal Aged Brie

    @Test
    void TestNameAfterUpdatEqualAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);

    }
    //teste unitaire permetre de tester si la quality de item apres update ajouter 2 sur l'existant

    @Test
    void TestQualityAfterUpdatIncrementByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);

    }

}
