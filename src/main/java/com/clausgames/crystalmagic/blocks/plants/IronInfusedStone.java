package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class IronInfusedStone extends OreInfusedStone
{
    protected IronInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("IronInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}