package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.achievement.IPickupAchievement;
import com.clausgames.crystalmagic.achievement.ModAchievements;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class ItemRoughCrystal extends ItemCrystalMagic implements IPickupAchievement
{
    public ItemRoughCrystal(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item) {
        return stack.getItemDamage() == 0 ? ModAchievements.roughCrystalPickUp : null;
    }
}