package com.clausgames.crystalmagic.blocks;

import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.lib.LibNames;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModBlocks
{
	// Declaration of Blocks
	public static Block blockCrystalOre = new BlockCrystalOre(Material.rock);
	public static BlockGoldenBars blockGoldenBars = new BlockGoldenBars();
	public static BlockCrystalMagic blockGoldenCloud = new BlockGoldenCloud(Material.cloth);

	//Declaration of Machine Blocks
	public static BlockCrystalMagic blockSocketBench = new BlockSocketBench(Material.wood);

	public static void init()
	{
		//Blocks
		GameRegistry.registerBlock(blockCrystalOre, LibNames.Blocks.CRYSTAL_ORE);
		GameRegistry.registerBlock(blockGoldenBars, LibNames.Blocks.GOLDEN_BARS);
		GameRegistry.registerBlock(blockGoldenCloud, LibNames.Blocks.GOLDEN_CLOUD);

		//Registration of Machine Blocks
		GameRegistry.registerBlock(blockSocketBench, LibNames.Blocks.SOCKET_BENCH);
	}
}