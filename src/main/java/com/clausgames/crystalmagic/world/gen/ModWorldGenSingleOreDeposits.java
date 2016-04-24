package com.clausgames.crystalmagic.world.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class ModWorldGenSingleOreDeposits extends WorldGenerator //Generates BlockCrystalOre
{
    private Block block;
    private int blockmeta;
    private Block target;

    public ModWorldGenSingleOreDeposits(Block block, int meta, Block target) {
        this.block = block;
        this.blockmeta = meta;
        this.target = target;
    }

    public ModWorldGenSingleOreDeposits(Block block, Block target) {
        this(block, 0, target);
    }

    public ModWorldGenSingleOreDeposits(Block block) {
        this(block, Blocks.stone);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, this.target))
            world.setBlock(x, y, z, this.block, this.blockmeta, 2);
        return true;
    }
}