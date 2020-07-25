package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemWindexBottle extends ItemFood {

    public ItemWindexBottle() {
        super(0, 0.0F, false, new Item.Properties().maxStackSize(1).group(ItemGroup.BREWING));
        setRegistryName(Reference.MODID, "windex_bottle");
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

        if (entityLiving instanceof EntityPlayer) {
            // Cast to Player
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            // Give Empty Bottle
            entityplayer.inventory.addItemStackToInventory(new ItemStack(Reference.modItems[2]));
            // Inflict Damage
            if (!worldIn.isRemote) entityLiving.attackEntityFrom(Reference.bleachDamage, 600.0F);
        }

        // Return Empty ItemStack
        return new ItemStack(Items.AIR);

    }

}
