package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockSolidBleach extends Block {

    public BlockSolidBleach() {
        super(Block.Properties.create(Material.CAKE).hardnessAndResistance(1.0F));
        setRegistryName(Reference.MODID, "solid_bleach");
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) player.attackEntityFrom(Reference.solidBleachDamage, 600.0F);
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isRemote) player.attackEntityFrom(Reference.solidBleachDamage, 600.0F);
        super.onBlockHarvested(worldIn, pos, state, player);
    }

}
