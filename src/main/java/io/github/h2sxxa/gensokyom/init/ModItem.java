package io.github.h2sxxa.gensokyom.init;

import io.github.h2sxxa.gensokyom.items.advance.CustomCard;
import io.github.h2sxxa.gensokyom.subentity.GSKMSubenetites;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItem {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item EXPLOSION_CARD = new CustomCard("explosion_card", CreativeTabs.MISC, GSKMSubenetites.EXPLOSION_SUBENTITY);

}
