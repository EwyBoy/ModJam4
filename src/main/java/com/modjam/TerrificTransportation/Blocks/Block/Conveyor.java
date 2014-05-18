package com.modjam.terrifictransportation.Blocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.modjam.terrifictransportation.Blocks.Technical.BlockInfo;
import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Items.Item.Modules;
import com.modjam.terrifictransportation.Items.Item.Wrench;
import com.modjam.terrifictransportation.Texture.TextureHandler;
import com.modjam.terrifictransportation.tileentitys.ConveyorTile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class Conveyor extends BlockContainer {

    public Conveyor() {
        super(Material.iron);
        setHardness(1F);
        setCreativeTab(TTCreativeTabs.ClockworkBlockTab);
    }
   
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
	ConveyorTile cd = (ConveyorTile) world.getTileEntity(x, y, z);
	if(cd.installedModules.contains(com.modjam.terrifictransportation.util.Modules.SPEED)){
		
	}
}
        double entitySpeed = 0.025;
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

        if (!entity.isSneaking()) {

            if (world.getBlock(x, y - 1, z) == Blocks.ice || (world.getBlock(x, y - 1, z) == Blocks.packed_ice ||(world.getBlock(x, y - 1, z) == Blocks.soul_sand ))) {
                entity.addVelocity(0,0,0);
            } else {
                entity.addVelocity(0, 0, -entitySpeed);
                entity.stepHeight = 1F;
            }
        }
        if(entity instanceof EntityItem){
        
        	EntityItem et = (EntityItem) entity;
        if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
        	
        	ConveyorTile c = (ConveyorTile) world.getTileEntity(x, y, z);
        	if(c.getConveyorType() == "Import Mode"){
        		
        		Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;
        		if(world.getTileEntity(x, y, z -1) instanceof IInventory || world.getBlock(x, y, z) == router){
        			IInventory inv = (IInventory) world.getTileEntity(x, y, z -1);
        			
        			
        		for(int i = 0; i < inv.getSizeInventory(); i++){
        			if(inv.getStackInSlot(i) == null){
        				inv.setInventorySlotContents(i, et.getEntityItem());
        				entity.setDead();
        				
        				return;
        			}else{
        			}
        		}
        		}
        	}
        	
        }
        }
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
        return BlockInfo.ConveyorRenderXID;
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
    private IIcon TextureSideX;
    private IIcon TextureSideZ;
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        TextureSideX = register.registerIcon(TextureHandler.texturePath + ":" + BlockInfo.ConveyorTextureSidesX);
        TextureSideZ = register.registerIcon(TextureHandler.texturePath + ":" + BlockInfo.ConveyorTextureSidesZ);
        TextureTop = register.registerIcon(TextureHandler.texturePath + ":" + BlockInfo.ConveyorTextureTop);
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
   if(!world.isRemote){
    	Item equipped = entityplayer.getCurrentEquippedItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
    if (equipped instanceof Wrench){

    	Wrench c = (Wrench) equipped;
    	if(c.getWrenchTypeID() == 2){
    		
    	if(world.getTileEntity(x, y, z) instanceof ConveyorTile){

    		ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    		cs.changeConveyor(world, entityplayer);
    		entityplayer.addChatComponentMessage(new ChatComponentText("This Conveyor is now set to " + cs.getConveyorType()));
    	}
    	}
    }else{
    	
    }
    if(equipped instanceof com.modjam.terrifictransportation.Items.Item.Modules){
    	com.modjam.terrifictransportation.Items.Item.Modules module = (Modules) equipped;
    	ItemStack m = entityplayer.getCurrentEquippedItem();
    	if(module.getDamage(m) == 0){
    		if(world.getTileEntity(x, y, z) instanceof ConveyorTile){

        		ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    		if(cs.installedModules.size() == 3){
    			entityplayer.addChatMessage(new ChatComponentText("This Conveyor has no more Space!"));
    		}else{
    			cs.installedModules.add(com.modjam.terrifictransportation.util.Modules.SPEED);
    		}
    		}
    	}
    }
    }
	return true;
    
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side , int meta) {
        if(side == 1) {
           return TextureTop;
        }
        if (side == 4) {
            return TextureSideX;
        }
        if (side == 5) {
            return TextureSideX;
        }
        return TextureSideZ;
    }
@Override
    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ){
if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
	ConveyorTile c = (ConveyorTile) world.getTileEntity(x, y, z);
	if(c.getConveyorTypeID() == 2){
		Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;
		if(world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z) == router)){
			IInventory inv = (IInventory) world.getTileEntity(x, y, z + 1);
			
			
		for(int i = 0; i < inv.getSizeInventory(); i++){
			if(inv.getStackInSlot(i) == null){
				
			}else{
				world.getTileEntity(x, y, z +1).getWorldObj().spawnEntityInWorld(new EntityItem(world.getTileEntity(x, y, z + 1).getWorldObj(), x +1, y, z, inv.getStackInSlot(i).copy()));
				inv.setInventorySlotContents(i, null);
				
				
			}
		}
		}
	}
	
}
}

@Override
public TileEntity createNewTileEntity(World var1, int var2) {
	// TODO Auto-generated method stub
	return new ConveyorTile();
}
		

	@Override 
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item){
		 Block block = world.getBlock(x, y, z - 1);
	        Block block1 = world.getBlock(x, y, z + 1);
	        Block block2 = world.getBlock(x - 1, y, z);
	        Block block3 = world.getBlock(x + 1, y, z);
	        byte b0 = 0;
	        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            b0 = 2;
	        }

	        if (l == 1)
	        {
	            b0 = 5;
	        }

	        if (l == 2)
	        {
	            b0 = 3;
	        }

	        if (l == 3)
	        {
	            b0 = 4;
	        }

	        if (block != this && block1 != this && block2 != this && block3 != this)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	        }
	        else
	        {
	            if ((block == this || block1 == this) && (b0 == 4 || b0 == 5))
	            {
	                if (block == this)
	                {
	                    world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
	                }
	                else
	                {
	                    world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
	                }

	                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	            }

	            if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3))
	            {
	                if (block2 == this)
	                {
	                    world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
	                }
	                else
	                {
	                    world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
	                }

	                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	            }
	        }

	        
	}



}
