package com.clausgames.crystalmagic.biome;

import com.clausgames.crystalmagic.blocks.plants.ModPlants;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenCrystalMagic extends BiomeGenBase
{
    public BiomeGenCrystalMagic(int id)
    {
        super(id);

        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 5, 2, 10));

        this.theBiomeDecorator.treesPerChunk = 5;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.bigMushroomsPerChunk = 2;

        this.topBlock = Blocks.grass;
        this.fillerBlock = ModPlants.coalInfusedStone;


    }
}
