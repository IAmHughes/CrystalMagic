package com.clausgames.crystalmagic.gui;

import com.clausgames.crystalmagic.container.SocketBenchContainer;
import com.clausgames.crystalmagic.lib.LibMisc;
import com.clausgames.crystalmagic.lib.LibNames;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class SocketBenchGui extends GuiContainer
{
    public SocketBenchContainer container;
    private final String blockName;

    public SocketBenchGui(InventoryPlayer playerInventory, World parWorld, String parBlockName, int parX, int parY, int parZ)
    {
        super(new SocketBenchContainer(playerInventory, parWorld, parX, parY, parZ));
        container = (SocketBenchContainer) inventorySlots;
        blockName = parBlockName;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    public void actionPerformed(GuiButton button) {}

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
    }

    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        GL11.glDisable(GL11.GL_LIGHTING);

        fontRendererObj.drawString(blockName, xSize / 2 - fontRendererObj.getStringWidth(blockName) / 2 + 1, 5, 0xFFFFFF); //Centers String in top middle of GUI, 6 pixels down, color we choose.
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 4, 0xFFFFFF); //Says "Inventory" on GUI

        GL11.glEnable(GL11.GL_LIGHTING);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glPushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

        mc.renderEngine.bindTexture(new ResourceLocation(LibMisc.MODID + ":textures/gui/socketBenchGui.png"));
        int k = width / 2 - xSize / 2;
        int l = height / 2 - ySize / 2;
        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        GL11.glPopMatrix();
    }
}
