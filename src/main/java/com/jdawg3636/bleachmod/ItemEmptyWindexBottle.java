package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.item.Item;

public class ItemEmptyWindexBottle extends Item {
    public ItemEmptyWindexBottle() {
        setUnlocalizedName(Reference.ModItems.EMPTYWINDEXBOTTLE.getUnlocalizedName());
        setRegistryName(Reference.ModItems.EMPTYWINDEXBOTTLE.getRegistryName());
        setMaxStackSize(1);
    }
}
