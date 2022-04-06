package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i].name.equals("Sulfuras, Hand of Ragnaros"))continue;
            int degree=1,toAdd=-1;
            items[i].sellIn = items[i].sellIn - 1;
            if(items[i].sellIn<0){
                if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                    items[i].quality=0;
                    continue;
                }
                degree*=2;
            }
            switch (items[i].name) {
                case "Conjured":
                    degree *= 2;
                    break;
                case "Aged Brie":
                    toAdd = 1;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].sellIn < 5) toAdd = 3;
                    else if (items[i].sellIn < 10) toAdd = 2;
                    else toAdd = 1;
                    break;
            }
            items[i].quality=items[i].quality+(toAdd*degree);
            if(items[i].quality>50)items[i].quality=50;
            else if(items[i].quality<0)items[i].quality=0;
        }
    }
}
