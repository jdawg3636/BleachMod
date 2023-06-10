package com.jdawg3636.bleachmod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.SlimeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSolidBleach extends SlimeBlock {

    public BlockSolidBleach() {
        super(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).slipperiness(0.8F).sounds(BlockSoundGroup.SLIME).nonOpaque());
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        if (!level.isClient()) player.damage(Reference.getDamageSource(level, Reference.DAMAGE_TYPE_SOLID_BLEACH), 600.0F);
        return super.onUse(state, level, pos, player, handIn, hit);
    }

    @Override
    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient()) player.damage(Reference.getDamageSource(level, Reference.DAMAGE_TYPE_SOLID_BLEACH), 600.0F);
        super.onBreak(level, pos, state, player);
    }

}
