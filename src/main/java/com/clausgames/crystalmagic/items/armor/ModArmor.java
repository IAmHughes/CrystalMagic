package com.clausgames.crystalmagic.items.armor;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModArmor
{
    // Declaration of Armor
    public static final ArmorCrystalMagic apprenticeHood = new ItemApprenticeArmor("ItemApprenticeHood", "apprenticeArmor", 0);
    public static final ArmorCrystalMagic apprenticeRobe = new ItemApprenticeArmor("ItemApprenticeRobe", "apprenticeArmor", 1);
    public static final ArmorCrystalMagic apprenticeLeggings = new ItemApprenticeArmor("ItemApprenticeLeggings", "apprenticeArmor", 2);
    public static final ArmorCrystalMagic apprenticeBoots = new ItemApprenticeArmor("ItemApprenticeBoots", "apprenticeArmor", 3);

    public static void init()
    {
        // Register of Each Piece of Armor
        // Apprentice Armor
        GameRegistry.registerItem(apprenticeHood, "apprenticeHood");
        GameRegistry.registerItem(apprenticeRobe, "apprenticeRobe");
        GameRegistry.registerItem(apprenticeLeggings, "apprenticeLeggings");
        GameRegistry.registerItem(apprenticeBoots, "apprenticeBoots");
    }
}