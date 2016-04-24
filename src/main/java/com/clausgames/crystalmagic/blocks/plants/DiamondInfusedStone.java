package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class DiamondInfusedStone extends OreInfusedStone
{
    protected DiamondInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("DiamondInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}