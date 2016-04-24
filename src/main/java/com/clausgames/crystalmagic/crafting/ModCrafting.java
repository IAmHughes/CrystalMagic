package com.clausgames.crystalmagic.crafting;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.blocks.plants.ModPlants;
import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.armor.ModArmor;
import com.clausgames.crystalmagic.items.fragments.ModFragments;
import com.clausgames.crystalmagic.items.sockets.ModSockets;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting
{
	public static void init()
	{
		// Insert Crafting/Smelting Recipes Here

		//Crystal Codex, Shapeless, Crystal Fragment + Book
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCrystalCodex), ModItems.itemRoughCrystalFragment, Items.book);
		//Crystal Tuning Fork, F = CrystalFragment, I = Iron Ingot
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCrystalTuningFork), "F F", " I ", " I ", 'F', ModFragments.itemCrystalFragment, 'I', Items.iron_ingot);

		//Golden Bars, G = Gold Ingot
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockGoldenBars, 16), "GGG", "GGG", 'G', Items.gold_ingot);

		//Sockets
		//Empty Socket, G = Gold Ingot, C = Crystal
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemEmptySocket, 2), "GCG", "C C", "GCG", 'G', Items.gold_ingot, 'C', ModItems.itemCrystal);
		//Lucky Socket, L = Lapis Block, C = Crystal, E = Empty Socket or O = LapisCrystalFragment
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemLuckySocket), "LCL", "CEC", "LCL", 'L', Blocks.lapis_block, 'C', ModItems.itemCrystal, 'E', ModSockets.itemEmptySocket);
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemLuckySocket), "OOO", "OEO", "OOO", 'O', ModFragments.itemLapisCrystalFragment, 'E', ModSockets.itemEmptySocket);
		//Speedy Socket, R = Redstone Block, C = Crystal, E = Empty Socket or O = RedstoneCrystalFragment
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemSpeedySocket), "RCR", "CEC", "RCR", 'R', Blocks.redstone_block, 'C', ModItems.itemCrystal, 'E', ModSockets.itemEmptySocket);
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemSpeedySocket), "OOO", "OEO", "OOO", 'O', ModFragments.itemRedstoneCrystalFragment, 'E', ModSockets.itemEmptySocket);
		//Fiery Socket, F = Fire Crystal, E = Empty Socket
		GameRegistry.addRecipe(new ItemStack(ModSockets.itemFierySocket), "FFF", "FEF", "FFF", 'F', ModItems.itemFireCrystal, 'E', ModSockets.itemEmptySocket);

		//OreInfusedStones, O = OreType, S = Stone, C = CrystalFragment.
		GameRegistry.addRecipe(new ItemStack(ModPlants.crystalInfusedStone), "OSO", "SCS", "OSO", 'O', ModItems.itemCrystal, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.coalInfusedStone), "OSO", "SCS", "OSO", 'O', Items.coal, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.redstoneInfusedStone), "OSO", "SCS", "OSO", 'O', Items.redstone, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.lapisInfusedStone), "OSO", "SCS", "OSO", 'O', new ItemStack(Items.dye, 1, 4), 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.quartzInfusedStone), "OSO", "SCS", "OSO", 'O', Items.quartz, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.ironInfusedStone), "OSO", "SCS", "OSO", 'O', Items.iron_ingot, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.goldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.gold_ingot, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.diamondInfusedStone), "OSO", "SCS", "OSO", 'O', Items.diamond, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);
		GameRegistry.addRecipe(new ItemStack(ModPlants.emeraldInfusedStone), "OSO", "SCS", "OSO", 'O', Items.emerald, 'S', Blocks.stone, 'C', ModFragments.itemCrystalFragment);

		//Crystals, C = Crystal of Type
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCrystalOre), "C C", " C ", "CCC", 'C', ModItems.itemCrystal);

		//Machines
		//Socket Station, F = Crystal, C = CraftTable, A = Anvil
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSocketBench), "FFF", "FCF", "FAF", 'F', ModItems.itemCrystal, 'C', Blocks.crafting_table, 'A', Blocks.anvil);

		// Crystal Edged Pickaxe Recipe, F = itemCrystalFragment, I = Iron
		//GameRegistry.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe), " F ", "FIF", 'F', ModItems.itemCrystalFragment, 'I', new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE)); //TODO Remove

		// Apprentice Armor Recipes, Placeholder, W = Wool, S = String
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeHood), "WWW", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeRobe), "W W", "WWW", "WWW", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeLeggings), "WWW", "W W", "W W", 'W', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(ModArmor.apprenticeBoots), "W W", "W W", 'W', Blocks.wool);
	}
}
