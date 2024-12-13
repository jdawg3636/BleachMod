package com.jdawg3636.bleachmod;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class ItemHarmfulDrink extends Item {

    public Supplier<ItemStack> emptyBottleSupplier;
    public ResourceKey<DamageType> damageSource;

    public static Item.Properties getHarmfulDrinkItemProperties() {
        return new Item.Properties().stacksTo(1).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0.0F).alwaysEdible().build());
    }

    public ItemHarmfulDrink(Item.Properties properties, Supplier<ItemStack> emptyBottleSupplier, ResourceKey<DamageType> damageSource) {
        super(properties);
        this.emptyBottleSupplier = emptyBottleSupplier;
        this.damageSource = damageSource;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.finishUsingItem(stack, level, entityLiving);

        if (entityLiving instanceof Player entityPlayer) {
            // Give Empty Bottle
            entityPlayer.getInventory().add(this.emptyBottleSupplier.get());
            // Inflict Damage
            if (!level.isClientSide()) entityPlayer.hurt(Reference.getDamageSource(level, this.damageSource), 600.0F);
        }

        // Return Empty ItemStack
        return Items.AIR.getDefaultInstance();

    }

}
