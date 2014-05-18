package com.modjam.terrifictransportation.Render;


import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.tileentitys.ConveyorTile;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ConveyorRenderer extends TileEntitySpecialRenderer {

    private int ID;

    public ConveyorRenderer () {
        ID = RenderingRegistry.getNextAvailableRenderId();
    }

        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float idk) {
            GL11.glPushMatrix();
            
            GL11.glTranslatef((float)x, (float)y, (float)z);
            ConveyorTile tileEntityYour = (ConveyorTile)tileEntity;
         
            renderConveyor(tileEntityYour, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, Blocks.Conveyor);
            GL11.glPopMatrix();
        }
    
      
        public void renderConveyor(ConveyorTile tl, World world, int i, int j, int k, Block block) {
            Tessellator tessellator = Tessellator.instance;
           
            float f = block.getAmbientOcclusionLightValue();
            int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int l1 = l % 65536;
            int l2 = l / 65536;
            tessellator.setColorOpaque_F(f, f, f);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2);

        

            int dir = world.getBlockMetadata(i, j, k);

            GL11.glPushMatrix();
            GL11.glTranslatef(0.5F, 0, 0.5F);
           
            GL11.glRotatef(dir * (-90F), 0F, 1F, 0F);
            GL11.glTranslatef(-0.5F, 0, -0.5F);
            
        

            GL11.glPopMatrix();
        }
    
}