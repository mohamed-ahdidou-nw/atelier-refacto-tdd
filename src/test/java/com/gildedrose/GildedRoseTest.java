package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Quality shouldn't be negative ")
    void qualityShouldNotBeNegative ()
    {
        Item[] items = new Item[] {  new Item("+5 Dexterity Vest", 0, 0), //
                                    new Item("Aged Brie", 0, 0), //
                                    new Item("Elixir of the Mongoose", 0, 0), //
                                    new Item("Sulfuras, Hand of Ragnaros", 0, 0), //
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                                    new Item("Conjured Mana Cake", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (Item it: items)
            assertTrue(it.quality >= 0);
    }

    @Test
    @DisplayName("Quality shouldn't be more than 50 ")
    void qualityShouldNotBeMoreThan50 ()
    {
        Item[] items = new Item[] {  new Item("+5 Dexterity Vest", 0, 50), //
                                    new Item("Aged Brie", 0, 50), //
                                    new Item("Elixir of the Mongoose", 0, 50), //
                                    new Item("Sulfuras, Hand of Ragnaros", 0, 50), //
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                                    new Item("Conjured Mana Cake", 0, 50),
                                    new Item("+5 Dexterity Vest", -1, 50), //
                                    new Item("Aged Brie", -1, 50), //
                                    new Item("Elixir of the Mongoose", -1, 50), //
                                    new Item("Sulfuras, Hand of Ragnaros", -1, 50), //
                                    new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50),
                                    new Item("Conjured Mana Cake", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (Item it: items)
            assertTrue(it.quality <= 50);
    }

    @Test
    void sulfurasShouldNotbeUpdated()
    {
        Item[] items = new Item[] {  new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality == 80);
    }



}
