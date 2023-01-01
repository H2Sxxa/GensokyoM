package io.github.h2sxxa.gensokyom.items;


import io.github.h2sxxa.gensokyom.Main;
import io.github.h2sxxa.gensokyom.init.ModItem;
import io.github.h2sxxa.gensokyom.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name,CreativeTabs tab){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItem.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}