package com.clausgames.crystalmagic.tile;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityBlockCrystalOre.class, "Crystal Ore");
    }
}
