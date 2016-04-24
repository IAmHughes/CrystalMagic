package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class LapisInfusedStone extends OreInfusedStone
{
    protected LapisInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("LapisInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}