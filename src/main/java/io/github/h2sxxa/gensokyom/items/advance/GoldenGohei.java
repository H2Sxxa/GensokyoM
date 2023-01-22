package io.github.h2sxxa.gensokyom.items.advance;

import io.github.h2sxxa.gensokyom.items.ItemBase;
import io.github.h2sxxa.gensokyom.items.WeaponBase;
import net.minecraft.creativetab.CreativeTabs;

public class GoldenGohei extends WeaponBase {
    public GoldenGohei(String name, CreativeTabs tab) {
        super(name, tab,ToolMaterial.WOOD);
        setMaxDamage(1);
        setMaxStackSize(1);
    }

    @Override
    public float getAttackDamage() {
        return 0f;
    }
}
