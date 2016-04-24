package com.clausgames.crystalmagic.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class LibMaterial
{
    public static final class Tools
    {
        // Example Tool Material: public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
        public static final Item.ToolMaterial crystalEdgedToolMaterial = EnumHelper.addToolMaterial("crystalEdgedToolMaterial", 2, 131, 4.0f, 1.0f, 5);
    }

    public static final class Armor
    {
        // Example Armor Material: public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("NAME", durability, damageReduction[], enchantability);
        public static final ItemArmor.ArmorMaterial apprenticeArmorMaterial = EnumHelper.addArmorMaterial("apprenticeArmor", 5, new int[]{1, 3, 2, 1}, 15);
    }
}