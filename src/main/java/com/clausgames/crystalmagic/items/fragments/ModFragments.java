package com.clausgames.crystalmagic.items.fragments;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModFragments
{
    //OreCrystalFragments
    public static OreCrystalFragment itemCrystalFragment = new ItemCrystalFragment("ItemCrystalFragment", LibMisc.MODID + ":ItemCrystalFragment");
    public static OreCrystalFragment itemCoalCrystalFragment = new CoalCrystalFragment("ItemCoalCrystalFragment", LibMisc.MODID + ":ItemCoalCrystalFragment");
    public static OreCrystalFragment itemRedstoneCrystalFragment = new RedstoneCrystalFragment("ItemRedstoneCrystalFragment", LibMisc.MODID + ":ItemRedstoneCrystalFragment");
    public static OreCrystalFragment itemLapisCrystalFragment = new LapisCrystalFragment("ItemLapisCrystalFragment", LibMisc.MODID + ":ItemLapisCrystalFragment");
    public static OreCrystalFragment itemQuartzCrystalFragment = new QuartzCrystalFragment("ItemQuartzCrystalFragment", LibMisc.MODID + ":ItemQuartzCrystalFragment");
    public static OreCrystalFragment itemIronCrystalFragment = new IronCrystalFragment("ItemIronCrystalFragment", LibMisc.MODID + ":ItemIronCrystalFragment");
    public static OreCrystalFragment itemGoldCrystalFragment = new GoldCrystalFragment("ItemGoldCrystalFragment", LibMisc.MODID + ":ItemGoldCrystalFragment");
    public static OreCrystalFragment itemDiamondCrystalFragment = new DiamondCrystalFragment("ItemDiamondCrystalFragment", LibMisc.MODID + ":ItemDiamondCrystalFragment");
    public static OreCrystalFragment itemEmeraldCrystalFragment = new EmeraldCrystalFragment("ItemEmeraldCrystalFragment", LibMisc.MODID + ":ItemEmeraldCrystalFragment");

    public static void init()
    {
        //OreCrystalFragments
        GameRegistry.registerItem(itemCrystalFragment, "itemCrystalFragment");
        GameRegistry.registerItem(itemCoalCrystalFragment, "itemCoalCrystalFragment");
        GameRegistry.registerItem(itemRedstoneCrystalFragment, "itemRedstoneCrystalFragment");
        GameRegistry.registerItem(itemLapisCrystalFragment, "itemLapisCrystalFragment");
        GameRegistry.registerItem(itemQuartzCrystalFragment, "itemQuartzCrystalFragment");
        GameRegistry.registerItem(itemIronCrystalFragment, "itemIronCrystalFragment");
        GameRegistry.registerItem(itemGoldCrystalFragment, "itemGoldCrystalFragment");
        GameRegistry.registerItem(itemDiamondCrystalFragment, "itemDiamondCrystalFragment");
        GameRegistry.registerItem(itemEmeraldCrystalFragment, "itemEmeraldCrystalFragment");
    }
}
