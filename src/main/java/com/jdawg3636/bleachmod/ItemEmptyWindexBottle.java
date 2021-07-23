package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class ItemEmptyWindexBottle extends Item {
    public ItemEmptyWindexBottle() {
        super(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_SEARCH));
        setRegistryName(Reference.MODID, "empty_windex_bottle");
    }
}
