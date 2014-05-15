package com.modjam.TerrificTransportation.Render;

import com.modjam.TerrificTransportation.Blocks.Technical.Blocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class ConveyorRenderer implements ISimpleBlockRenderingHandler {

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

    public static void standerConveyorShapeZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

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

    public static void standerConveyorShapeX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

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

    public static void splitConveyorShape(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        block.setBlockBounds(0F, 0F, 0F, 0.10F, 0.25F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator.instance.setColorOpaque_F(1F, 1F, 1F);

        if (world.getBlock(x + 2, y, z) == Blocks.Conveyor) {

            standerConveyorShapeX(world, x, y, z, block, modelId, renderer);

        } else {
            standerConveyorShapeZ(world, x, y, z, block, modelId, renderer);
        }

       /** if (world.getBlock(x + 1, y, z) == Blocks.Conveyor && world.getBlock(x, y, z + 1) == Blocks.Conveyor
          && world.getBlock(x - 1, y, z) == Blocks.Conveyor && world.getBlock(x, y, z - 1) == Blocks.Conveyor) {

            block.setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y ,z); */


        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return ID;
    }
}
