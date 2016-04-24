package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class CrystalInfusedStone extends OreInfusedStone
{
    protected CrystalInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("CrystalInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}