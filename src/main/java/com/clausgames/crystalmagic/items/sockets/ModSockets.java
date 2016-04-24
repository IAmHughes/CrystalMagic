package com.clausgames.crystalmagic.items.sockets;

import com.clausgames.crystalmagic.lib.LibMisc;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LibMisc.MODID)
public class ModSockets
{
    // Declaration of Sockets
    public static ItemSocket itemEmptySocket = new ItemEmptySocket("ItemEmptySocket", LibMisc.MODID + ":ItemEmptySocket");
    public static ItemSocket itemCrystalizedSocket = new ItemEmptySocket("ItemCrystalizedSocket", LibMisc.MODID + ":ItemCrystalizedSocket");
    public static ItemSocket itemTerraSocket = new ItemEmptySocket("ItemTerraSocket", LibMisc.MODID + ":ItemTerraSocket");
    public static ItemSocket itemLuckySocket = new ItemLuckySocket("ItemLuckySocket", LibMisc.MODID + ":ItemLuckySocket");
    public static ItemSocket itemSpeedySocket = new ItemSpeedySocket("ItemSpeedySocket", LibMisc.MODID + ":ItemSpeedySocket");
    public static ItemSocket itemFierySocket = new ItemFierySocket("ItemFierySocket", LibMisc.MODID + ":ItemFierySocket");

    public static void init()
    {
        // Register of Each Socket
        GameRegistry.registerItem(itemEmptySocket, "itemEmptySocket");
        GameRegistry.registerItem(itemCrystalizedSocket, "itemCrystalizedSocket");
        GameRegistry.registerItem(itemTerraSocket, "itemTerraSocket");
        GameRegistry.registerItem(itemLuckySocket, "itemLuckySocket");
        GameRegistry.registerItem(itemSpeedySocket, "itemSpeedySocket");
        GameRegistry.registerItem(itemFierySocket, "itemFierySocket");
    }
}
