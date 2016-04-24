package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class CoalInfusedStone extends OreInfusedStone
{
    protected CoalInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("CoalInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}