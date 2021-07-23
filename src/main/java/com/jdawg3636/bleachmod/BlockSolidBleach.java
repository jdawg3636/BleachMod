package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;

public class BlockSolidBleach extends Block {

    public BlockSolidBleach() {
        super(Block.Properties.of(Material.CAKE).strength(1.0F));
        setRegistryName(Reference.MODID, "solid_bleach");
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide()) player.hurt(Reference.solidBleachDamage, 600.0F);
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
        if (!worldIn.isClientSide()) player.hurt(Reference.solidBleachDamage, 600.0F);
        super.playerWillDestroy(worldIn, pos, state, player);
    }

}
