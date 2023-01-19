package io.github.h2sxxa.gensokyom.items.advance;

import io.github.h2sxxa.gensokyom.items.CardBase;
import io.github.h2sxxa.gensokyom.subentity.GSKMSubenetites;
import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibForms;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CustomCard extends CardBase {
    SubEntityType subentity;
    public CustomCard(String name, CreativeTabs tab, SubEntityType cdsubEntityType) {
        super(name, tab);
        this.subentity=cdsubEntityType;
    }

    @Override
    public void onCardUse(World worldIn, EntityPlayer player, EnumHand handIn) {
        super.onCardUse(worldIn, player, handIn);
        DanmakuTemplate.Builder temp = DanmakuTemplate.builder()
                .setUser(player)
                .setWorld(worldIn)
                .setSource(player)
                .setMovementData(1D)
                .setShot(ShotData.DefaultShotData()
                        .setForm(LibForms.TALISMAN)
                        .setDamage(2f)
                        .setSubEntity(GSKMSubenetites.EXPLOSION_SUBENTITY)
                );
        List<DanmakuState> stateList = new ArrayList<>();
        stateList.add(temp.build().asEntity());
        DanmakuCore.spawnDanmaku(stateList);
    }
}
