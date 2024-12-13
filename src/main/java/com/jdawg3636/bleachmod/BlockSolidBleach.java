package com.jdawg3636.bleachmod;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

public class BlockSolidBleach extends SlimeBlock {

    public BlockSolidBleach(BlockBehaviour.Properties properties) {
        super(properties.mapColor(MapColor.GRASS).friction(0.8F).sound(SoundType.SLIME_BLOCK).noOcclusion());
    }

    private void doSolidBleachDamage(Level level, Player player) {
        if (!level.isClientSide()) {
            player.hurt(Reference.getDamageSource(level, Reference.DAMAGE_TYPE_SOLID_BLEACH), 600.0F);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult hitResult) {
        doSolidBleachDamage(level, player);
        return super.useWithoutItem(blockState, level, blockPos, player, hitResult);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        doSolidBleachDamage(level, player);
        return super.useItemOn(itemStack, blockState, level, blockPos, player, hand, hitResult);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide()) player.hurt(Reference.getDamageSource(level, Reference.DAMAGE_TYPE_SOLID_BLEACH), 600.0F);
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public boolean isSlimeBlock(BlockState state) {
        return true;
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }

}
