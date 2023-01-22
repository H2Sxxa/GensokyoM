package io.github.h2sxxa.gensokyom.items.weapon;

import io.github.h2sxxa.gensokyom.items.WeaponBase;
import io.github.h2sxxa.gensokyom.utils.QuoteLib;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GoldenGohei extends WeaponBase {
    public GoldenGohei(String name, CreativeTabs tab) {
        super(name, tab, QuoteLib.UseLessMaterial);
        setMaxDamage(1);
        setMaxStackSize(1);
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }
}
