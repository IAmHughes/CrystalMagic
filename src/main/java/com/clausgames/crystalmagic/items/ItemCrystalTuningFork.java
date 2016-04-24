package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.blocks.BlockCrystalOre;
import com.clausgames.crystalmagic.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ItemCrystalTuningFork extends ItemCrystalMagic
{
    public ItemCrystalTuningFork(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    /*@Override //TODO fix this. Lava blocks need update call, there must be a better way then setting to air I just wasn't sure what method yet. Otherwise works.
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int worldX, int worldY, int worldZ, int blockSide, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(worldX, worldY, worldZ);
        Block b1 = world.getBlock(worldX + 1, worldY, worldZ);
        Block b2 = world.getBlock(worldX - 1, worldY, worldZ);
        Block b3 = world.getBlock(worldX, worldY, worldZ + 1);
        Block b4 = world.getBlock(worldX, worldY, worldZ - 1);
        Block lava = Blocks.lava;
        Boolean isCrystal = block instanceof BlockCrystalOre;
        Boolean recipeFireCrystalOre = (b1 == lava && b2 == lava && b3 == lava && b4 == lava);

        if (isCrystal && recipeFireCrystalOre && !player.isSneaking())
        {
            world.setBlockToAir(worldX + 1, worldY, worldZ);
            world.setBlockToAir(worldX - 1, worldY, worldZ);
            world.setBlockToAir(worldX, worldY, worldZ + 1);
            world.setBlockToAir(worldX, worldY, worldZ - 1);
            world.setBlockToAir(worldX, worldY, worldZ);
            world.setBlock(worldX, worldY, worldZ, Blocks.cobblestone); //TODO Replace with blockFireCrystalOre;
        }
        //If its a Crystal, return crystal of said type.
        if (isCrystal && player.isSneaking()) //TODO Add blockFireCrystalOre
        {
            EntityItem crystal = new EntityItem(world, (double)worldX, (double)worldY + 0.5D, (double)worldZ);
            if (block == ModBlocks.blockCrystalOre)
            {
                Item drop = ModItems.itemRoughCrystal;
                crystal.setEntityItemStack(new ItemStack(drop));
                world.setBlockToAir(worldX, worldY, worldZ);
                crystal.dropItem(drop, 1);
            }
        }

        return false;
    }*/
}
