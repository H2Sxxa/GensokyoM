package io.github.h2sxxa.gensokyom.init;

import io.github.h2sxxa.gensokyom.creativetab.ModTabs;
import io.github.h2sxxa.gensokyom.items.cards.CustomCard;
import io.github.h2sxxa.gensokyom.items.weapon.Gohei;
import io.github.h2sxxa.gensokyom.items.weapon.GoldenGohei;
import io.github.h2sxxa.gensokyom.items.weapon.GossipStove;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibSubEntities;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ModItem {
    public static final List<Item> ITEMS = new ArrayList<>();
    //Cards
    public static final Item EXPLOSION_CARD = new CustomCard("explosion_card", ModTabs.CARD_TAB) {
        @Override
        public SubEntityType getSubentity() {
            return LibSubEntities.EXPLOSION;
        }

        @Override
        public DanmakuTemplate.Builder reShape(DanmakuTemplate.Builder builder) {
            return builder.setShot(builder.shot().addSubEntityProperty("explosion_strength", 1d));
        }
    };
    //Items
    public static final Item GO_HEI = new Gohei("go_hei",ModTabs.WEAPON_TAB);
    public static final Item GOLDEN_GO_HEI = new GoldenGohei("golden_go_hei",ModTabs.WEAPON_TAB);
    public static final Item GOSSIP_STOVE = new GossipStove("gossip_stove",ModTabs.WEAPON_TAB);
}
