package com.modjam.terrifictransportation.Main;


import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Info.ModInfo;
import com.modjam.terrifictransportation.Items.Technical.Items;
import com.modjam.terrifictransportation.KeyBindings.KeyBindings;
import com.modjam.terrifictransportation.Network.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ModID, name = ModInfo.ModName, version = ModInfo.ModVersion)

public class TT
{
    @Mod.Instance(ModInfo.ModID)
    public static TT instance;

    @SidedProxy(modId = ModInfo.ModID, clientSide = "com.modjam.terrifictransportation.Network.ClientProxy", serverSide = "com.modjam.terrifictransportation.Network.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void PreInit (FMLPreInitializationEvent event)
    {
        Blocks.init();
        Items.init();
        TTCreativeTabs.init();
        proxy.initRenders();
        KeyBindings.shiftIsPressed();
    }

    @Mod.EventHandler
    public void load (FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void ModsLoaded (FMLPreInitializationEvent event){

    }
}
