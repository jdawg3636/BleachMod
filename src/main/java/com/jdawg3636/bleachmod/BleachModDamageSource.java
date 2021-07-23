package com.jdawg3636.bleachmod;

import net.minecraft.world.damagesource.DamageSource;

public class BleachModDamageSource extends DamageSource {

    public BleachModDamageSource(String damageType) {
        super(damageType);
        bypassArmor();
    }

}
