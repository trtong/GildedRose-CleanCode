package com.zipcodewilmington.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Creating tests for the Inventory Class
 * The Inventory class will keep track of SellIn & Quality
 *
 */

public class InventoryTest {
    Inventory inventory;

    public InventoryTest() {

        Item wine = new Item("wine", 2, 25);
        Item agedBrie = new Item("Aged Brie", 1, 45);
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25);
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80 );

        Item[] items = {wine, agedBrie, passes, sulfuras};

        inventory = new Inventory(items);
    }

    public void assertTestValues(Inventory inventory, int days, int wineSellIn, int wineQuality, int brieSellIn, int brieQuality,
                                 int passSellIn, int passQuality, int sulfurasSellIn, int sulfurasQuality) {
        for (int i = 0; i < days; i++) {
            inventory.updateQuality();
        }
        Item[] items = inventory.getItems();
        Item currentItem = items[0];
        Assert.assertSame("wine", currentItem.getName());
        Assert.assertEquals(wineSellIn, currentItem.getSellIn());
        Assert.assertEquals(wineQuality, currentItem.getQuality());

        currentItem = items[1];
        Assert.assertSame("Aged Brie", currentItem.getName());
        Assert.assertEquals(brieSellIn, currentItem.getSellIn());
        Assert.assertEquals(brieQuality, currentItem.getQuality());

        currentItem = items[2];
        Assert.assertSame("Backstage passes to a TAFKAL80ETC concert", currentItem.getName());
        Assert.assertEquals(passSellIn, currentItem.getSellIn());
        Assert.assertEquals(passQuality, currentItem.getQuality());

        currentItem = items[3];
        Assert.assertSame("Sulfuras, Hand of Ragnaros", currentItem.getName());
        Assert.assertEquals(sulfurasSellIn, currentItem.getSellIn());
        Assert.assertEquals(sulfurasQuality, currentItem.getQuality());
    }

    @Test
    public void updateQualityTest(){
        // Given

        // One day
        assertTestValues(inventory, 1, 1, 24, 0, 46, 10, 26, 10, 80);

        // One more day
        assertTestValues(inventory, 1, 0, 23, -1, 48, 9, 28, 10, 80);

        // Four more days
        assertTestValues(inventory, 4, -4, 15, -5, 50, 5, 36, 10, 80);

        // Three more days
        assertTestValues(inventory, 3, -7, 9, -8, 50, 2, 45, 10, 80);

        // Five more days
        assertTestValues(inventory, 5, -12, 0, -13, 50, -3, 0, 10, 80);
    }

}

