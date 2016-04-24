package com.clausgames.crystalmagic.crafting.socketbench.inventories.slots;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;

public class SlotSocketBenchInput extends Slot
{
    int slotIndex;
    private EntityPlayer thePlayer;
    public SocketBenchContainer socketBench;
    public InventorySocketBenchInput inventory;
    private int amountCrafted;

    public SlotSocketBenchInput(EntityPlayer entityPlayer, InventorySocketBenchInput inventorySocketBenchInput, SocketBenchContainer socketBenchContainer, int i, int j, int k)
    {
        super(inventorySocketBenchInput, i, j, k);
        slotIndex = i;
        inventory = inventorySocketBenchInput;
        this.thePlayer = entityPlayer;
        socketBench = socketBenchContainer;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        boolean slot2Valid = (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemHoe); //Checks if item going to slots 0 is Tool or Armor (or Hoe)
        boolean slot135Valid = (itemStack.getItem() instanceof ItemSocket); //Checks if item going to slots 1, 3, or 5 is a Socket

        if (slotIndex == socketBench.inputSlotNumber1x1 && slot2Valid)
        {
            return true;
        }else if(slotIndex >= socketBench.inputSlotNumberSocketTop && slotIndex <= socketBench.inputSlotNumberSocketBottom && slot135Valid && slotIndex !=socketBench.inputSlotNumber1x1)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amountCrafted if there's a stack in slot. Returns the new
     * stack.
     */
    @Override
    public ItemStack decrStackSize(int amount)
    {
        return this.inventory.decrStackSize(this.slotIndex, amount);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    @Override
    protected void onCrafting(ItemStack outputItem, int count){}
    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
    protected void onCrafting(ItemStack outputItem) {}

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        this.onSlotChanged();
    }
    /**
     * if par2 has more items than par1, onCrafting(item,countIncrease) is called
     */
    @Override
    public void onSlotChange(ItemStack itemStack, ItemStack itemStack2)
    {
        if (itemStack != null && itemStack2 != null)
        {
            if (itemStack.getItem() == itemStack2.getItem())
            {
                int i = itemStack2.stackSize - itemStack.stackSize;

                if (i > 0)
                {
                    this.onCrafting(itemStack, i);
                }
            }
        }
    }
    /**
     * Helper func to get the stack in the slot.
     */
    @Override
    public ItemStack getStack()
    {
        return this.inventory.getStackInSlot(this.slotIndex);
    }
    /**
     * Returns if this slot contains a stack.
     */
    @Override
    public boolean getHasStack()
    {
        return this.getStack() != null;
    }
    /**
     * Helper method to put a stack in the slot.
     */
    @Override
    public void putStack(ItemStack itemStack)
    {
        this.inventory.setInventorySlotContents(this.slotIndex, itemStack);
        this.onSlotChanged();
    }
    /**
     * Called when the stack in a Slot changes
     */
    @Override
    public void onSlotChanged()
    {
        this.inventory.markDirty();
    }
    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    @Override
    public int getSlotStackLimit()
    {
        return this.inventory.getInventoryStackLimit();
    }
    /**
     * returns true if this slot is in par2 of par1
     */
    public boolean isSlotInInventory(InventorySocketBenchInput inventorySocketBenchInput, int slot)
    {
        return inventorySocketBenchInput == this.inventory && slot == this.slotIndex;
    }
    /**
     * Return whether this slot's stack can be taken from this slot.
     */
    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        return true;
    }

    @Override
    public int getSlotIndex()
    {
        /** The index of the slot in the inventory. */
        return slotIndex;
    }
}
