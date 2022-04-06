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
    void QualityNeg() {
    	Item[] items= new Item[]{new Item("Aged Brie",0,0)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assert(app.items[0].quality>=0);
    	
    }
    
    @Test
    void Quality_NotNeg_AllItems() {
    	Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	for(Item it:items) {
    		assert(it.quality>=0);
    	}
    }
    	
    	  @Test
    	    void Quality_NotMore50_AllItems() {
    	    	Item[] items = new Item[] {
    	                new Item("+5 Dexterity Vest", 10, 20), //
    	                new Item("Aged Brie", 2, 0), //
    	                new Item("Elixir of the Mongoose", 5, 7), //
    	                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
    	                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
    	                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
    	                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
    	                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
    	                // this conjured item does not work properly yet
    	                new Item("Conjured Mana Cake", 3, 6) };
    	    	GildedRose app = new GildedRose(items);
    	    	app.updateQuality();
    	    	for(Item it:items) {
    	    		assert(it.quality<=50);
    	    	}
    	
    	
    }
    	  @Test
    	  void SulfurasSellIn() {
    	        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
    	        GildedRose app = new GildedRose(items);
    	        app.updateQuality();
    	        assert(items[0].sellIn==80);
    	    }
    	  
    	  
    

}
