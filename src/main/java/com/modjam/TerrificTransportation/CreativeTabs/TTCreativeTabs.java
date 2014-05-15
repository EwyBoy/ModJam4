package com.modjam.terrifictransportation.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TTCreativeTabs {

    public static void init() {
        addCreativeTabs();
    }
    public static void addCreativeTabs() {

    }

        public static CreativeTabs ClockworkBlockTab = new CreativeTabs ("Clockwork Block") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Blocks.anvil);
            }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
            public static CreativeTabs ClockworkItemTab = new CreativeTabs ("Clockwork Block") {
                public ItemStack getIconItemStack() {
                    return new ItemStack(Items.ender_eye);
                }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };


}
