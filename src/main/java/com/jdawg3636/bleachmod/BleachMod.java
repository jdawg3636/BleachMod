package com.jdawg3636.bleachmod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;

@Mod(Reference.MODID)
public class BleachMod {

    public BleachMod(IEventBus modEventBus, ModContainer modContainer) {
        Reference.BLOCKS.register(modEventBus);
        Reference.ITEMS.register(modEventBus);
        modEventBus.addListener(this::onBuildContentsCreativeModeTabEvent);
    }

    public void onBuildContentsCreativeModeTabEvent(BuildCreativeModeTabContentsEvent event) {
        Reference.CREATIVE_TAB_MAPPINGS.getOrDefault(event.getTabKey(), new ArrayList<>()).forEach(event::accept);
    }

}
