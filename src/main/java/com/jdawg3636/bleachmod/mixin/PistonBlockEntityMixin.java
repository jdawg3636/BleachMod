package com.jdawg3636.bleachmod.mixin;

import com.jdawg3636.bleachmod.Reference;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.PistonBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PistonBlockEntity.class)
public abstract class PistonBlockEntityMixin {

    @WrapOperation(
            // Caller Method (Mixin Target)
            method = "Lnet/minecraft/block/entity/PistonBlockEntity;pushEntities(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;FLnet/minecraft/block/entity/PistonBlockEntity;)V",
            // Callee Method (The one being wrapped)
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    )
    private static boolean bleachmod$wrapBlockStateIsOf(BlockState instance, Block blockParam, Operation<Boolean> original) {
        return original.call(instance, blockParam) || (blockParam == Blocks.SLIME_BLOCK && instance.getBlock() == Reference.BLOCK_SOLID_BLEACH.get());
    }

}
