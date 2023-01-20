package io.github.h2sxxa.gensokyom.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Objects;

public class BaseTab extends CreativeTabs {
    String icon;
    public BaseTab(String label,String icon) {
        super(CreativeTabs.getNextID(), label);
        this.icon=icon;
        System.out.println(icon);
    }


    @SideOnly(Side.CLIENT)
    @Nonnull
    public ItemStack getTabIconItem() {
        return new ItemStack(Objects.requireNonNull(Item.getByNameOrId(this.icon)));
    }
}
