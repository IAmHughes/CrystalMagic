package com.clausgames.crystalmagic.proxy;

public interface IProxy
{
    public void registerRenderThings();

    public void registerTileEntitySpecialRenderer();

    public abstract ClientProxy getClientProxy();
}
