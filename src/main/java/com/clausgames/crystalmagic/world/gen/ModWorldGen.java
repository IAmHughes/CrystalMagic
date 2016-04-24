package com.clausgames.crystalmagic.world.gen;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModWorldGen
{
    public static void init()
    {
        GameRegistry.registerWorldGenerator(new BlockCrystalOreGen() , 0);
    }
}