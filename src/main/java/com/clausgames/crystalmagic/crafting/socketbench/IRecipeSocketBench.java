package com.clausgames.crystalmagic.crafting.socketbench;

import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchInput;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipeSocketBench
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventorySocketBenchInput inventorySocketBenchInput, World worldObj);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventorySocketBenchInput inventorySocketBenchInput);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();
}