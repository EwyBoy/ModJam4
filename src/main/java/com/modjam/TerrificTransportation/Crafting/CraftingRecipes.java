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
        GameRegistry.addRecipe(new ItemStack(Blocks.Conveyor, 12), "IWI", "IRI", 'I', Items.iron_ingot, 'W', net.minecraft.init.Blocks.wool, 'R', net.minecraft.init.Blocks.redstone_block);
    }
}
