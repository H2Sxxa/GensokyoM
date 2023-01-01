package io.github.h2sxxa.gensokyom.init;

import io.github.h2sxxa.gensokyom.items.ItemBase;
import io.github.h2sxxa.gensokyom.items.advance.TestItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItem {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item TESTDAN = new TestItem("testdan", CreativeTabs.MISC);

}
