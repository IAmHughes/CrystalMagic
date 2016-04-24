package com.clausgames.crystalmagic.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes
{
    public static BiomeGenBase biomeCrystalMagic;

    public static void init()
    {
        biomeCrystalMagic = new BiomeGenCrystalMagic(137).setBiomeName("CrystalMagic").setTemperatureRainfall(1.2F, 0.9F);
        BiomeDictionary.registerBiomeType(biomeCrystalMagic, BiomeDictionary.Type.FOREST);
        BiomeManager.addSpawnBiome(biomeCrystalMagic);
    }
}
