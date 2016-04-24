package com.clausgames.crystalmagic.creativetab;

import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.fragments.ModFragments;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCrystalMagic
{
    public static final CreativeTabs tabCrystalMagic = new CreativeTabs(LibMisc.MODID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModFragments.itemCrystalFragment;
        }
    };
}