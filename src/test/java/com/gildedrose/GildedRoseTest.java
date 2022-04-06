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
    void qualityIsNeverNegative(){
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        for(int i=0 ;i<12;i++)
            app.updateQuality();
        assert(app.items[0].quality>=0);
    }

    @Test
    void qualityIsNeverMore50(){
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        for(int i=0 ;i<12;i++)
            app.updateQuality();
        assert(app.items[0].quality<50);
    }
    @Test
    void nameIsSulfurasNotSelledQualityNotDecrease(){
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int q = app.items[0].quality;//save the quality of the item

        assertEquals("Sulfuras",app.items[0].name);
        assert(app.items[0].sellIn==0);//if item not selled (sellIn=0)
        assert (app.items[0].quality>=q);//if quality not decrease
    }

}

