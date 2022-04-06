package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) ,
                                    new Item("Sulfuras, Hand of Ragnaros",10,50)};
        GildedRose app = new GildedRose(items);

       /* assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(49, app.items[1].quality);
*/
        shouldBe20after10days(app,app.items[0]);

        assert(app.items[0].quality <= 50);
    }

    void shouldBe20after10days(GildedRose app,Item item) {
        for (int i=0;i<10;i++){
            app.updateQuality();
        }
        assertEquals(20, item.quality);
    }

}
