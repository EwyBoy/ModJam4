package com.modjam.TerrificTransportation.Items.Item;

import com.modjam.TerrificTransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.TerrificTransportation.Items.Technical.ItemInfo;
import com.modjam.TerrificTransportation.Texture.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class Wrench extends Item {

    public Wrench() {
        super();
        setMaxStackSize(1);
        setCreativeTab(TTCreativeTabs.ClockworkItemTab);
    }

    @SideOnly(Side.CLIENT)
    private IIcon WrenchActivated01;
    private IIcon WrenchActivated02;
    private IIcon WrenchDeactivated;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        WrenchActivated01 = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchActivatedTexture01);
        WrenchActivated02 = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchActivatedTexture02);
        WrenchDeactivated = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchDeactivatedTexture);
    }

    private String WrenchMode = "Deactivated";
    private int WrenchModeID = 0;


}
