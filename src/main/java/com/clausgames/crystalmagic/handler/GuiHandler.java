package com.clausgames.crystalmagic.handler;

import com.clausgames.crystalmagic.CrystalMagic;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import com.clausgames.crystalmagic.gui.CrystalCodexGui;
import com.clausgames.crystalmagic.gui.SocketBenchGui;
import com.clausgames.crystalmagic.lib.LibNames;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {


        if (ID == CrystalMagic.GUI_ENUM.SOCKET_BENCH.ordinal())
        {
            return new SocketBenchContainer(player.inventory, world, x, y, z);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Minecraft mc = Minecraft.getMinecraft();

        if (ID == CrystalMagic.GUI_ENUM.SOCKET_BENCH.ordinal())
        {
            return new SocketBenchGui(player.inventory, world, StatCollector.translateToLocal(LibNames.Containers.SOCKET_BENCH), x, y, z);
        }

        if (ID == CrystalMagic.GUI_ENUM.CRYSTALCODEX.ordinal())
        {
            return new CrystalCodexGui(mc);
        }
        return null;
    }
}
