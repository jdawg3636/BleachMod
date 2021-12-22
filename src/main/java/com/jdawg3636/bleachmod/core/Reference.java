package com.jdawg3636.bleachmod.core;

import com.jdawg3636.bleachmod.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

public class Reference {

    // Mod Info
    public static final String MODID = "bleachmod";

    // Damage Sources
    public static DamageSource bleachDamage = new BleachModDamageSource("bleach_damage");
    public static DamageSource solidBleachDamage = new BleachModDamageSource("solid_bleach_damage");
    public static DamageSource windexDamage = new BleachModDamageSource("windex_damage");

    // Items
    public static Item[] modItems = new Item[] {new ItemEmptyBleachBottle(), new ItemBleachBottle(), new ItemEmptyWindexBottle(), new ItemWindexBottle()};
    public static Block[] modBlocks = new Block[] {new BlockSolidBleach()};

}
