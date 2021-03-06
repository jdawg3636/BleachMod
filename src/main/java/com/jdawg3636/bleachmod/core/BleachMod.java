package com.jdawg3636.bleachmod.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Reference.MODID)
public class BleachMod {

    public BleachMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onRegisterBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(Reference.modBlocks);
        }

        @SubscribeEvent
        public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
            // Items
            event.getRegistry().registerAll(Reference.modItems);
            // ItemBlocks
            for(int i = 0; i < Reference.modBlocks.length; i++) {
                // Copies original Block's registry name to the new ItemBlock
                event.getRegistry().register(new BlockItem(Reference.modBlocks[i], new Item.Properties().tab(CreativeModeTab.TAB_SEARCH)).setRegistryName(Reference.modBlocks[i].getRegistryName()));
            }
        }
    }

}
