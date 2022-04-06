package com.gildedrose;

public class GildedRoseRefactor {
    Item[] items;

    public GildedRoseRefactor(Item[] items) {
        this.items = items;
    }

    public void modifiedUpdateQuality() {
        for (Item it : items) {
            switch(it.name){
                case "Backstage passes to a TAFKAL80ETC concert" :
                    updateitem1(it);
                case "Aged Brie" :
                    updateitem2(it);
                case "Sulfuras, Hand of Ragnaros" :
                    updateitem3(it);
                default: updateitem4(it);
            }
        }
    }
    private void updateitem1(Item it) {
        if (it.quality < 50) {
            it.quality ++;
        }
        if (it.sellIn < 11 && it.quality<50){
            it.quality ++;
            if (it.sellIn < 6)
                it.quality ++;
        }
        it.sellIn --;
        if(it.sellIn<0){
            it.quality = 0;
        }
    }
    private void updateitem2(Item it) {
        if (it.quality < 50) {
            it.quality ++;
        }
        it.sellIn --;
        if ((it.sellIn < 0)&&(it.quality < 50)) {
            it.quality ++;
        }
    }
    private void updateitem3(Item it) {
    }
    private void updateitem4(Item it) {
        if (it.quality > 0)
            it.quality --;
        it.sellIn --;
        if ((it.sellIn < 0)&& (it.quality > 0)){
            it.quality --;
        }
    }
}
