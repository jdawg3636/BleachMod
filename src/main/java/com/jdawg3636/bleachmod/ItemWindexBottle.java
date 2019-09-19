package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Main;
import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemWindexBottle extends ItemFood {

    public ItemWindexBottle() {

        super(0, 0.0F, false);

        setUnlocalizedName(Reference.ModItems.WINDEXBOTTLE.getUnlocalizedName());
        setRegistryName(Reference.ModItems.WINDEXBOTTLE.getRegistryName());

        setMaxStackSize(1);
        setAlwaysEdible();

    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

        // Shrink Stack
        stack.shrink(1);

        // Check if Player (Should Always be True)
        if (entityLiving instanceof EntityPlayer) {
            // Cast to Player
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            // Update Stats
            entityplayer.getFoodStats().addStats(this, stack);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            // Play Sound
            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            // Inflict Damage
            if (!worldIn.isRemote) entityplayer.attackEntityFrom(Main.windexDamage, 600.0F);
        }

        // Return ItemStack of Empty Bottle
        return new ItemStack(Main.modItems[2]);

    }

}
