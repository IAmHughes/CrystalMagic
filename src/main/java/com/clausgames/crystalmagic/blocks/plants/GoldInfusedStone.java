package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class GoldInfusedStone extends OreInfusedStone
{
    protected GoldInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("GoldInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}