package io.github.h2sxxa.gensokyom.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibForms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void createDan(EntityLivingBase entityLivingBase, World world){
        DanmakuTemplate.Builder temp = DanmakuTemplate.builder()
                .setUser(entityLivingBase)
                .setWorld(world)
                .setSource(entityLivingBase)
                .setMovementData(0.1D)
                .setShot(ShotData.DefaultShotData().setForm(LibForms.STAR));
        List<DanmakuState> stateList = new ArrayList<DanmakuState>();
        stateList.add(temp.build().asEntity());
        DanmakuCore.spawnDanmaku(stateList);
    }
}
