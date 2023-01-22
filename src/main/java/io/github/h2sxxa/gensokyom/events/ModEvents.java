package io.github.h2sxxa.gensokyom.events;

import io.github.h2sxxa.gensokyom.Main;
import io.github.h2sxxa.gensokyom.items.weapon.GoldenGohei;
import io.github.h2sxxa.gensokyom.utils.TextUtils;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEvents {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onToolTips(ItemTooltipEvent event){
        String keyname = event.getItemStack().getItem().getUnlocalizedName().concat(".gensokyom.tip");
        if (I18n.hasKey(keyname)){
            event.getToolTip().addAll(1, Arrays.asList(I18n.format(keyname).split("/n")));
        }
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void InfTipsFormat(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof GoldenGohei) {
            for (int x = 0; x < event.getToolTip().size(); x++) {
                if (event.getToolTip().get(x).contains(I18n.format("attribute.name.generic.attackDamage")) || event.getToolTip().get(x).contains(I18n.format("Attack Damage"))) {
                    event.getToolTip().set(x, TextFormatting.BLUE + "+" + TextUtils.makeFabulous(I18n.format("tip.myinf")) + " " + TextFormatting.BLUE + I18n.format("attribute.name.generic.attackDamage"));
                }
                if (event.getToolTip().get(x).contains(I18n.format("attribute.name.generic.attackSpeed")) || event.getToolTip().get(x).contains(I18n.format("Attack Speed"))) {
                    event.getToolTip().set(x, TextFormatting.BLUE + "+" + TextUtils.makeFabulous(I18n.format("tip.myinf")) + " " + TextFormatting.BLUE + I18n.format("attribute.name.generic.attackSpeed"));
                }
            }
        }
    }
}
