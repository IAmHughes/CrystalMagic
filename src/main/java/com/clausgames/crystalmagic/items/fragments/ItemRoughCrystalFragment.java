package com.clausgames.crystalmagic.items.fragments;

import com.clausgames.crystalmagic.achievement.IPickupAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import com.clausgames.crystalmagic.items.ItemCrystalMagic;
import com.clausgames.crystalmagic.items.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemRoughCrystalFragment extends ItemCrystalMagic implements IPickupAchievement
{
    public ItemRoughCrystalFragment(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item) {
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        if (stack.getItemDamage() == 0)
        {
            if (!playerMP.func_147099_x().hasAchievementUnlocked(ModAchievements.roughCrystalFragmentPickup)) //Checks if you have achievement yet
            {
                item.dropItem(ModItems.itemCrystalCodex, 1); //If don't have achievement, give player CrystalCodex
            }
            return ModAchievements.roughCrystalFragmentPickup; //Give Achievement
        } else
        {
            return null;
        }
    }
}