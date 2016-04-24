package com.clausgames.crystalmagic.crafting.socketbench;

import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.sockets.ModSockets;
import com.clausgames.crystalmagic.items.tool.ModTools;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class SocketBenchRecipeManager
{
    /** The static instance of this class */
    private static final SocketBenchRecipeManager instance = new SocketBenchRecipeManager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();

    /** The static instance of this class */
    public static final SocketBenchRecipeManager getInstance() { return instance; }

    public SocketBenchRecipeManager() //TODO add recipes properly with socketed tools and such
    {
        this.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1), "  ", "PE", "  ", 'P', (new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE)), 'E', ModSockets.itemEmptySocket);
        this.addRecipe(new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1), " E", "PE", " E", 'P', (new ItemStack(Items.diamond_pickaxe, 1, OreDictionary.WILDCARD_VALUE)), 'E', ModSockets.itemCrystalizedSocket);
        this.addRecipe(new ItemStack(Items.nether_star, 1), " F", "PL", " S", 'P', (new ItemStack(ModTools.itemCrystalEdgedPickaxe, 1, OreDictionary.WILDCARD_VALUE)), 'F', ModSockets.itemFierySocket, 'L', ModSockets.itemLuckySocket, 'S', ModSockets.itemSpeedySocket);
        this.addShapelessRecipe(new ItemStack(ModItems.itemCrystalCodex, 1), (new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE)), ModSockets.itemFierySocket, ModSockets.itemLuckySocket, ModSockets.itemSpeedySocket);

        Collections.sort(this.recipes, new Comparator()
        {
            private static final String __OBFID = "CL_00000091";

            public int compare(IRecipeSocketBench p_compare_1_, IRecipeSocketBench p_compare_2_)
            {
                return p_compare_1_ instanceof SocketBenchShapelessRecipes && p_compare_2_ instanceof SocketBenchShapedRecipes ? 1 : (p_compare_2_ instanceof SocketBenchShapelessRecipes && p_compare_1_ instanceof SocketBenchShapedRecipes ? -1 : (p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize() ? -1 : (p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize() ? 1 : 0)));
            }

            public int compare(Object p_compare_1_, Object p_compare_2_)
            {
                return this.compare((IRecipeSocketBench) p_compare_1_, (IRecipeSocketBench) p_compare_2_);
            }
        });
    }

    public SocketBenchShapedRecipes addRecipe(ItemStack outputItems, Object ... inputItems)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (inputItems[i] instanceof String[])
        {
            String[] astring = (String[])((String[])inputItems[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (inputItems[i] instanceof String)
            {
                String s2 = (String)inputItems[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < inputItems.length; i += 2)
        {
            Character character = (Character)inputItems[i];
            ItemStack itemstack1 = null;

            if (inputItems[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)inputItems[i + 1]);
            }
            else if (inputItems[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)inputItems[i + 1], 1, 32767);
            }
            else if (inputItems[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)inputItems[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        SocketBenchShapedRecipes shapedrecipes = new SocketBenchShapedRecipes(j, k, aitemstack, outputItems);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack itemStack, Object ... recipe)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = recipe;
        int i = recipe.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new SocketBenchShapelessRecipes(itemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventorySocketBenchInput inputInventory, World worldObj)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < inputInventory.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = inputInventory.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipeSocketBench irecipe = (IRecipeSocketBench)this.recipes.get(j);

                if (irecipe.matches(inputInventory, worldObj))
                {
                    return irecipe.getCraftingResult(inputInventory);
                }
            }

            return null;
        }
    }
    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}