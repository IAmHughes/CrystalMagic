package com.clausgames.crystalmagic.crafting.socketbench.inventories;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventorySocketBenchInput implements IInventory
{
    private final ItemStack[] stackList;
    private int inventoryWidth;
    private SocketBenchContainer eventHandler;

    public InventorySocketBenchInput(SocketBenchContainer socketBenchContainer, int columns, int rows)
    {
        int k = columns * rows;
        this.stackList = new ItemStack[k];
        this.eventHandler = socketBenchContainer;
        this.inventoryWidth = columns;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory()
    {
        return this.stackList.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return slotIndex >= this.getSizeInventory() ? null : this.stackList[slotIndex];
    }

    /**
     * Returns the itemstack in the slot specified (Top left is 0, 0). Args: row, column
     */
    public ItemStack getStackInRowAndColumn(int row, int column)
    {
        if (row >= 0 && row < this.inventoryWidth)
        {
            int k = row + column * this.inventoryWidth;
            return this.getStackInSlot(k);
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName()
    {
        return "Input";
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }
    /**
     * When some containers are closed they call this on each slot, then drop
     * whatever it returns as an EntityItem - like when you close a workbench
     * GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        if(stackList[slotIndex] != null)
        {
            ItemStack itemstack = stackList[slotIndex];
            stackList[slotIndex] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number
     * (second arg) of items and returns them in a new stack.
     */
    @Override
    public ItemStack decrStackSize(int slotIndex, int count)
    {
        if (this.stackList[slotIndex] != null)
        {
            ItemStack itemstack;

            if (this.stackList[slotIndex].stackSize <= count)
            {
                itemstack = this.stackList[slotIndex];
                this.stackList[slotIndex] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
            else
            {
                itemstack = this.stackList[slotIndex].splitStack(count);

                if (this.stackList[slotIndex].stackSize == 0)
                {
                    this.stackList[slotIndex] = null;
                }

                this.eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
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
        this.stackList[slotIndex] = itemStack;
        this.eventHandler.onCraftMatrixChanged(this);
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

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }
}
