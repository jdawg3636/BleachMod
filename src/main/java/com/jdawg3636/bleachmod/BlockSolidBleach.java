package com.jdawg3636.bleachmod;

import com.jdawg3636.bleachmod.core.Main;

import com.jdawg3636.bleachmod.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSolidBleach extends Block {

    public BlockSolidBleach() {
        super(Material.CAKE);
        setUnlocalizedName(Reference.ModBlocks.SOLIDBLEACH.getUnlocalizedName());
        setRegistryName(Reference.ModBlocks.SOLIDBLEACH.getRegistryName());
        setHardness(1.0F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        if (!worldIn.isRemote && !playerIn.isCreative()) playerIn.attackEntityFrom(Main.solidBleachDamage, 600.0F);
        return true;
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (!world.isRemote && !player.isCreative()) player.attackEntityFrom(Main.solidBleachDamage, 600.0F);
        return super.removedByPlayer(state, world, pos, player, willHarvest);

    }

}
