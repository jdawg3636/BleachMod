package com.jdawg3636.bleachmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemEmptyBleachBottle extends Item {
    public ItemEmptyBleachBottle() {
        super(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_SEARCH));
    }
}