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
        setRegistryName(Reference.MODID, "bleach_bottle");
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.finishUsingItem(stack, worldIn, entityLiving);

        if (entityLiving instanceof Player) {
            // Cast to Player
            Player entityplayer = (Player)entityLiving;
            // Give Empty Bottle
            entityplayer.getInventory().add(new ItemStack(Reference.modItems[0]));
            // Inflict Damage
            if (!worldIn.isClientSide()) entityLiving.hurt(Reference.bleachDamage, 600.0F);
        }

        // Return Empty ItemStack
        return new ItemStack(Items.AIR);

    }

}
