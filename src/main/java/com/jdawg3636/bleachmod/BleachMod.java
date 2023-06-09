package com.jdawg3636.bleachmod;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;

@Mod(Reference.MODID)
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BleachMod {

    public BleachMod() {
        Reference.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Reference.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onBuildContentsCreativeModeTabEvent);
    }

    public void onBuildContentsCreativeModeTabEvent(BuildCreativeModeTabContentsEvent event) {
        Reference.CREATIVE_TAB_MAPPINGS.getOrDefault(event.getTabKey(), new ArrayList<>()).forEach(event::accept);
    }

}
