package com.clausgames.crystalmagic.container;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchInput;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.InventorySocketBenchResult;
import com.clausgames.crystalmagic.crafting.socketbench.SocketBenchRecipeManager;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.slots.SlotSocketBenchInput;
import com.clausgames.crystalmagic.crafting.socketbench.inventories.slots.SlotSocketBenchOutput;
import com.clausgames.crystalmagic.items.sockets.ItemSocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SocketBenchContainer extends Container
{
    public InventorySocketBenchInput inputInventory = new InventorySocketBenchInput(this, 2, 3); //Creates 2x3 inventory for input of armor/tool/weapon (we only draw 1x 1x3)
    public int inputSlotNumber1x1 = 2;
    public int inputSlotNumberSocketTop = 1;
    public int inputSlotNumberSocketMid = 3;
    public int inputSlotNumberSocketBottom = 5;
    public int outputSlotNumber = 0;
    public InventorySocketBenchResult outputInventory = new InventorySocketBenchResult(); //Creates 1x1 inventory for output
    public SocketBenchRecipeManager socketBenchRecipeManager;
    private final World worldObj;
    public InventoryPlayer playerInventory;
    public int x = 0;
    public int y = 0;
    public int z = 0;
    private int field_94535_f = -1;
    private int field_94536_g;
    private final Set field_94537_h = new HashSet();

    public SocketBenchContainer(InventoryPlayer parPlayerInventory, World parWorld, int parX, int parY, int parZ)
    {
        x = parX;
        y = parY;
        z = parZ;
        worldObj = parWorld;

        socketBenchRecipeManager = new SocketBenchRecipeManager();

        //Start Drawing Custom Slots

        this.addSlotToContainer(new SlotSocketBenchInput(parPlayerInventory.player, inputInventory, this, this.inputSlotNumber1x1, 20, 35)); //Draws our slot for 1x1 Tool/Armor/Weapon Slot

        for (int inputSlotIndexX = 0; inputSlotIndexX < 1; ++inputSlotIndexX) //Draws our slots for 1x3 Socket Slots
        {
            for (int inputSlotIndexY = 0; inputSlotIndexY < 3; ++inputSlotIndexY)
            {
                addSlotToContainer(new SlotSocketBenchInput(parPlayerInventory.player, inputInventory, this, (2 * inputSlotIndexY) + 1, 78, 18 * (inputSlotIndexY + 1) - 1));
            }
        }

        this.addSlotToContainer(new SlotSocketBenchOutput(parPlayerInventory.player, inputInventory, outputInventory, this.outputSlotNumber, 136, 35)); //Draws our output slot

        //End Drawing Custom Slots

        //Start Drawing Player Slots

        playerInventory = parPlayerInventory;

        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) //Creates player inventory
        {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX)
            {
                addSlotToContainer(new Slot(parPlayerInventory, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }

        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) //Created player hotbar
        {
            addSlotToContainer(new Slot(parPlayerInventory, hotbarSlotIndex, 8 + hotbarSlotIndex * 18, 142));
        }

        this.onCraftMatrixChanged(this.inputInventory);

        //End Drawing Player Slots
    }

    @Override
    public void onCraftMatrixChanged(IInventory parInventory)
    {
        //Gets ItemStack for output based on what's in each slot
        this.outputInventory.setInventorySlotContents(outputSlotNumber, SocketBenchRecipeManager.getInstance().findMatchingRecipe(this.inputInventory, this.worldObj));
    }

    @Override
    public ItemStack slotClick(int parSlotId, int parMouseButtonId, int parClickMode, EntityPlayer parPlayer) //This handles click/drag function within slots I believe.
    {
        ItemStack itemstack = null;
        InventoryPlayer inventoryplayer = parPlayer.inventory;
        int i1;
        ItemStack itemstack3;

        if (parClickMode == 5)
        {
            int l = this.field_94536_g;
            this.field_94536_g = func_94532_c(parMouseButtonId);

            if ((l != 1 || this.field_94536_g != 2) && l != this.field_94536_g)
            {
                this.func_94533_d();
            }
            else if (inventoryplayer.getItemStack() == null)
            {
                this.func_94533_d();
            }
            else if (this.field_94536_g == 0)
            {
                this.field_94535_f = func_94529_b(parMouseButtonId);

                if (func_94528_d(this.field_94535_f))
                {
                    this.field_94536_g = 1;
                    this.field_94537_h.clear();
                }
                else
                {
                    this.func_94533_d();
                }
            }
            else if (this.field_94536_g == 1)
            {
                Slot slot = (Slot)this.inventorySlots.get(parSlotId);

                if (slot != null && func_94527_a(slot, inventoryplayer.getItemStack(), true) && slot.isItemValid(inventoryplayer.getItemStack()) && inventoryplayer.getItemStack().stackSize > this.field_94537_h.size() && this.canDragIntoSlot(slot))
                {
                    this.field_94537_h.add(slot);
                }
            }
            else if (this.field_94536_g == 2)
            {
                if (!this.field_94537_h.isEmpty())
                {
                    itemstack3 = inventoryplayer.getItemStack().copy();
                    i1 = inventoryplayer.getItemStack().stackSize;
                    Iterator iterator = this.field_94537_h.iterator();

                    while (iterator.hasNext())
                    {
                        Slot slot1 = (Slot)iterator.next();

                        if (slot1 != null && func_94527_a(slot1, inventoryplayer.getItemStack(), true) && slot1.isItemValid(inventoryplayer.getItemStack()) && inventoryplayer.getItemStack().stackSize >= this.field_94537_h.size() && this.canDragIntoSlot(slot1))
                        {
                            ItemStack itemstack1 = itemstack3.copy();
                            int j1 = slot1.getHasStack() ? slot1.getStack().stackSize : 0;
                            func_94525_a(this.field_94537_h, this.field_94535_f, itemstack1, j1);

                            if (itemstack1.stackSize > itemstack1.getMaxStackSize())
                            {
                                itemstack1.stackSize = itemstack1.getMaxStackSize();
                            }

                            if (itemstack1.stackSize > slot1.getSlotStackLimit())
                            {
                                itemstack1.stackSize = slot1.getSlotStackLimit();
                            }

                            i1 -= itemstack1.stackSize - j1;
                            slot1.putStack(itemstack1);
                        }
                    }

                    itemstack3.stackSize = i1;

                    if (itemstack3.stackSize <= 0)
                    {
                        itemstack3 = null;
                    }

                    inventoryplayer.setItemStack(itemstack3);
                }

                this.func_94533_d();
            }
            else
            {
                this.func_94533_d();
            }
        }
        else if (this.field_94536_g != 0)
        {
            this.func_94533_d();
        }
        else
        {
            Slot slot2;
            int l1;
            ItemStack itemstack5;

            if ((parClickMode == 0 || parClickMode == 1) && (parMouseButtonId == 0 || parMouseButtonId == 1))
            {
                if (parSlotId == -999)
                {
                    if (inventoryplayer.getItemStack() != null && parSlotId == -999)
                    {
                        if (parMouseButtonId == 0)
                        {
                            parPlayer.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack(), true);
                            inventoryplayer.setItemStack((ItemStack)null);
                        }

                        if (parMouseButtonId == 1)
                        {
                            parPlayer.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack().splitStack(1), true);

                            if (inventoryplayer.getItemStack().stackSize == 0)
                            {
                                inventoryplayer.setItemStack((ItemStack)null);
                            }
                        }
                    }
                }
                else if (parClickMode == 1)
                {
                    if (parSlotId < 0)
                    {
                        return null;
                    }

                    slot2 = (Slot)this.inventorySlots.get(parSlotId);

                    if (slot2 != null && slot2.canTakeStack(parPlayer))
                    {
                        itemstack3 = this.transferStackInSlot(parPlayer, parSlotId);

                        if (itemstack3 != null)
                        {
                            Item item = itemstack3.getItem();
                            itemstack = itemstack3.copy();

                            if (slot2.getStack() != null && slot2.getStack().getItem() == item)
                            {
                                this.retrySlotClick(parSlotId, parMouseButtonId, true, parPlayer);
                            }
                        }
                    }
                }
                else
                {
                    if (parSlotId < 0)
                    {
                        return null;
                    }

                    slot2 = (Slot)this.inventorySlots.get(parSlotId);

                    if (slot2 != null)
                    {
                        itemstack3 = slot2.getStack();
                        ItemStack itemstack4 = inventoryplayer.getItemStack();

                        if (itemstack3 != null)
                        {
                            itemstack = itemstack3.copy();
                        }

                        if (itemstack3 == null)
                        {
                            if (itemstack4 != null && slot2.isItemValid(itemstack4))
                            {
                                l1 = parMouseButtonId == 0 ? itemstack4.stackSize : 1;

                                if (l1 > slot2.getSlotStackLimit())
                                {
                                    l1 = slot2.getSlotStackLimit();
                                }

                                if (itemstack4.stackSize >= l1)
                                {
                                    slot2.putStack(itemstack4.splitStack(l1));
                                }

                                if (itemstack4.stackSize == 0)
                                {
                                    inventoryplayer.setItemStack((ItemStack)null);
                                }
                            }
                        }
                        else if (slot2.canTakeStack(parPlayer))
                        {
                            if (itemstack4 == null)
                            {
                                l1 = parMouseButtonId == 0 ? itemstack3.stackSize : (itemstack3.stackSize + 1) / 2;
                                itemstack5 = slot2.decrStackSize(l1);
                                inventoryplayer.setItemStack(itemstack5);

                                if (itemstack3.stackSize == 0)
                                {
                                    slot2.putStack((ItemStack)null);
                                }

                                slot2.onPickupFromSlot(parPlayer, inventoryplayer.getItemStack());
                            }
                            else if (slot2.isItemValid(itemstack4))
                            {
                                if (itemstack3.getItem() == itemstack4.getItem() && itemstack3.getItemDamage() == itemstack4.getItemDamage() && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4))
                                {
                                    l1 = parMouseButtonId == 0 ? itemstack4.stackSize : 1;

                                    if (l1 > slot2.getSlotStackLimit() - itemstack3.stackSize)
                                    {
                                        l1 = slot2.getSlotStackLimit() - itemstack3.stackSize;
                                    }

                                    if (l1 > itemstack4.getMaxStackSize() - itemstack3.stackSize)
                                    {
                                        l1 = itemstack4.getMaxStackSize() - itemstack3.stackSize;
                                    }

                                    itemstack4.splitStack(l1);

                                    if (itemstack4.stackSize == 0)
                                    {
                                        inventoryplayer.setItemStack((ItemStack)null);
                                    }

                                    itemstack3.stackSize += l1;
                                }
                                else if (itemstack4.stackSize <= slot2.getSlotStackLimit())
                                {
                                    slot2.putStack(itemstack4);
                                    inventoryplayer.setItemStack(itemstack3);
                                }
                            }
                            else if (itemstack3.getItem() == itemstack4.getItem() && itemstack4.getMaxStackSize() > 1 && (!itemstack3.getHasSubtypes() || itemstack3.getItemDamage() == itemstack4.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4))
                            {
                                l1 = itemstack3.stackSize;

                                if (l1 > 0 && l1 + itemstack4.stackSize <= itemstack4.getMaxStackSize())
                                {
                                    itemstack4.stackSize += l1;
                                    itemstack3 = slot2.decrStackSize(l1);

                                    if (itemstack3.stackSize == 0)
                                    {
                                        slot2.putStack((ItemStack)null);
                                    }

                                    slot2.onPickupFromSlot(parPlayer, inventoryplayer.getItemStack());
                                }
                            }
                        }

                        slot2.onSlotChanged();
                    }
                }
            }
            else if (parClickMode == 2 && parMouseButtonId >= 0 && parMouseButtonId < 9)
            {
                slot2 = (Slot)this.inventorySlots.get(parSlotId);

                if (slot2.canTakeStack(parPlayer))
                {
                    itemstack3 = inventoryplayer.getStackInSlot(parMouseButtonId);
                    boolean flag = itemstack3 == null || slot2.inventory == inventoryplayer && slot2.isItemValid(itemstack3);
                    l1 = -1;

                    if (!flag)
                    {
                        l1 = inventoryplayer.getFirstEmptyStack();
                        flag |= l1 > -1;
                    }

                    if (slot2.getHasStack() && flag)
                    {
                        itemstack5 = slot2.getStack();
                        inventoryplayer.setInventorySlotContents(parMouseButtonId, itemstack5.copy());

                        if ((slot2.inventory != inventoryplayer || !slot2.isItemValid(itemstack3)) && itemstack3 != null)
                        {
                            if (l1 > -1)
                            {
                                inventoryplayer.addItemStackToInventory(itemstack3);
                                slot2.decrStackSize(itemstack5.stackSize);
                                slot2.putStack((ItemStack)null);
                                slot2.onPickupFromSlot(parPlayer, itemstack5);
                            }
                        }
                        else
                        {
                            slot2.decrStackSize(itemstack5.stackSize);
                            slot2.putStack(itemstack3);
                            slot2.onPickupFromSlot(parPlayer, itemstack5);
                        }
                    }
                    else if (!slot2.getHasStack() && itemstack3 != null && slot2.isItemValid(itemstack3))
                    {
                        inventoryplayer.setInventorySlotContents(parMouseButtonId, (ItemStack)null);
                        slot2.putStack(itemstack3);
                    }
                }
            }
            else if (parClickMode == 3 && parPlayer.capabilities.isCreativeMode && inventoryplayer.getItemStack() == null && parSlotId >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(parSlotId);

                if (slot2 != null && slot2.getHasStack())
                {
                    itemstack3 = slot2.getStack().copy();
                    itemstack3.stackSize = itemstack3.getMaxStackSize();
                    inventoryplayer.setItemStack(itemstack3);
                }
            }
            else if (parClickMode == 4 && inventoryplayer.getItemStack() == null && parSlotId >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(parSlotId);

                if (slot2 != null && slot2.getHasStack() && slot2.canTakeStack(parPlayer))
                {
                    itemstack3 = slot2.decrStackSize(parMouseButtonId == 0 ? 1 : slot2.getStack().stackSize);
                    slot2.onPickupFromSlot(parPlayer, itemstack3);
                    parPlayer.dropPlayerItemWithRandomChoice(itemstack3, true);
                }
            }
            else if (parClickMode == 6 && parSlotId >= 0)
            {
                slot2 = (Slot)this.inventorySlots.get(parSlotId);
                itemstack3 = inventoryplayer.getItemStack();

                if (itemstack3 != null && (slot2 == null || !slot2.getHasStack() || !slot2.canTakeStack(parPlayer)))
                {
                    i1 = parMouseButtonId == 0 ? 0 : this.inventorySlots.size() - 1;
                    l1 = parMouseButtonId == 0 ? 1 : -1;

                    for (int i2 = 0; i2 < 2; ++i2)
                    {
                        for (int j2 = i1; j2 >= 0 && j2 < this.inventorySlots.size() && itemstack3.stackSize < itemstack3.getMaxStackSize(); j2 += l1)
                        {
                            Slot slot3 = (Slot)this.inventorySlots.get(j2);

                            if (slot3.getHasStack() && func_94527_a(slot3, itemstack3, true) && slot3.canTakeStack(parPlayer) && this.func_94530_a(itemstack3, slot3) && (i2 != 0 || slot3.getStack().stackSize != slot3.getStack().getMaxStackSize()))
                            {
                                int k1 = Math.min(itemstack3.getMaxStackSize() - itemstack3.stackSize, slot3.getStack().stackSize);
                                ItemStack itemstack2 = slot3.decrStackSize(k1);
                                itemstack3.stackSize += k1;

                                if (itemstack2.stackSize <= 0)
                                {
                                    slot3.putStack((ItemStack)null);
                                }

                                slot3.onPickupFromSlot(parPlayer, itemstack2);
                            }
                        }
                    }
                }

                this.detectAndSendChanges();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer parPlayer) //Callback for when the crafting gui is closed.
    {
        super.onContainerClosed(parPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 6; ++i)
            {
                ItemStack itemstack = this.inputInventory.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    parPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.worldObj.getBlock(this.x, this.y, this.z) != ModBlocks.blockSocketBench ? false : player.getDistanceSq((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) <= 64.0D;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int fromSlot) // Called when a player shift-clicks on a slots. You must override this or you will crash when someone does that.
    {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack current = slot.getStack();
            previous = current.copy();
            boolean slot2Valid = (current.getItem() instanceof ItemTool || current.getItem() instanceof ItemArmor || current.getItem() instanceof ItemHoe); //Checks if item going to slots 0 is Tool or Armor (or Hoe)
            boolean slot135Valid = (current.getItem() instanceof ItemSocket); //Checks if item going to slots 1, 3, or 5 is a Socket

            if (fromSlot < 5)
            {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 5, 41, true))
                    return null;
            } else if(fromSlot > 4 && slot2Valid)
            {
                // From Player Inventory to TE Inventory (not including output of course)
                if (!this.mergeItemStack(current, 0, 1, false))
                    return null;
            } else if(fromSlot > 4 && slot135Valid)
            {
                // From Player Inventory to TE Inventory (not including output of course)
                if (!this.mergeItemStack(current, 1, 4, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(player, current);
        }
        return previous;
    }

    @Override
    public Slot getSlot(int parSlotIndex)
    {
        if(parSlotIndex >= inventorySlots.size())
            parSlotIndex = inventorySlots.size() - 1;
        return super.getSlot(parSlotIndex);
    }

    public boolean func_94530_a(ItemStack itemStack, SlotSocketBenchOutput outputSlot)
    {
        return outputSlot.inventory != this.outputInventory && super.func_94530_a(itemStack, outputSlot);
    }

    @Override
    protected void func_94533_d()
    {
        this.field_94536_g = 0;
        this.field_94537_h.clear();
    }
}