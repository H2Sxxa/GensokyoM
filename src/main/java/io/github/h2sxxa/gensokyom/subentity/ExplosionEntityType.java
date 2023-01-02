package io.github.h2sxxa.gensokyom.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;


public class ExplosionEntityType extends SubEntityType {
    public ExplosionEntityType(){
        super("fire_bullet");
    }
    @Override
    public SubEntity instantiate() {
        return new ExplosionEntity();
    }

    class ExplosionEntity extends SubEntityDefault {
        @Override
        public DanmakuUpdate subEntityTick(DanmakuState danmaku) {
            return super.subEntityTick(danmaku).addCallbackIf(!danmaku.world().isRemote, () -> {
                AxisAlignedBB bb = new AxisAlignedBB(danmaku.pos().toBlockPos()).grow(danmaku.shot().sizeX(), danmaku.shot().sizeY(), danmaku.shot().sizeZ());
                danmaku.world().getEntitiesWithinAABB(EntityLivingBase.class, bb).forEach(e -> e.setFire(5));
            });
        }
    }
}

