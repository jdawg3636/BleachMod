package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockSolidBleach extends SlimeBlock {

    public BlockSolidBleach() {
        super(Block.Properties.of(Material.CLAY, MaterialColor.GRASS).friction(0.8F).sound(SoundType.SLIME_BLOCK));
        setRegistryName(Reference.MODID, "solid_bleach");
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide()) player.hurt(Reference.solidBleachDamage, 600.0F);
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isClientSide()) player.hurt(Reference.solidBleachDamage, 600.0F);
        super.playerWillDestroy(worldIn, pos, state, player);
    }

    //@Override // Doesn't exist in 1.14 but does in 1.15 - leaving in without the annotation to allow for a single mod jar to function properly in both versions
    public boolean isSlimeBlock(BlockState state) {
        return true;
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }

}
