package com.gildedrose;

class GildedRose {
    Item[] items;
//constructeur
    public GildedRose(Item[] items) {
        this.items = items;
    }

    //RIDA EL BARDAI
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
                        default:
                            item.quality--;
                            break;
                    }
                }
                //decrementer le SellIn par 1
                item.sellIn--;
            }
    }

}
