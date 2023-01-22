package io.github.h2sxxa.gensokyom.items.weapon;

import io.github.h2sxxa.gensokyom.items.CardBase;
import io.github.h2sxxa.gensokyom.items.WeaponBase;
import io.github.h2sxxa.gensokyom.utils.DanmakuUtils;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibForms;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Gohei extends WeaponBase {
    public Gohei(String name, CreativeTabs tab) {
        super(name, tab,ToolMaterial.DIAMOND);
        setMaxStackSize(1);
        setMaxDamage(3299);
    }

    public void onShot(World worldIn, EntityPlayer player) {
        if (player.getHeldItem(EnumHand.MAIN_HAND).getItem() == this){
            if (player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof CardBase){
                CardBase cb = (CardBase) player.getHeldItem(EnumHand.OFF_HAND).getItem();
                cb.onCardUse(worldIn,player,EnumHand.OFF_HAND);
            }
            else {
                DanmakuUtils.shotDanmaku(player,worldIn,LibForms.TALISMAN);
                player.getCooldownTracker().setCooldown(this,10);
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        onShot(worldIn,player);
        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn)
    {
        onShot(worldIn,player);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }


}
