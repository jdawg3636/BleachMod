package com.jdawg3636.bleachmod.core;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BleachMod {

    public BleachMod() {
        Reference.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Reference.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
            // Assign RenderType for Block of Solidified Bleach
            ItemBlockRenderTypes.setRenderLayer(Reference.BLOCK_SOLID_BLEACH.get(), RenderType.translucent())
        );
    }

}
