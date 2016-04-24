package com.clausgames.crystalmagic.items.fragments;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class OreCrystalFragment extends ItemSeeds
{
    public OreCrystalFragment(Block blockPlant, Block blockSoil)
    {
        super(blockPlant, blockSoil);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
