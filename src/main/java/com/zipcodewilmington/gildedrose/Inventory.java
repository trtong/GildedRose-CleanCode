package com.zipcodewilmington.gildedrose;


public class Inventory {
    private Item[] items;
    static final String BRIE = "Aged Brie";
    static final String BACK_PASS = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    // Updates the quality for 1 day
    public void updateQuality() {

        for (Item item: items) {
            // make a switch statement

            switch (item.getName()){

            case BRIE:
                if (!checkQuality(item, 1)) {
                    adjustItemQuality(item, 1);
                } else {
                    setQualityMax(item);
                }

                decreaseSellIn(item);

                break;

            case BACK_PASS:
                if (item.getSellIn() < 0) {
                    setQualityZero(item);

                } else if (item.getSellIn() <= 5) {
                    if (!checkQuality(item, 2)) {
                        adjustItemQuality(item, 2);
                    } else {
                        setQualityMax(item);
                    }

                } else if (item.getSellIn() <= 10) {
                    if (!checkQuality(item, 3)) {
                        adjustItemQuality(item, 3);
                    } else {
                        setQualityMax(item);
                    }
                }

                decreaseSellIn(item);

                break;


            case SULFURAS:
                item.setQuality(80);
                item.setSellIn(item.getSellIn());



            };
        }
    }

    public void decreaseSellIn(Item name) {
        name.setSellIn(name.getSellIn() - 1);

    }

    public boolean checkQuality(Item name, int addQuality) {
        boolean isQuality50 = false;

        if (name.getQuality() + addQuality < 50) {
            isQuality50 = false;
        } else {
            isQuality50 = true;
        }

        return isQuality50;
    }

    public void setQualityMax(Item item) {
        item.setQuality(50);
    }

    public void setQualityZero(Item item) {
        item.setQuality(0);
    }


    public void adjustItemQuality(Item name, int qualityIncrement) {

    }





//    public void increaseQuality(int i){
//
//        int quality = item.getQuality() + i;
//        if (quality > 50) {
//            quality = 50;
//        }
//
//        item.setQuality(quality);
//    }

    public Item[] getItems(){
        return this.items;
    }


















//    // Old Code
//    public void updateQuality() {
//        // Giant for loop representing the "day" each day, the quality's of items change.
//
//        for (int i = 0; i < items.length; i++) {
//
//            // This if statement checks if it is NOT aged brie and NOT backstage passes
//            if (!items[i].getName().equals("Aged Brie")
//                    && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
//                // if it's not brie and bspasses
//                if (items[i].getQuality() > 0) {
//                    // checks if the quality is over 0
//                    if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
//                        // as long as it's not surlfuras...
//                        // quantity is decreased by 1
//                        items[i].setQuality(items[i].getQuality() - 1);
//                    }
//                }
//
//
//
//            } else {
//
//                // Next leg of IF statement quality < 50 then increase quality by 1
//
//                if (items[i].getQuality() < 50) {
//                    // if the quality is below 50
//                    items[i].setQuality(items[i].getQuality() + 1);
//                    // the quality is increased by 1
//
//                    // stuff about backstage passes
//                    if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
//                        // if the item is a backstagepass
//
//                        if (items[i].getSellIn() < 11) {
//                            // and if the backstage pass has to sell in 11 days
//                            if (items[i].getQuality() < 50) {
//                                // and the quality is below 50
//                                items[i].setQuality(items[i].getQuality() + 1);
//                                // then add 1 to the quality
//                            }
//                        }
//
//                        if (items[i].getSellIn() < 6) {
//                            // if the bspass has to sell in 6 days
//                            if (items[i].getQuality() < 50) {
//                                // and the quality is less than 50
//                                items[i].setQuality(items[i].getQuality() + 1);
//                                // then add 1 to the quality
//                            }
//                        }
//                    }
//                }
//            }
//
//            // another if the item IS NOT SULFURAS
//
//            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].setSellIn(items[i].getSellIn() - 1);
//            }
//            // then decrease the sellin day by 1
//
//
//            // checks the items sell in
//            // if the items sell in is less than 0 (no sellin is negative)
//            if (items[i].getSellIn() < 0) {
//
//                if (!items[i].getName().equals("Aged Brie")) {
//                    // and the item IS NOT Brie
//                    if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        // and the item IS NOT BSPASSES
//                        if (items[i].getQuality() > 0) {
//                            // if the item quality is greater than 0,
//
//                            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
//                                // and the item is NOT SULFURAS,
//                                items[i].setQuality(items[i].getQuality() - 1);
//                                // the item quality -1
//                            }
//                        }
//                    } else { // if the item IS a backstage pass
//                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
//                    }
//                } else { // if the item IS BRIE
//                    if (items[i].getQuality() < 50) {
//                        // BRIE QUALITY is LESS THAN 50
//                        items[i].setQuality(items[i].getQuality() + 1);
//                        // Increase Brie's quality by 1
//                    }
//                }
//            }
//        }
//    }
}