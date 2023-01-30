package com.jdawg3636.bleachmod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class ItemHarmfulDrink extends Item {

    public Supplier<ItemStack> emptyBottleSupplier;
    public DamageSource damageSource;

    public ItemHarmfulDrink(Supplier<ItemStack> emptyBottleSupplier, DamageSource damageSource) {
        super(new Item.Settings().maxCount(1).food((new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).alwaysEdible().build()));
        this.emptyBottleSupplier = emptyBottleSupplier;
        this.damageSource = damageSource;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World worldIn, LivingEntity entityLiving) {

        // Call super (handles statistics etc.)
        super.finishUsing(stack, worldIn, entityLiving);

        if (entityLiving instanceof PlayerEntity entityPlayer) {
            // Give Empty Bottle
            entityPlayer.getInventory().insertStack(this.emptyBottleSupplier.get());
            // Inflict Damage
            if (!worldIn.isClient()) entityPlayer.damage(this.damageSource, 600.0F);
        }

        // Return Empty ItemStack
        return Items.AIR.getDefaultStack();

    }

}