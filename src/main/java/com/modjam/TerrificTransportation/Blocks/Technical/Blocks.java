package com.modjam.terrifictransportation.Blocks.Technical;

import com.modjam.terrifictransportation.Blocks.Block.Conveyor;
import com.modjam.terrifictransportation.Blocks.Block.Router;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Blocks {

    public static Block Conveyor;
    public static Block Router;

    public static void init() {
        registerBlocks();
    }

    public static void registerBlocks() {

        Conveyor = new Conveyor().setBlockName(BlockInfo.ConveyorBlockName);
        GameRegistry.registerBlock(Conveyor, BlockInfo.ConveyorKey);

        Router = new com.modjam.terrifictransportation.Blocks.Block.Router().setBlockName(BlockInfo.RouterBlockName);
        GameRegistry.registerBlock(Router, BlockInfo.RouterKey);
    }
}
