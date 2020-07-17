package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemEmptyBleachBottle extends Item {
    public ItemEmptyBleachBottle() {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.SEARCH));
        setRegistryName(Reference.MODID, "empty_bleach_bottle");
    }
}