package com.modjam.terrifictransportation.Crafting;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingRecipes {

    public static void init() {
        registerCrafing();
    }

    public static void registerCrafing() {
        GameRegistry.addRecipe(new ItemStack(Blocks.Conveyor, 12),
                "IWI", "IRI", 'I', Items.iron_ingot, 'W', net.minecraft.init.Blocks.wool, 'R', net.minecraft.init.Blocks.redstone_block);

        GameRegistry.addRecipe(new ItemStack(com.modjam.terrifictransportation.Items.Technical.Items.CraftingComp, 1),
                " X ","X X", " X ", 'X', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(com.modjam.terrifictransportation.Items.Technical.Items.CraftingComp, 1, 3),
                "X","X", 'X', Items.iron_ingot);


    }
}
