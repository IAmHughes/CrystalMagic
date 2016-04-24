package com.clausgames.crystalmagic.items.armor;

import com.clausgames.crystalmagic.lib.LibMaterial;
import com.clausgames.crystalmagic.lib.LibMisc;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

//This Class controls the properties of Apprentice Armor

public class ItemApprenticeArmor extends ArmorCrystalMagic
{
	public String textureName;

	public ItemApprenticeArmor(String unlocalizedName, String textureName, int type)
	{
		super(LibMaterial.Armor.apprenticeArmorMaterial, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(LibMisc.MODID + ":" + unlocalizedName);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return LibMisc.MODID.toLowerCase() + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
		// Texture naming will be textureName_1.png for helmet/chestplate/boots, textureName_2.png for leggings.
	}
}