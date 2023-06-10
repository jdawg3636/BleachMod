package com.jdawg3636.bleachmod;

import net.minecraft.block.Block;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class Reference {

    // Mod Info
    public static final String MODID = "bleachmod";

    // Damage Types
    public static final RegistryKey<DamageType> DAMAGE_TYPE_BLEACH = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(MODID, "bleach"));
    public static final RegistryKey<DamageType> DAMAGE_TYPE_SOLID_BLEACH = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(MODID, "solid_bleach"));
    public static final RegistryKey<DamageType> DAMAGE_TYPE_WINDEX = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(MODID, "windex"));

    public static DamageSource getDamageSource(World level, RegistryKey<DamageType> damageType) {
        return new DamageSource(level.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(damageType));
    }

    // Not-So-Deferred Registers
    public static final HashMap<Identifier, Block> BLOCKS = new HashMap<>();
    public static final HashMap<Identifier, Item> ITEMS = new HashMap<>();
    public static final HashMap<RegistryKey<ItemGroup>, ArrayList<Supplier<Item>>> CREATIVE_TAB_MAPPINGS = new HashMap<>();

    // Blocks
    public static final Supplier<Block> BLOCK_SOLID_BLEACH = Reference.register(Reference.BLOCKS, "solid_bleach", BlockSolidBleach::new);

    // Items
    public static final Supplier<Item> ITEM_EMPTY_BLEACH_BOTTLE = registerItem("empty_bleach_bottle", () -> new Item(new Item.Settings().maxCount(1)), ItemGroups.FOOD_AND_DRINK);
    public static final Supplier<Item> ITEM_BLEACH_BOTTLE = registerItem("bleach_bottle", () -> new ItemHarmfulDrink(() -> ITEM_EMPTY_BLEACH_BOTTLE.get().getDefaultStack(), DAMAGE_TYPE_BLEACH), ItemGroups.FOOD_AND_DRINK);
    public static final Supplier<Item> ITEM_EMPTY_WINDEX_BOTTLE = registerItem("empty_windex_bottle", () -> new Item(new Item.Settings().maxCount(1)), ItemGroups.FOOD_AND_DRINK);
    public static final Supplier<Item> ITEM_WINDEX_BOTTLE = registerItem("windex_bottle", () -> new ItemHarmfulDrink(() -> ITEM_EMPTY_WINDEX_BOTTLE.get().getDefaultStack(), DAMAGE_TYPE_WINDEX), ItemGroups.FOOD_AND_DRINK);
    public static final Supplier<Item> ITEM_SOLID_BLEACH = registerItem("solid_bleach", () -> new BlockItem(BLOCK_SOLID_BLEACH.get(), new Item.Settings()), ItemGroups.REDSTONE);

    // Utility Methods
    public static <T> Supplier<T> register(HashMap<Identifier, T> registry, String id, Supplier<T> supplier) {
        T object = supplier.get();
        registry.put(Identifier.of(MODID, id), object);
        return () -> object;
    }

    public static Supplier<Item> registerItem(String name, Supplier<Item> itemSupplier, RegistryKey<ItemGroup> creativeModeTab) {
        Supplier<Item> itemRegistryObject = Reference.register(Reference.ITEMS, name, itemSupplier);
        if(creativeModeTab != null) registerCreativeTabMapping(creativeModeTab, itemRegistryObject);
        return itemRegistryObject;
    }

    public static void registerCreativeTabMapping(RegistryKey<ItemGroup> creativeModeTab, Supplier<Item> itemRegistryObject) {
        ArrayList<Supplier<Item>> itemsInTab = Reference.CREATIVE_TAB_MAPPINGS.getOrDefault(creativeModeTab, new ArrayList<>());
        itemsInTab.add(itemRegistryObject);
        Reference.CREATIVE_TAB_MAPPINGS.put(creativeModeTab, itemsInTab);
    }

}
