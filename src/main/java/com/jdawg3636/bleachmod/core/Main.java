package com.jdawg3636.bleachmod.core;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid= "bleachmod", version="1.12.2-1.1", name="jdawg3636's Bleach Mod", acceptedMinecraftVersions="[1.12,)")
@Mod.EventBusSubscriber
public class Main {

    // Register Blocks
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        // Register Blocks
        for(Block block : Reference.modBlocks) {
            event.getRegistry().register(block);
        }
    }

    // Register Items
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        // Register Items
        for(Item item : Reference.modItems) {
            event.getRegistry().register(item);
        }
        // Register ItemBlocks
        for(Block block : Reference.modBlocks) {
            ItemBlock itemBlock = new ItemBlock(block);
            itemBlock.setRegistryName(block.getRegistryName());
            event.getRegistry().register(itemBlock);
        }
    }

    // Register Models for Items and Blocks
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent event) {
        // Register Item Renders
        for(Item item : Reference.modItems) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        // Register Block Renders
        for(Block block : Reference.modBlocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }

}
