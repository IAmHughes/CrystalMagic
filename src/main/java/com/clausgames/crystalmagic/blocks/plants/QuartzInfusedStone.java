package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class QuartzInfusedStone extends OreInfusedStone
{
    protected QuartzInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("QuartzInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}