package com.clausgames.crystalmagic.items;

import com.clausgames.crystalmagic.blocks.plants.OreCrystalPlant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class itemDebugOrePlants extends ItemCrystalMagic
{
    public itemDebugOrePlants(String unlocalizedName, String textureName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(textureName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
        list.add("Right click to increase grow, shift + right click to decrease growth.");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int worldX, int worldY, int worldZ, int blockSide, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int blockMeta = world.getBlockMetadata(worldX, worldY, worldZ);
        Block block = world.getBlock(worldX, worldY, worldZ);
        Boolean isOrePlant = block instanceof OreCrystalPlant;
        Boolean isCreative = player.capabilities.isCreativeMode;

        if(blockMeta < 7 && !player.isSneaking() && isOrePlant && isCreative) //metaData cant go past 7, player is not sneaking. This is on our OrePlant.
        {
            blockMeta += 1;
            world.setBlockMetadataWithNotify(worldX, worldY, worldZ, blockMeta, 2);
        } else if(blockMeta > 0 && player.isSneaking() && isOrePlant && isCreative) //metaData can't lower past 0, player is sneaking. This is on our OrePlant.
        {
            blockMeta -=1;
            world.setBlockMetadataWithNotify(worldX, worldY, worldZ, blockMeta, 2);
        }

        if (blockMeta > 7 && isOrePlant && isCreative)
        {
            world.setBlockMetadataWithNotify(worldX, worldY, worldZ, 7, 2); //If somehow metaData goes over 7, resets to 7.  This is on our OrePlant.
        }

        if (blockMeta < 0 && isOrePlant && isCreative)
        {
            world.setBlockMetadataWithNotify(worldX, worldY, worldZ, 0, 2); //If somehow metaData goes lower than 0, resets to 0.  This is on our OrePlant.
        }

        return false;
    }
}
