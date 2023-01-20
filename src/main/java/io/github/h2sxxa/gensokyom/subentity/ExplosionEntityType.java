package io.github.h2sxxa.gensokyom.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.minecraft.util.math.RayTraceResult;


public class ExplosionEntityType extends SubEntityType {
    public ExplosionEntityType(){
        super("EXPLOSION_SUBENTITY");
    }
    @Override
    public SubEntity instantiate() {
        return new ExplosionEntity();
    }

    static class ExplosionEntity extends SubEntityDefault {
        @Override
        public DanmakuUpdate impactEntity(DanmakuState danmaku, RayTraceResult raytrace) {
            return super.impactEntity(danmaku, raytrace).addCallbackIf(!danmaku.world().isRemote, () -> danmaku.world().newExplosion(
                    raytrace.entityHit,
                    raytrace.entityHit.posX,
                    raytrace.entityHit.posY,
                    raytrace.entityHit.posZ,
                    2,
                    true,
                    true)
            );
        }

    }
}
