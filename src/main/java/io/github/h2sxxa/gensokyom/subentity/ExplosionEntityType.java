package io.github.h2sxxa.gensokyom.subentity;

import io.github.h2sxxa.gensokyom.Main;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;


public class ExplosionEntityType extends SubEntityType {
    public ExplosionEntityType(){
        super("EXPLOSION_SUBENTITY");
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
                danmaku.world().getEntitiesWithinAABB(EntityLivingBase.class, bb).forEach(e -> {
                    Main.logger.info(danmaku.source());
                    Main.logger.info(e);
                    if (e != danmaku.source().get()){
                        e.world.newExplosion(e, e.posX, e.posY, e.posZ, 2, true, true);
                    }
                });
            });
        }
    }
}
