package io.github.h2sxxa.gensokyom.items;

import io.github.h2sxxa.gensokyom.Main;
import io.github.h2sxxa.gensokyom.init.ModItem;
import io.github.h2sxxa.gensokyom.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class WeaponBase extends ItemSword implements IHasModel {
    public WeaponBase(String name, CreativeTabs tab, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setMaxStackSize(1);

        ModItem.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
