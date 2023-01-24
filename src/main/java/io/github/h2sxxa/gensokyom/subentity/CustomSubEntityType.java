package io.github.h2sxxa.gensokyom.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;

import javax.annotation.Nullable;

public class CustomSubEntityType extends SubEntityType {

    public CustomSubEntityType build(SubEntity subentity) {
        return new CustomSubEntityType(){
            @Override
            public SubEntity instantiate() {
                return subentity;
            }
        };
    }

    @Override
    public SubEntity instantiate() {
        return new CustomSubEntity();
    }

    class CustomSubEntity<T> extends SubEntityDefault{
        Runnable ticklba;
        Runnable iblba;
        Runnable ielba;
        Runnable iplba;
        Runnable atklba;
        T tickcdn;
        T ibcdn;
        T iecdn;
        T ipcdn;
        T atkcdn;
        public CustomSubEntity withTick(@Nullable T cond, Runnable lambda){
            this.tickcdn=cond;
            this.ticklba=lambda;
            return this;
        }
        public CustomSubEntity withImpactBlock(@Nullable T cond, Runnable lambda){
            this.ibcdn=cond;
            this.iblba=lambda;
            return this;
        }
        public CustomSubEntity withImpactEntity(@Nullable T cond, Runnable lambda){
            this.iecdn=cond;
            this.ielba=lambda;
            return this;
        }
        public CustomSubEntity withImpact(@Nullable T cond, Runnable lambda){
            this.ipcdn=cond;
            this.iplba=lambda;
            return this;
        }

        public CustomSubEntity withAttackEntity(@Nullable T cond, Runnable lambda){
            this.atkcdn=cond;
            this.atklba=lambda;
            return this;
        }
        @Override
        public DanmakuUpdate subEntityTick(DanmakuState danmaku) {
            return (tickcdn != null) ? super.subEntityTick(danmaku).addCallbackIf((Boolean) tickcdn,ticklba) : super.subEntityTick(danmaku).addCallback(ticklba);
        }

        @Override
        public DanmakuUpdate impactBlock(DanmakuState danmaku, RayTraceResult raytrace) {
            return (ibcdn != null) ? super.impactBlock(danmaku,raytrace).addCallbackIf((Boolean) ibcdn,iblba) : super.impactBlock(danmaku,raytrace).addCallback(iblba);
        }

        @Override
        public DanmakuUpdate impactEntity(DanmakuState danmaku, RayTraceResult raytrace) {
            return (iecdn != null) ? super.impactEntity(danmaku,raytrace).addCallbackIf((Boolean) iecdn,ielba) : super.impactEntity(danmaku,raytrace).addCallback(ielba);
        }

        @Override
        public DanmakuUpdate impact(DanmakuState danmaku, RayTraceResult raytrace) {
            return (ipcdn != null) ? super.impact(danmaku,raytrace).addCallbackIf((Boolean) ipcdn,iplba) : super.impact(danmaku,raytrace).addCallback(iplba);
        }

        @Override
        public DanmakuUpdate attackEntity(DanmakuState danmaku, Entity entity) {
            return (atkcdn != null) ? super.attackEntity(danmaku,entity).addCallbackIf((Boolean) atkcdn,atklba) : super.attackEntity(danmaku,entity).addCallback(atklba);
        }
    }
}
