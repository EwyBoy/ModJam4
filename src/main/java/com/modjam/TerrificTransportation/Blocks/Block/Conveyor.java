package com.modjam.TerrificTransportation.Blocks.Block;

import com.modjam.TerrificTransportation.Blocks.Technical.BlockInfo;
import com.modjam.TerrificTransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.TerrificTransportation.Texture.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.lang.Override;

public class Conveyor extends Block {

    public Conveyor() {
        super(Material.iron);
        setHardness(1F);
        setCreativeTab(TTCreativeTabs.ClockworkBlockTab);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {

        double entitySpeed = 0.025;
        double entitySticker = 0.01;
        int meta = world.getBlockMetadata(x, y, z);
        int xAxis[] = {0,1,0,-1};
        int zAxis[] = {-1,0,1,0};
        double X = entity.posX;
        double Z = entity.posZ;

        if (xAxis[meta] == 0 & Math.abs(x + 0.5 - entity.posX) < 0.5 & Math.abs(x + 0.5 - entity.posX) > 0.1) {
            entity.motionX += Math.signum(x + 0.5 - entity.posX) * Math.min(entitySpeed, Math.abs(x + 0.5 - entity.posX)) / 1.2;
        }

        if (zAxis[meta] == 0 & Math.abs(x + 0.5 - entity.posZ) < 0.5 & Math.abs(x + 0.5 - entity.posZ) > 0.1 ) {
            entity.motionZ += Math.signum(x + 0.5 - entity.posZ) * Math.min(entitySpeed, Math.abs(x + 0.5 - entity.posZ)) / 1.2;
        }

        entity.addVelocity(0, entitySticker, 0 /*entitySpeed*/);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return BlockInfo.ConveyorRenderID;
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0F, 0F, 0F, 1F, 0.35F, 1F);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        setBlockBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, start, end);
    }

    @SideOnly(Side.CLIENT)
    private IIcon TextureTop;

    @SideOnly(Side.CLIENT)
    private IIcon TextureSide;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        TextureSide = register.registerIcon(TextureHandler.texturePath + ":" + BlockInfo.ConveyorTextureSides);
        TextureTop = register.registerIcon(TextureHandler.texturePath + ":" + BlockInfo.ConveyorTextureTop);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side , int meta) {

        if (side == 1)
        {
            return TextureTop;
        }
        else if (side == 0)
        {
            return TextureSide;
        }
        return TextureSide;
    }
@Override
    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ){
if(world.getBlock(x, y, z) instanceof this){
if(world.gett)
    }

}
}
