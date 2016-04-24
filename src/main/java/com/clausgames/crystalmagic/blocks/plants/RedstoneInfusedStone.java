package com.clausgames.crystalmagic.blocks.plants;

import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.block.material.Material;

public class RedstoneInfusedStone extends OreInfusedStone
{
    protected RedstoneInfusedStone(Material material)
    {
        super(Material.rock);
        this.setBlockName("RedstoneInfusedStone");
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
