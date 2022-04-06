package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        //app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void incremetQualityForSellInLessThan11()
    {
        Item[] items = new Item[] { new Item("item1", 9, 0) };
        GildedRose app = new GildedRose(items);
        //app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void incremetQualityForSellInLessThan6()
    {
        Item[] items = new Item[] { new Item("item1", 9, 0) };
        GildedRose app = new GildedRose(items);
        //app.updateQuality();
        assertEquals(3, app.items[1].quality);
    }

    @Test
    void AfterConcertQuality()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.Traitement();
       // app.updateQuality();
        assertEquals(0, app.items[0].quality);

    }
    //respected
    @Test
    void SellInNegative()
    {
        Item[] items = new Item[] { new Item("item", -2, 20) };
        GildedRose app = new GildedRose(items);
        //app.updateQuality();
        assertEquals(18, app.items[0].quality);

    }

}
