package com.clausgames.crystalmagic.items.tool;

import com.clausgames.crystalmagic.lib.LibMaterial;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModTools
{
    // Declaration of Tools/Weapons
    // Example: public static Item itemFlintPickaxe;
    public static Item itemCrystalEdgedPickaxe = new ItemCrystalEdgedPickaxe("ItemCrystalEdgedPickaxe", LibMaterial.Tools.crystalEdgedToolMaterial);

    public static void init()
    {
        //Registration of Tools
        GameRegistry.registerItem(itemCrystalEdgedPickaxe, "itemCrystalEdgedPickaxe");
    }
}
