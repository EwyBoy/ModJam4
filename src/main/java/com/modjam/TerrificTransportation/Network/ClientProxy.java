package com.modjam.TerrificTransportation.Network;

import com.modjam.TerrificTransportation.Blocks.Technical.BlockInfo;
import com.modjam.TerrificTransportation.Render.ConveyorRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public void initRenders() {

        ConveyorRenderer conveyorRenderer = new ConveyorRenderer();
        RenderingRegistry.registerBlockHandler(conveyorRenderer);
        BlockInfo.ConveyorRenderID = conveyorRenderer.getRenderId();
    }

}
