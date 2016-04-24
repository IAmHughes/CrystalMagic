package com.clausgames.crystalmagic.blocks;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCrystalMagic extends Block
{
    public BlockCrystalMagic(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    public BlockCrystalMagic()
    {
        this(Material.rock);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }
}
