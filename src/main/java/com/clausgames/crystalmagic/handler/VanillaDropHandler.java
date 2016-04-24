package com.clausgames.crystalmagic.handler;

import com.clausgames.crystalmagic.items.ModItems;
import com.clausgames.crystalmagic.items.fragments.ModFragments;
import com.clausgames.crystalmagic.items.tool.ModTools;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

public class VanillaDropHandler //This is overriding drop tables of vanilla blocks.
{
    public static void init()
    {
        MinecraftForge.EVENT_BUS.register(new VanillaDropHandler());
    }

    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event) //This is overriding drop tables of vanilla blocks.
    {
        if (event.block == Blocks.gravel)
        {
            World world = event.world;
            EntityPlayer player = event.harvester;

            if(player.getHeldItem() != null) //If used an item.
            {
                ItemStack toolUsed = player.getHeldItem();
                int toolUsedHarvestLevel = player.getHeldItem().getItem().getHarvestLevel(toolUsed, "shovel"); // Gets harvest level of said tool
                if (toolUsedHarvestLevel >= 2) //Iron or better, aka 2 or better.
                {
                    if (world.rand.nextFloat() < 0.25f) //25% Chance to drop a RoughCrystalFragment if using the right shovel!
                    {
                        event.drops.add(new ItemStack(ModItems.itemRoughCrystalFragment, world.rand.nextInt(2) + 1)); //drops RoughCrystalFragment 1-2
                    }
                }
            }
        }

        if (event.block == Blocks.coal_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemCoalCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.redstone_ore ||  event.block == Blocks.lit_redstone_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemRedstoneCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.lapis_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemLapisCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.quartz_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemQuartzCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.iron_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemIronCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.gold_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemGoldCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.diamond_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemDiamondCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }

        if (event.block == Blocks.emerald_ore)
        {
            ItemStack stack = new ItemStack(ModFragments.itemEmeraldCrystalFragment, 1, 0);
            World world = event.world;
            EntityPlayer player = event.harvester;
            if(player.getCurrentEquippedItem() != null)
            {
                Item toolUsed = player.getCurrentEquippedItem().getItem(); // Checks what tool was that player used to break item.
                if (toolUsed.equals(ModTools.itemCrystalEdgedPickaxe))
                {
                    if (world.rand.nextFloat() < 0.05f) //5% Chance to drop an OreCrystalFragment Seed if using the right pick!
                    {
                        event.drops.add(stack);
                    }
                }
            }
        }
    }
}