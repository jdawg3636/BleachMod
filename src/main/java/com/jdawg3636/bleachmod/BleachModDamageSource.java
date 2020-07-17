package com.jdawg3636.bleachmod;

import net.minecraft.util.DamageSource;

public class BleachModDamageSource extends DamageSource {

    public BleachModDamageSource(String damageType) {
        super(damageType);
        setDamageBypassesArmor();
    }

}
