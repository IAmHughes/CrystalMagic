package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.CrystalMagic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemCrystalCodex extends ItemCrystalMagic
{
    public ItemCrystalCodex(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick (ItemStack item, World world, EntityPlayer player)
    {
        if(world.isRemote)
        {
            // DEBUG
            System.out.println("ItemCrystalCodex onItemRightClick");

            player.openGui(CrystalMagic.instance, CrystalMagic.GUI_ENUM.CRYSTALCODEX.ordinal(), world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return super.onItemRightClick(item, world, player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add(EnumChatFormatting.LIGHT_PURPLE + "What magical teachings does this hold?");
    }
}