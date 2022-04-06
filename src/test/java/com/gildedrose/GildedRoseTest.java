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
    void testSulfuras_Hand_of_RagnarosNeverChangesQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void testQualityDegradeRateIsAsExpectForNormalItems()
    {
        Item[] items = new Item[] { new Item("foo", 40, 50) };
        GildedRose app = new GildedRose(items);
        int expected=50;
        for (int i = 0; i< 51 ;i++){
            app.updateQuality();
            if(expected>0){
            if(items[0].sellIn<0){
                expected=expected-2;
            }else {
                expected--;
            }
                if(expected<0)expected=0;
            }
            assertEquals(expected, app.items[0].quality);
        }
    }
    @Test
    void testAgedBrieIncreasesQuality()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 40, 1) };
        GildedRose app = new GildedRose(items);
        int expected=1;
        for (int i = 0; i< 51 ;i++){
            app.updateQuality();
            if(expected<50){
                if(items[0].sellIn>=0) expected++;
                else expected=expected+2;
                if(expected>50)expected=50;
            }

            assertEquals(expected, app.items[0].quality);
        }
    }
    @Test
    void testBackstagepassesQualityRate()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 40, 1) };
        GildedRose app = new GildedRose(items);
        int expected=1;
        for (int i = 0; i< 51 ;i++){
            app.updateQuality();
            if(items[0].sellIn>=0) {
                if(expected<50){
                if(items[0].sellIn>=10) expected++;
                    else {
                        if(items[0].sellIn<5){
                            expected=expected+3;
                        }else {
                            expected=expected+2;
                        }
                    }
                }
                if(expected>50)expected=50;
            }else expected=0;
            assertEquals(expected, app.items[0].quality);
        }
    }
    @Test
    void testQualityDegradeRateIsAsExpectForConjuredItems()
    {
        Item[] items = new Item[] { new Item("Conjured", 40, 50) };
        GildedRose app = new GildedRose(items);
        int expected=50;
        for (int i = 0; i< 51 ;i++){
            app.updateQuality();
            if(expected>0){
                if(items[0].sellIn<0){
                    expected=expected-4;
                }else {
                    expected=expected-2;
                }
                if(expected<0)expected=0;
            }
            assertEquals(expected, app.items[0].quality);
        }
    }
}
