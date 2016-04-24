package com.clausgames.crystalmagic.items.tool;

import com.clausgames.crystalmagic.achievement.ICraftAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemCrystalEdgedPickaxe extends ItemPickaxe implements ICraftAchievement
{
    public ItemCrystalEdgedPickaxe(String unlocalizedName, ToolMaterial material)
    {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(LibMisc.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
        this.setMaxStackSize(1);
    }

    @Override
    public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix)
    {
        return ModAchievements.crystalEdgedPickaxeCraft;
    }
}
