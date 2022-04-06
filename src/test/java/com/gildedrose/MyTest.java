package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTest {
	@Test
	void FirstTest() {
		 Item[] items = new Item[] { new Item("new Item", 0, 1) ,
	        		new Item("old Item",22,5),new Item("Aged Brie",22,45)};
	        GildedRose app = new GildedRose(items);
	        app.updateQuality();
	        //app.myUpdate();
	        assertEquals("new Item", app.items[0].name);
	        assertEquals(app.items[0].quality, 0);
	        assertEquals("old Item", app.items[1].name);
	        assertEquals(app.items[1].quality, 4);
	        assertEquals("Aged Brie", app.items[2].name);
	        assertEquals(app.items[2].quality, 46);
	}
}
