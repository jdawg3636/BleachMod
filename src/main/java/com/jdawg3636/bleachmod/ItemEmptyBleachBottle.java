package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.item.Item;

public class ItemEmptyBleachBottle extends Item {
    public ItemEmptyBleachBottle() {
        super();
        setUnlocalizedName(Reference.ModItems.EMPTYBLEACHBOTTLE.getUnlocalizedName());
        setRegistryName(Reference.ModItems.EMPTYBLEACHBOTTLE.getRegistryName());
        setMaxStackSize(1);
    }
}