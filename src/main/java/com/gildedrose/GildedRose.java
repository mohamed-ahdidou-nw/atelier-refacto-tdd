package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //in order to refactoring i use othor methodes to simplify the code
    /* dans ce code là j'ai utiliser la notion de incrementation et décrementation au lieu de faire manuellement*/
    /* aussi j'ai combiner les condition pour etre mieux lisible au lieu de faire a chaque fois if else */

    public void QualityUnderFifty(){
        for (int i = 0; i < items.length; i++) {
            if (items[i].quality < 50) {
                items[i].quality ++;
            }
        }
    }
public void MinceQualityIfIsPositive() {
    for (int i = 0; i < items.length; i++) {
        if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality --;
            }
        }
    }
}

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                MinceQualityIfIsPositive();
            } else {
                QualityUnderFifty();
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")&&(items[i].sellIn < 11)) {

                           QualityUnderFifty();
                        if (items[i].sellIn < 6) {
                            QualityUnderFifty();
                        }
                    }
                }
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn --;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        MinceQualityIfIsPositive();
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    QualityUnderFifty();
                }
            }
        }
    }
}
