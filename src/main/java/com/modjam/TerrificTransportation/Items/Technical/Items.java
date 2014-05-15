package com.modjam.TerrificTransportation.Items.Technical;

import com.modjam.TerrificTransportation.Items.Item.Wrench;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items {

    public static Item Wrench;

    public static void init() {
        registerItems();
        addItems();
    }

    public static void registerItems() {
        Wrench = new Wrench().setUnlocalizedName(ItemInfo.WrenchUnlocalized);
    }

    public static void addItems() {
        GameRegistry.registerItem(Wrench, ItemInfo.WrenchUnlocalized);
    }


}
