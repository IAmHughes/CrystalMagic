package com.clausgames.crystalmagic.blocks;

import com.clausgames.crystalmagic.creativetab.CreativeTabCrystalMagic;
import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.tool.ModTools;
import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.lib.LibNames;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import com.clausgames.crystalmagic.tile.TileEntityBlockCrystalOre;

import java.util.ArrayList;


public class BlockCrystalOre extends BlockContainer
{
    protected BlockCrystalOre(Material material)
    {
        super(material);
        this.setBlockName(LibNames.Blocks.CRYSTAL_ORE);
        this.setBlockTextureName(LibMisc.MODID + ":" + LibNames.Blocks.CRYSTAL_ORE);
        this.setHardness(2.0f); // Sets how long it takes to break blocks (Default: Depends on material; stone:1.5f; obsidian:50.0f)
        this.setResistance(6.0f); // Sets blocks's resistance to explosions (TNT, Creeper, Etc) (Default: Depends on material; stone:10.0f; obsidian:2000.0f)
        this.setLightLevel(0.3f); // Sets how much light is emitted from blocks (Default: 0.0f (nothing); maximum 1.0f(full sunlight))
        this.setHarvestLevel("pickaxe", 2); // Sets the tool and tool level required to break the blocks. If you don't use this the blocks destruction is set by material type chosen. (Tool: Pickaxe, Axe, Shovel. Level: 0=Wood; 1=Stone; 2=Iron; 3=Diamond)
        this.setStepSound(soundTypeStone); // Sets sound of stepping on blocks. (Default: depends on material type chosen)
        this.setCreativeTab(CreativeTabCrystalMagic.tabCrystalMagic);
    }

    public int getRenderType()
    {
        return -1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityBlockCrystalOre();
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        EntityPlayerMP player = (EntityPlayerMP) harvesters.get();
        Item toolUsed = harvesters.get().getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
        if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
        {
            drops.clear();
            drops.add(new ItemStack(ModItems.itemRoughCrystal, world.rand.nextInt(4) + 1)); //drops Rough Crystal 1-4
            return drops;
        } else
        {
            drops.clear();
            return drops;
        }
    }
}
