package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemWindexBottle extends Item {

    public ItemWindexBottle() {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.BREWING).food((new Food.Builder()).hunger(0).saturation(0.0F).setAlwaysEdible().build()));
        setRegistryName(Reference.MODID, "windex_bottle");
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.onItemUseFinish(stack, worldIn, entityLiving);

        // Inflict Damage
        if (entityLiving instanceof PlayerEntity) {
            if (!worldIn.isRemote) entityLiving.attackEntityFrom(Reference.windexDamage, 600.0F);
        }

        // Return ItemStack of Empty Bottle
        return new ItemStack(Reference.modItems[2]);

    }

}
