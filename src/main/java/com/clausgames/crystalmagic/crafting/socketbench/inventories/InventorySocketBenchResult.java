package com.clausgames.crystalmagic.crafting.socketbench.inventories;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventorySocketBenchResult implements IInventory
{
    /** A list of one item containing the result of the crafting formula */
    private ItemStack[] stackResult = new ItemStack[1];

    @Override
    public int getSizeInventory() // Returns the number of slots in the inventory.
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int par1) // Returns the stack in slot i
    {
        return stackResult[0];
    }

    @Override
    public String getInventoryName()
    {
        return "Result";
    }// Returns the name of the inventory

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }// Returns if the inventory is named

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize(int slotIndex, int count)
    {
        if (this.stackResult[0] != null)
        {
            ItemStack itemstack = this.stackResult[0];
            this.stackResult[0] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }
    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        if (this.stackResult[0] != null)
        {
            ItemStack itemstack = this.stackResult[0];
            this.stackResult[0] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        this.stackResult[0] = itemStack;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty() {}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return true;
    }
}
