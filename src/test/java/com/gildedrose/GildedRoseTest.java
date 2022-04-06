package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        System.out.println(app.items[0].name+"    "+app.items[0].quality+"    "+app.items[0].sellIn);
       assertEquals("Aged Brie", app.items[0].name);
    }
    @Test
    void qualite_item_never_more_than_50(){
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 20), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        for(int i=0;i<100;i++) {
            app.updateQuality();
        }
        for(int i=0;i<items.length;i++) {
           assert(items[i].quality<=50);
        }
    }
    @Test
    void quality_item_never_negative(){
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 20), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        for(int i=0;i<100;i++) {
            app.updateQuality();
        }
        for(int i=0;i<items.length;i++) {
            assert(items[i].quality>=0);
        }
    }
}
