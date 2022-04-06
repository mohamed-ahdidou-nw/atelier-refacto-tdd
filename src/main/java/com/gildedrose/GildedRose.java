package com.gildedrose;

import java.util.ArrayList;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {

        this.items = items;
    }

    public void updateQuality() {
        String[] not={"Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"};
        for (int i = 0; i < items.length; i++) {
            if (items[i].quality > 0 && items[i].quality < 50  )
            {
                for(int j=0; j<not.length; j++){
                    if(items[i].name!=not[j]){
                        items[i].quality = items[i].quality - 1;
                    }else{
                        items[i].quality = items[i].quality + 1;
                    }
                }
                if (items[i].name==not[1]) {
                    if (items[i].sellIn < 11) {
                            items[i].quality = items[i].quality + 1;

                    }
                    if (items[i].sellIn < 6) {
                            items[i].quality = items[i].quality + 1;
                    }
                }

                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }

        if (items[i].sellIn < 0) {
            if (!items[i].name.equals("Aged Brie")) {
                if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                    items[i].quality = items[i].quality + 1;
            }
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
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
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {

                        items[i].quality = items[i].quality + 1;

                }
            }
        }
    }
}
