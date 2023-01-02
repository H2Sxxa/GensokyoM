package io.github.h2sxxa.gensokyom.events;


import io.github.h2sxxa.gensokyom.init.ModItem;
import io.github.h2sxxa.gensokyom.interfaces.IHasModel;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;


@EventBusSubscriber
public class ModReg {

    public static void preInitRegistries(){
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItem.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event){
        event.getRegistry().registerAll();
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : ModItem.ITEMS){
            if(item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }
    }
}