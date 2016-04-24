package com.clausgames.crystalmagic.blocks;

import codechicken.lib.math.MathHelper;
import com.clausgames.crystalmagic.CrystalMagic;
import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.lib.LibNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSocketBench extends BlockCrystalMagic
{
    @SideOnly(Side.CLIENT)
    private IIcon socketBenchTop; //Sets top texture, side is already built in with blockIcon

    @SideOnly(Side.CLIENT)
    private IIcon socketBenchBottom; //Sets bottom texture, side is already built in with blockIcon

    public BlockSocketBench(Material material)
    {
        super(material);
        this.setBlockName(LibNames.Blocks.SOCKET_BENCH);
        this.setHardness(3.5f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public boolean onBlockActivated(World parWorld, int x, int y, int z, EntityPlayer parPlayer, int parSide, float hitX, float hitY, float hitZ)
    {
        if(!parWorld.isRemote && !parPlayer.isSneaking())
        {
            // DEBUG
            System.out.println("BlockSocketBench onBlockActivated");

            parPlayer.openGui(CrystalMagic.instance, CrystalMagic.GUI_ENUM.SOCKET_BENCH.ordinal(), parWorld, x, y, z); // Opens GUI
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(LibMisc.MODID + ":socketBenchSide");
        this.socketBenchBottom = iconRegister.registerIcon(LibMisc.MODID + ":socketBenchBottom");
        this.socketBenchTop = iconRegister.registerIcon(LibMisc.MODID + ":socketBenchTop");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 0 && side == 3) //This is front texture if we ever want one.
        {
            return this.blockIcon;
        }else if(side == metadata)
        {
            return this.blockIcon; //This would be front texture if we wanted one
        }else if(side == 0)
        {
            return this.socketBenchBottom; //Bottom Texture
        }else if(side == 1)
        {
            return this.socketBenchTop; //Top Texture
        }else
        {
            return this.blockIcon; //Side Texture
        }
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) //Sets direction based on blocks to left/right/front/back of it and changes metadata, which will change texture.
    {
        if(!world.isRemote)
        {
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);

            byte b0 = 3;

            if(block1.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 3;
            }
            if(block2.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 2;
            }
            if(block3.func_149730_j() && !block4.func_149730_j())
            {
                b0 = 5;
            }
            if(block4.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemStack) //Sets metadata based on where player is so block faces player.
    {
        int i = MathHelper.floor_double((double) (entityPlayer.rotationYaw * 4.0f / 360f) + 0.5d) & 3;

        if (i == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (i == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (i == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (i == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
}
