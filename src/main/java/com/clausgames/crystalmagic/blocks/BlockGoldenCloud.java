package com.clausgames.crystalmagic.blocks;

import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.lib.LibNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGoldenCloud extends BlockCrystalMagic
{
    public BlockGoldenCloud(Material material)
    {
        super(Material.cloth);
        this.setBlockName(LibNames.Blocks.GOLDEN_CLOUD);
        this.setStepSound(soundTypeCloth);
        this.setBlockTextureName(LibMisc.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered (IBlockAccess iblockaccess, int x, int y, int z, int side)
    {
        Block block = iblockaccess.getBlock(x, y, z);
        if (block == ModBlocks.blockGoldenCloud)
        {
            return false;
        }
        else
        {
            return super.shouldSideBeRendered(iblockaccess, x, y, z, side);
        }
    }

    @Override
    public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (entity.motionY < 0.0D)
        {
            entity.motionY *= 0.005D;
        }
        entity.fallDistance = 0.0F;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 0.6D, z + 1.0D);
    }
}