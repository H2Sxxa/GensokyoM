package io.github.h2sxxa.gensokyom.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BaseTab extends CreativeTabs {
    ItemStack Icon;
    public <T> BaseTab(String label,T icon) {
        super(CreativeTabs.getNextID(), label);
        this.Icon=(icon instanceof ItemStack ? (ItemStack) icon :new ItemStack((Item) icon));
    }

    @Override
    public ItemStack getTabIconItem() {
        return this.Icon;
    }
}
