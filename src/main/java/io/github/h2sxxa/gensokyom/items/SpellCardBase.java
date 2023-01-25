package io.github.h2sxxa.gensokyom.items;

import io.github.h2sxxa.gensokyom.spallcardentity.CustomSCE;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;


public class SpellCardBase extends Spellcard {
    public SpellCardBase (){
        super("cus_spc");
    }
    @Override
    public SpellcardEntity instantiate(EntitySpellcard entitySpellcard, Option<EntityLivingBase> target) {
        return new CustomSCE(this,entitySpellcard,target);
    }

    @Override
    public int level() {
        return 1;
    }

    @Override
    public int removeTime() {
        return 50;
    }

    @Override
    public int endTime() {
        return 50;
    }

    @Override
    public TouhouCharacter touhouUser() {
        return TouhouCharacter.REIMU_HAKUREI;
    }
}
