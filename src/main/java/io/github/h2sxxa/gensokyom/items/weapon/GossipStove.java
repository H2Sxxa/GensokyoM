package io.github.h2sxxa.gensokyom.items.weapon;

import io.github.h2sxxa.gensokyom.items.CanShotBase;
import io.github.h2sxxa.gensokyom.utils.DanmakuUtils;
import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.lib.LibColor;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GossipStove extends CanShotBase {
    public GossipStove(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void onShotUse(World worldIn, EntityPlayer player, EnumHand handIn) {
        super.onShotUse(worldIn, player, handIn);
        DanmakuTemplate.Builder temp = DanmakuTemplate.builder()
                .setUser(player)
                .setWorld(worldIn)
                .setSource(player)
                .setPos(DanmakuUtils.genLaserVec(player))

                .setShot(LibShotData.SHOT_LASER
                        .setCoreColor(LibColor.COLOR_VANILLA_WHITE)
                        .setEdgeColor(LibColor.COLOR_SATURATED_YELLOW)
                        .setDamage(2f)
                        .scaleSize(10f)
                );

        DanmakuCore.spawnDanmaku(Collections.singletonList(temp.build().asEntity()));
    }
}
