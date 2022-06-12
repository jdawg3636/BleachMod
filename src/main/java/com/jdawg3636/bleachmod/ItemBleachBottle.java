package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemBleachBottle extends Item {

    public ItemBleachBottle() {
        super(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_BREWING).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).alwaysEat().build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.finishUsingItem(stack, worldIn, entityLiving);

        if (entityLiving instanceof Player entityPlayer) {
            // Give Empty Bottle
            entityPlayer.getInventory().add(Reference.ITEM_EMPTY_BLEACH_BOTTLE.get().getDefaultInstance());
            // Inflict Damage
            if (!worldIn.isClientSide()) entityPlayer.hurt(Reference.DAMAGE_SOURCE_BLEACH, 600.0F);
        }

        // Return Empty ItemStack
        return Items.AIR.getDefaultInstance();

    }

}
