package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemEmptyWindexBottle extends Item {
    public ItemEmptyWindexBottle() {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.SEARCH));
        setRegistryName(Reference.MODID, "empty_windex_bottle");
    }
}
