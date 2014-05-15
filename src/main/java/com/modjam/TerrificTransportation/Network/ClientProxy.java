package com.modjam.terrifictransportation.Network;

import com.modjam.terrifictransportation.Blocks.Technical.BlockInfo;
import com.modjam.terrifictransportation.Render.ConveyorRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public void initRenders() {

        ConveyorRenderer conveyorRenderer = new ConveyorRenderer();
        RenderingRegistry.registerBlockHandler(conveyorRenderer);
        BlockInfo.ConveyorRenderID = conveyorRenderer.getRenderId();
    }

}
