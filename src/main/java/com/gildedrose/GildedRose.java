package com.gildedrose;

class GildedRose {
    Item[] items;
//constructeur
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(){
        //on parcour la liste des items
        for (Item item :
            items) {
            //si la qualite est superieur a 50 ne doit pas etre modifié
                if (item.quality < 50){
                    //switch sur le nom pour trouver le traitement convenable a ce item
                    switch (item.name) {
                        case "Aged Brie":
                            item.quality++;
                            break;
                        case "Sulfuras, Hand of Ragnaros":
                            //étant un objet légendaire, ne doit jamais être vendu ou diminue en qualité
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert":
                           if(10 >= item.sellIn) item.quality++;
                           if(5 < item.sellIn && item.sellIn < 10) item.quality = item.quality + 2;
                           if(0 < item.sellIn && item.sellIn <= 5) item.quality = item.quality + 3;
                           break;
                    }
                }
                //decrementer le SellIn par 1
                item.sellIn--;
            }
    }





    public void updateQuality2() {
        //parcourir tout le tableau
        for (int i = 0; i < items.length; i++) {
            //si le nom du produit n'est pas aged brid
            //et aussi n'est pas Backstage passes to a TAFKAL80ETC concert
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                //si la qualite est sup a zero
                if (items[i].quality > 0) {
                    //si nom du produit n'est pas "Sulfuras, Hand of Ragnaros"
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        //decrementer la qualite
                        items[i].quality = items[i].quality - 1;
                    }
                }
                //si nom est "aged brie" et "backstage passes"
            } else {
                //on verifie si qualite inf a 50
                if (items[i].quality < 50) {
                    //si oui on incremente par 1
                    items[i].quality = items[i].quality + 1;
                    //si c'est seulement backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //si le sellin de ce backstage est inferieur a 11
                        if (items[i].sellIn < 11) {
                            //et la qualite < 50
                            if (items[i].quality < 50) {
                                //incrementer qualite
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
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
