package com.modjam.terrifictransportation.Render;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ConveyorRenderer extends TileEntitySpecialRenderer {

    private int ID;

    public ConveyorRenderer () {
        ID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);

        GL11.glPushMatrix();

        GL11.glRotatef(90, 0, 1, 0);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads(); // Tell it to draw a new thing
        tessellator.setNormal(0.0F, -1.0F, 0.0F); //Direction to render stuff, like a dize -1 = bot
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata)); //block, pos, texture
        tessellator.draw();  //Finish draw

        tessellator.startDrawingQuads();
        tessellator.setNormal(0F, 1F, 0F);
        renderer.renderFaceYPos(block, 0, 0, 0, block.getIcon(1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();

        GL11.glPopMatrix();
    }

    private void conveyorDirZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
            
        block.setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0F, 0F, 0F, 0.10F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0.90F, 0F, 0F, 1F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void conveyorDirX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Right
        block.setBlockBounds(0F, 0F, 0.9F, 1F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Left
        block.setBlockBounds(0F, 0F, 0F, 1F, 0.25F, 0.10F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void conveyorInventoryConnectPosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        //top
        block.setBlockBounds(0F, 0.75F, 0.5F, 1F, 0.85F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //left
        block.setBlockBounds(0F, 0.75F, 1F, 0.10F, 0.25F, 0.5F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //right
        block.setBlockBounds(0.90F, 0.75F, 1F, 1F, 0.25F, 0.5F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void conveyorInventoryConnectNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        //top
        block.setBlockBounds(0F, 0.75F, 0F, 1F, 0.85F, 0.5F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //left
        block.setBlockBounds(0.90F, 0.75F, 0.5F, 1F, 0.25F, 0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //right
        block.setBlockBounds(0F, 0.75F, 0.5F, 0.10F, 0.25F, 0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void conveyorOverInventory(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 0.25F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0F, 0F, 0F, 0.25F, 0.15F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0F, 0F, 0.75F, 1F, 0.15F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0.75F, 0F, 0F, 1F, 0.15F, 1);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0F, 0F, 0F, 0.10F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0.90F, 0F, 0F, 1F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }


    

	@Override
	public void renderTileEntityAt(TileEntity var1, double d, double b,
			double a, float var8) {
		World world = var1.getWorldObj();
		int x = var1.xCoord;
		int y = var1.yCoord;
		int z = var1.zCoord;
		 Tessellator.instance.setColorOpaque_F(1F, 1F, 1F);
	        Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;

	        GL11.glPushMatrix();
	             
	        if (world.getTileEntity(x, y - 1, z) instanceof TileEntityHopper || (world.getBlock(x, y - 1, z) == router)) {
	            conveyorOverInventory(world, x, y, z, block, modelId, renderer);
	            if (world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z + 1) == router)) {
	                conveyorInventoryConnectPosZ(world, x, y, z, block, modelId, renderer);
	            }
	            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x, y, z - 1) == router)) {
	                conveyorInventoryConnectNegZ(world, x, y, z, block, modelId, renderer);
	            }
	            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x,y,z - 1) == router &&
	                    (world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x,y,z + 1) == router)))) {
	                conveyorDirZ(world, x, y, z, block, modelId, renderer);
	            }
	        } else  {
	            conveyorDirZ(world, x, y, z, block, modelId, renderer);

	            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x,y,z - 1) == router &&
	                    (world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x,y,z + 1) == router)))) {
	                conveyorDirZ(world, x, y, z, block, modelId, renderer);
	            } else {

	                if (world.getTileEntity(x, y - 1, z) instanceof TileEntityHopper  && world.getTileEntity(x, y, z + 1) instanceof IInventory
	                        || (world.getBlock(x, y, z + 1) == router)) {
	                    conveyorInventoryConnectPosZ(world, x, y, z, block, modelId, renderer);
	                }
	                if(world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z + 1) == router)) {
	                    conveyorInventoryConnectPosZ(world, x, y, z, block, modelId, renderer);
	                }
	                if (world.getTileEntity(x, y - 1, z) instanceof TileEntityHopper  && world.getTileEntity(x, y, z - 1) instanceof IInventory
	                        || (world.getBlock(x, y, z - 1) == router)) {
	                    conveyorInventoryConnectNegZ(world, x, y, z, block, modelId, renderer);
	                }
	                if(world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x, y, z - 1) == router)) {
	                    conveyorInventoryConnectNegZ(world, x, y, z, block, modelId, renderer);
	                }
	            }


	        }

	        GL11.glPopMatrix();

	       
		
	}
}
