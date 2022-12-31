package com.jdawg3636.bleachmod;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class ItemHarmfulDrink extends Item {

    public Supplier<ItemStack> emptyBottleSupplier;
    public DamageSource damageSource;

    public ItemHarmfulDrink(Supplier<ItemStack> emptyBottleSupplier, DamageSource damageSource) {
        super(new Item.Properties().stacksTo(1).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).alwaysEat().build()));
        this.emptyBottleSupplier = emptyBottleSupplier;
        this.damageSource = damageSource;
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
            entityPlayer.getInventory().add(this.emptyBottleSupplier.get());
            // Inflict Damage
            if (!worldIn.isClientSide()) entityPlayer.hurt(this.damageSource, 600.0F);
        }

        // Return Empty ItemStack
        return Items.AIR.getDefaultInstance();

    }

}
