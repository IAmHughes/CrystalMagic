package com.clausgames.crystalmagic.achievement;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.tool.ModTools;
import com.clausgames.crystalmagic.lib.LibAchievementNames;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class ModAchievements
{
	public static AchievementPage crystalmagicPage;
	public static int pageIndex;

	public static Achievement roughCrystalFragmentPickup;
	public static Achievement roughCrystalPickUp;
	public static Achievement crystalEdgedPickaxeCraft;
	public static Achievement goldenBarsCraft;
	
	public static void init()
	{
		roughCrystalFragmentPickup = new AchievementMod(LibAchievementNames.CRYSTALFRAGMENT_PICKUP, 0, 0, new ItemStack(ModItems.itemRoughCrystalFragment), null);
		crystalEdgedPickaxeCraft = new AchievementMod(LibAchievementNames.CRYSTALEDGEDPICKAXE_CRAFT, 2, 0, ModTools.itemCrystalEdgedPickaxe, roughCrystalFragmentPickup);
		roughCrystalPickUp = new AchievementMod(LibAchievementNames.ROUGHCRYSTAL_PICKUP, 4, 1, new ItemStack(ModItems.itemRoughCrystal), crystalEdgedPickaxeCraft);
		goldenBarsCraft = new AchievementMod(LibAchievementNames.GOLDENBARS_CRAFT, 5, 1, ModBlocks.blockGoldenBars, null);

		
		pageIndex = AchievementPage.getAchievementPages().size();
		crystalmagicPage = new AchievementPage(LibMisc.MODNAME, AchievementMod.achievements.toArray(new Achievement[AchievementMod.achievements.size()]));
		AchievementPage.registerAchievementPage(crystalmagicPage);
		
		FMLCommonHandler.instance().bus().register(new AchievementTriggerer());
	}
}
