package com.clausgames.crystalmagic.items.sockets;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import net.minecraft.item.Item;

public class ItemSocket extends Item
{
    public ItemSocket()
    {
        super();
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    /*@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add(EnumChatFormatting.LIGHT_PURPLE + "I'm Empty");
    }*/
}