package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void bar() {
        Item[] items = new Item[] { new Item("foo", 0, 0),new Item("bar", 0, 0),new Item("baz", 0, 0)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items.length);
    }

    @Test
    void qualiteItemJamaisNegatif(){
        Item[] items = new Item[] { new Item("foo", 0, 0),new Item("bar", 0, 0),new Item("baz", 0, 0)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        for (int i = 0; i < items.length; i++) {
            assert(items[i].quality>=0);
        }
    }

    @Test
    void agedBrieAugementeDeQualiteLorsquElleVieillit(){
        Item ab = new Item("Aged Brie",0,0);
        Item[] items = new Item[]{ab};

        int old = ab.quality;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assert(ab.quality > old);
    }

    @Test
    void qualiteJamaisSupA50(){
        Item ab = new Item("Aged Brie",0,0);
        Item[] items = new Item[]{ab};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assert(ab.quality < 50);
    }

    @Test
    void sulfurasNeDoitJamaisEtreVendu(){
        Item ab = new Item("Sulfuras",1,0);
        Item[] items = new Item[]{ab};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertNotEquals(ab.sellIn,0);
    }

    @Test
    void sulfurasNeDiminuePasDeQualite(){
        Item ab = new Item("Sulfuras",1,0);
        Item[] items = new Item[]{ab};
        int old = ab.quality;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(old,ab.quality);
    }


    @Test
    void backstagePassesQualityTests(){
        Item bp = new Item("Backstage passes to a TAFKAL80ETC concert",9,10);
        Item[] items = new Item[]{bp};
        GildedRose app = new GildedRose(items);
        // 9 jrs
        app.updateQuality();
        app.updateQuality();
        assertEquals(bp.quality,14);
        // 7 jrs
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(bp.quality,21);
        //3 jrs
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(bp.quality,33);

    }




}
