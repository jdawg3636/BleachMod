package com.jdawg3636.bleachmod.core;

import com.jdawg3636.bleachmod.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Reference {

    // Mod Info
    public static final String MODID = "bleachmod";

    // Damage Sources
    public static final DamageSource DAMAGE_SOURCE_BLEACH = new BleachModDamageSource("bleach_damage");
    public static final DamageSource DAMAGE_SOURCE_SOLID_BLEACH = new BleachModDamageSource("solid_bleach_damage");
    public static final DamageSource DAMAGE_SOURCE_WINDEX = new BleachModDamageSource("windex_damage");

    // Deferred Registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Blocks
    public static final RegistryObject<Block> BLOCK_SOLID_BLEACH = Reference.BLOCKS.register("solid_bleach", BlockSolidBleach::new);

    // Items
    public static final RegistryObject<Item> ITEM_EMPTY_BLEACH_BOTTLE = Reference.ITEMS.register("empty_bleach_bottle", ItemEmptyBleachBottle::new);
    public static final RegistryObject<Item> ITEM_BLEACH_BOTTLE = Reference.ITEMS.register("bleach_bottle", ItemBleachBottle::new);
    public static final RegistryObject<Item> ITEM_EMPTY_WINDEX_BOTTLE = Reference.ITEMS.register("empty_windex_bottle", ItemEmptyWindexBottle::new);
    public static final RegistryObject<Item> ITEM_WINDEX_BOTTLE = Reference.ITEMS.register("windex_bottle", ItemWindexBottle::new);
    public static final RegistryObject<Item> ITEM_SOLID_BLEACH = Reference.ITEMS.register("solid_bleach", () -> new BlockItem(BLOCK_SOLID_BLEACH.get(), new Item.Properties().tab(CreativeModeTab.TAB_SEARCH)));

}
