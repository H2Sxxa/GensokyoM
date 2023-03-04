package io.github.h2sxxa.gensokyom.items;

import io.github.h2sxxa.gensokyom.Main;
import io.github.h2sxxa.gensokyom.init.ModSpellCard;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.minecraft.entity.EntityLivingBase;

import scala.Option;

import java.lang.reflect.Constructor;


public class SpellCardBase<T> extends Spellcard {
    String name;
    TouhouCharacter character;
    Class<T> spellcard;
    public SpellCardBase (String name,Class<T> spellcard,TouhouCharacter character){
        super(name);
        this.name=name;
        this.character=character;
        this.spellcard=spellcard;

        ModSpellCard.SPELL_CARDS.add(this);
    }
    @Override
    public SpellcardEntity instantiate(EntitySpellcard entitySpellcard, Option<EntityLivingBase> target) {
        //return spellcard(this,entitySpellcard,target);
        try {
            Constructor<T> constructor = this.spellcard.getDeclaredConstructor(Spellcard.class,EntitySpellcard.class,Option.class);
            constructor.setAccessible(true);
            return (SpellcardEntity) constructor.newInstance(this,entitySpellcard,target);
        } catch (Exception e) {
            Main.logger.error("Reflect Failed");
            return new SpellcardEntity(this,entitySpellcard,target) {
                @Override
                public void onSpellcardUpdate() {}
            };
        }
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
        return this.character;
    }
}
