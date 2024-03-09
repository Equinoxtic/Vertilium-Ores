package com.equinoxtic.vertiliumores;

import com.equinoxtic.vertiliumores.proxy.CommonProxy;
import com.equinoxtic.vertiliumores.creativetabs.VertiliumOresMainTab;
import com.equinoxtic.vertiliumores.util.Reference;
import com.equinoxtic.vertiliumores.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    public static final CreativeTabs VERTILIUM_ORES = new VertiliumOresMainTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegistries(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        RegistryHandler.postInitRegistries(event);
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event)
    {
        RegistryHandler.serverRegistries(event);
    }
}
