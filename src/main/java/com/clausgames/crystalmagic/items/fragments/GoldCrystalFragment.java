package com.clausgames.crystalmagic.items.fragments;

import com.clausgames.crystalmagic.blocks.plants.ModPlants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GoldCrystalFragment extends OreCrystalFragment
{
    private Block blockPlant;
    private Block blockSoil;

    public GoldCrystalFragment(String unlocalizedName, String textureName)
    {
        super(ModPlants.goldCrystalPlant, ModPlants.goldInfusedStone); //blockPlant, blockSoil
        this.blockPlant = ModPlants.goldCrystalPlant;
        this.blockSoil = ModPlants.goldInfusedStone;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int worldX, int worldY, int worldZ, int blockSide, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        Boolean isWater = world.getBlock(worldX, worldY + 1, worldZ).getMaterial() == Material.water; //Is blocks above where I click of type water?

        if (blockSide != 0)
        {
            return false;
        }
        else if (player.canPlayerEdit(worldX, worldY, worldZ, blockSide, itemStack) && player.canPlayerEdit(worldX, worldY - 1, worldZ, blockSide, itemStack))
        {
            if (world.getBlock(worldX, worldY, worldZ) == this.blockSoil && world.isAirBlock(worldX, worldY - 1, worldZ) && isWater && this.blockPlant.canPlaceBlockAt(world, worldX, worldY - 1, worldZ))
            {
                world.setBlock(worldX, worldY - 1, worldZ, this.blockPlant);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
