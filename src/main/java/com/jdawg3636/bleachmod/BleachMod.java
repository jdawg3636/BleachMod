package com.jdawg3636.bleachmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.ArrayList;

public class BleachMod implements ModInitializer {

    @Override
    public void onInitialize() {
        // This is extremely over-engineered since I tried to maintain a similar structure to the Minecraft Forge version. I apologize for nothing <3
        Reference.BLOCKS.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        Reference.ITEMS.forEach((identifier, item) -> Registry.register(Registries.ITEM, identifier, item));
        Reference.CREATIVE_TAB_MAPPINGS.keySet().forEach((itemGroup) -> ItemGroupEvents.modifyEntriesEvent(itemGroup).register((entries) -> onBuildContentsCreativeModeTabEvent(itemGroup, entries)));
    }

    public void onBuildContentsCreativeModeTabEvent(RegistryKey<ItemGroup> itemGroup, FabricItemGroupEntries entries) {
        Reference.CREATIVE_TAB_MAPPINGS.getOrDefault(itemGroup, new ArrayList<>()).forEach(itemSupplier -> entries.add(itemSupplier.get()));
    }

}
