package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemBleachBottle extends Item {

    public ItemBleachBottle() {
        super(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING).food((new Food.Builder()).nutrition(0).saturationMod(0.0F).alwaysEat().build()));
        setRegistryName(Reference.MODID, "bleach_bottle");
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.finishUsingItem(stack, worldIn, entityLiving);

        if (entityLiving instanceof PlayerEntity) {
            // Cast to Player
            PlayerEntity entityplayer = (PlayerEntity)entityLiving;
            // Give Empty Bottle
            entityplayer.inventory.add(new ItemStack(Reference.modItems[0]));
            // Inflict Damage
            if (!worldIn.isClientSide) entityLiving.hurt(Reference.bleachDamage, 600.0F);
        }

        // Return Empty ItemStack
        return new ItemStack(Items.AIR);

    }

}
