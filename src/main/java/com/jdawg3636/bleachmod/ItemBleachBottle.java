package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemBleachBottle extends ItemFood {

    public ItemBleachBottle() {
        super(0, 0.0F, false, new Item.Properties().maxStackSize(1).group(ItemGroup.BREWING));
        setRegistryName(Reference.MODID, "bleach_bottle");
        setAlwaysEdible();
    }

    @Override
    public EnumAction getUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

        // Call super (handles statistics etc.)
        super.onItemUseFinish(stack, worldIn, entityLiving);

        // Inflict Damage
        if (entityLiving instanceof EntityPlayer) {
            if (!worldIn.isRemote) entityLiving.attackEntityFrom(Reference.bleachDamage, 600.0F);
        }

        // Return ItemStack of Empty Bottle
        return new ItemStack(Reference.modItems[0]);

    }

}
