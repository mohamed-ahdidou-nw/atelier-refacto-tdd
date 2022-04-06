package com.gildedrose;

class GildedRose {
    Item[] items;
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";
    private final String agedBrie = "Aged Brie";
    private final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public boolean itemNameNotAgedBrie(Item item)
    {
        return !item.name.equals(agedBrie);
    }
    public boolean itemNameNotBackstagePasses(Item item)
    {
        return !item.name.equals(backstage);
    }
    public boolean itemNameNotSulfuras(Item item)
    {
        return !item.name.equals(sulfuras);
    }
    public boolean itemQualitySup0(Item item)
    {
        return (item.quality>0);
    }
    public void refactoringUpdateQuality(){
        for(Item it : items)
        {
            if(itemNameNotAgedBrie(it) && itemNameNotBackstagePasses(it))
            {
                if(itemQualitySup0(it))
                {

                }

            }
        }
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

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
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
