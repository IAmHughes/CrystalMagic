package com.clausgames.crystalmagic.proxy;

import com.clausgames.crystalmagic.blocks.ModBlocks;
import com.clausgames.crystalmagic.client.renderer.ItemRenderCrystalOre;
import com.clausgames.crystalmagic.client.renderer.RenderCrystalOre;
import com.clausgames.crystalmagic.tile.TileEntityBlockCrystalOre;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	public void registerRenderThings()
	{
		//CrystalOreBlock
		TileEntitySpecialRenderer render = new RenderCrystalOre();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockCrystalOre.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockCrystalOre), new ItemRenderCrystalOre(render, new TileEntityBlockCrystalOre()));
	}

	public void registerTileEntitySpecialRenderer()
	{

	}

	@Override
	public com.clausgames.crystalmagic.proxy.ClientProxy getClientProxy()
	{
		return this;
	}
}
