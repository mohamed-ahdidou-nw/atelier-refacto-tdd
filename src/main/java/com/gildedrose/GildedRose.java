package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void myUpdate() {
    	for(Item item:items) {
    		if(item.name.equals("new Item")) {
    			item.quality++;
    		}else if(item.name.equals("old Item")) {
    			item.quality--;
    		}
    	}
    }

    public void updateNotAgedNotBackstage(Item item) {
    	
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
    }
    public void updateQualityLower50(Item item){
    	if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				/*
				 * if (items[i].quality > 0) { if
				 * (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { items[i].quality =
				 * items[i].quality - 1; } }
				 */
            	updateNotAgedNotBackstage(items[i]);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
							/*
							 * if (items[i].quality < 50) { items[i].quality = items[i].quality + 1; }
							 */
                        	updateQualityLower50(items[i]);
                        }

                        if (items[i].sellIn < 6) {
							/*
							 * if (items[i].quality < 50) { items[i].quality = items[i].quality + 1; }
							 */
                        	updateQualityLower50(items[i]);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						/*
						 * if (items[i].quality > 0) { if
						 * (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { items[i].quality =
						 * items[i].quality - 1; } }
						 */
                    	updateNotAgedNotBackstage(items[i]);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
					/*
					 * if (items[i].quality < 50) { items[i].quality = items[i].quality + 1; }
					 */
                	updateQualityLower50(items[i]);
                }
            }
        }
    }
}