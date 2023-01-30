package com.jdawg3636.bleachmod.mixin;

import com.jdawg3636.bleachmod.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {

    @Inject(method = "isBlockSticky", at = @At("HEAD"), cancellable = true)
    private static void bleachmod$conditionalOverrideIsBlockSticky(BlockState state, CallbackInfoReturnable<Boolean> callback) {
        if(state.isOf(Reference.BLOCK_SOLID_BLEACH.get())) {
            callback.setReturnValue(true);
        }
    }

}
