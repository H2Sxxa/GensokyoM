package io.github.h2sxxa.gensokyom.items.advance;

import io.github.h2sxxa.gensokyom.items.ItemBase;
import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibForms;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Gohei extends ItemBase {
    public Gohei(String name, CreativeTabs tab) {
        super(name, tab);
    }

    public void onShot(World worldIn, EntityPlayer player) {
        DanmakuTemplate.Builder temp = DanmakuTemplate.builder()
                .setUser(player)
                .setWorld(worldIn)
                .setSource(player)
                .setMovementData(1D)
                .setShot(ShotData.DefaultShotData()
                        .setForm(LibForms.FIRE)
                        .setDamage(2f)
                );
        List<DanmakuState> stateList = new ArrayList<>();
        stateList.add(temp.build().asEntity());
        DanmakuCore.spawnDanmaku(stateList);
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
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){

        }
        onShot(worldIn,player);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }


}
