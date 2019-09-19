package com.jdawg3636.bleachmod.core;

import com.jdawg3636.bleachmod.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

import java.util.HashMap;

public class Reference {

    // Damage Sources
    public static DamageSource bleachDamage = new BleachModDamageSource("bleachDamage");
    public static DamageSource solidBleachDamage = new BleachModDamageSource("solidBleachDamage");
    public static DamageSource windexDamage = new BleachModDamageSource("windexDamage");

    // Items
    public static Item[] modItems = new Item[] {new ItemEmptyBleachBottle(), new ItemBleachBottle(), new ItemEmptyWindexBottle(), new ItemWindexBottle()};
    public static Block[] modBlocks = new Block[] {new BlockSolidBleach()};

}
