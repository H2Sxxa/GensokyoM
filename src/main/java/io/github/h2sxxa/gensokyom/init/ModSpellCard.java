package io.github.h2sxxa.gensokyom.init;

import io.github.h2sxxa.gensokyom.items.SpellCardBase;
import io.github.h2sxxa.gensokyom.spallcardentity.CustomSCE;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ModSpellCard {
    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();

    public static final Spellcard T_CARD = new SpellCardBase("t_card", CustomSCE.class, TouhouCharacter.REIMU_HAKUREI);



}
