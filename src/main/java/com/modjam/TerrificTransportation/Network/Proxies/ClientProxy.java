package com.modjam.terrifictransportation.Network.Proxies;

import com.modjam.terrifictransportation.Blocks.Technical.BlockInfo;
import com.modjam.terrifictransportation.Render.ConveyorRenderer;
import com.modjam.terrifictransportation.Render.ConveyorRendererX;
import com.modjam.terrifictransportation.Render.RouterRender;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public void initRenders() {

        ConveyorRenderer conveyorRenderer = new ConveyorRenderer();
        RenderingRegistry.registerBlockHandler(conveyorRenderer);
        BlockInfo.ConveyorRenderID = conveyorRenderer.getRenderId();

        ConveyorRendererX conveyorRendererX = new ConveyorRendererX();
        RenderingRegistry.registerBlockHandler(conveyorRendererX);
        BlockInfo.ConveyorRenderXID = conveyorRendererX.getRenderId();

        RouterRender routerRender = new RouterRender();
        RenderingRegistry.registerBlockHandler(routerRender);
        BlockInfo.RouterRenderID = routerRender.getRenderId();
    }

}
