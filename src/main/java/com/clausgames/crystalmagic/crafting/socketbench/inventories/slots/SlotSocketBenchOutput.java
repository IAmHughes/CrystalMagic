package com.clausgames.crystalmagic.crafting.socketbench.inventories.slots;

import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchResult;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class SlotSocketBenchOutput extends Slot
{
    /** The craft matrix inventory linked to this result slot. */
    private final InventorySocketBenchInput craftMatrix;
    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;
    /** The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset. */
    private int amountCrafted;
    int slotIndex;

    public SlotSocketBenchOutput(EntityPlayer player, InventorySocketBenchInput inputInventory, InventorySocketBenchResult outputInventory, int i, int j, int k)
    {
        super(outputInventory, i, j, k);
        this.slotIndex = i;
        this.thePlayer = player;
        this.craftMatrix = inputInventory;
    }
    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    @Override
    public ItemStack decrStackSize(int slotIndex)
    {
        if (this.getHasStack())
        {
            this.amountCrafted += Math.min(slotIndex, this.getStack().stackSize);
        }

        return super.decrStackSize(slotIndex);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    @Override
    protected void onCrafting(ItemStack itemStack, int count)
    {
        this.amountCrafted += count;
        this.onCrafting(itemStack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
    protected void onCrafting(ItemStack itemStack)
    {
        itemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
        this.amountCrafted = 0;

        /*if (p_75208_1_.getItem() == Item.getItemFromBlock(Blocks.crafting_table)) //TODO Achievements?
        {
            this.thePlayer.addStat(AchievementList.buildWorkBench, 1);
        }*/
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        FMLCommonHandler.instance().firePlayerCraftingEvent(player, itemStack, craftMatrix);
        this.onCrafting(itemStack);

        for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);

            if (itemstack1 != null)
            {
                this.craftMatrix.decrStackSize(i, 1);

                if (itemstack1.getItem().hasContainerItem(itemstack1))
                {
                    ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

                    if (itemstack2 != null && itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
                        continue;
                    }

                    if (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))
                    {
                        if (this.craftMatrix.getStackInSlot(i) == null)
                        {
                            this.craftMatrix.setInventorySlotContents(i, itemstack2);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
                        }
                    }
                }
            }
        }
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
     * Helper fnct to get the stack in the slot.
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
    public boolean isSlotInInventory(InventorySocketBenchResult inventorySocketBenchInput, int slotIndex)
    {
        return inventorySocketBenchInput == this.inventory && slotIndex == this.slotIndex;
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