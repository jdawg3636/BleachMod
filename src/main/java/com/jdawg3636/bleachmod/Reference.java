package com.jdawg3636.bleachmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class Reference {

    // Mod Info
    public static final String MODID = "bleachmod";

    // Damage Types
    public static final ResourceKey<DamageType> DAMAGE_TYPE_BLEACH = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MODID, "bleach"));
    public static final ResourceKey<DamageType> DAMAGE_TYPE_SOLID_BLEACH = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MODID, "solid_bleach"));
    public static final ResourceKey<DamageType> DAMAGE_TYPE_WINDEX = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MODID, "windex"));

    public static DamageSource getDamageSource(Level level, ResourceKey<DamageType> damageType) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType));
    }

    // Deferred Registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final HashMap<CreativeModeTab, ArrayList<RegistryObject<Item>>> CREATIVE_TAB_MAPPINGS = new HashMap<>();

    // Blocks
    public static final RegistryObject<Block> BLOCK_SOLID_BLEACH = Reference.BLOCKS.register("solid_bleach", BlockSolidBleach::new);

    // Items
    public static final RegistryObject<Item> ITEM_EMPTY_BLEACH_BOTTLE = registerItem("empty_bleach_bottle", () -> new Item(new Item.Properties().stacksTo(1)), CreativeModeTabs.FOOD_AND_DRINKS);
    public static final RegistryObject<Item> ITEM_BLEACH_BOTTLE = registerItem("bleach_bottle", () -> new ItemHarmfulDrink(() -> ITEM_EMPTY_BLEACH_BOTTLE.get().getDefaultInstance(), DAMAGE_TYPE_BLEACH), CreativeModeTabs.FOOD_AND_DRINKS);
    public static final RegistryObject<Item> ITEM_EMPTY_WINDEX_BOTTLE = registerItem("empty_windex_bottle", () -> new Item(new Item.Properties().stacksTo(1)), CreativeModeTabs.FOOD_AND_DRINKS);
    public static final RegistryObject<Item> ITEM_WINDEX_BOTTLE = registerItem("windex_bottle", () -> new ItemHarmfulDrink(() -> ITEM_EMPTY_WINDEX_BOTTLE.get().getDefaultInstance(), DAMAGE_TYPE_WINDEX), CreativeModeTabs.FOOD_AND_DRINKS);
    public static final RegistryObject<Item> ITEM_SOLID_BLEACH = registerItem("solid_bleach", () -> new BlockItem(BLOCK_SOLID_BLEACH.get(), new Item.Properties()), CreativeModeTabs.SEARCH);

    // Utility Methods
    public static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier, CreativeModeTab creativeModeTab) {
        RegistryObject<Item> itemRegistryObject = Reference.ITEMS.register(name, itemSupplier);
        if(creativeModeTab != null) registerCreativeTabMapping(creativeModeTab, itemRegistryObject);
        return itemRegistryObject;
    }

    public static void registerCreativeTabMapping(CreativeModeTab creativeModeTab, RegistryObject<Item> itemRegistryObject) {
        ArrayList<RegistryObject<Item>> itemsInTab = Reference.CREATIVE_TAB_MAPPINGS.getOrDefault(creativeModeTab, new ArrayList<>());
        itemsInTab.add(itemRegistryObject);
        Reference.CREATIVE_TAB_MAPPINGS.put(creativeModeTab, itemsInTab);
    }

}
