package themike.artifacts.blocks.tile;

import java.util.List;

import themike.artifacts.common.CommonProxy;
import themike.artifacts.entities.EntityStoneGolem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileDisplayGlass extends TileEntity {
	
	public int artifactMetadata = 2;
	public boolean isActivated;
	
	public TileDisplayGlass() {
	}
	
	public void updateEntity() {
		if(isActivated) {
			int x = this.xCoord;
			int y = this.yCoord;
			int z = this.zCoord;
			
			AxisAlignedBB range = AxisAlignedBB.getBoundingBox(x - 3, y - 1, z - 3, x + 7, y + 4, z + 4);
			List<EntityStoneGolem> golems = this.worldObj.getEntitiesWithinAABB(EntityStoneGolem.class, range);
			if(golems == null) {
				isActivated = false;
				onBreak();
			}
		}
	}
	
	public void onActivated() {
		if(!isActivated && !worldObj.isRemote) {
			EntityStoneGolem golem = new EntityStoneGolem(worldObj);
			golem.setLocationAndAngles(xCoord, yCoord + 1, zCoord, 0.0f, 0.0f);
			((EntityLiving) golem).onSpawnWithEgg((IEntityLivingData) null);
			worldObj.spawnEntityInWorld(golem);
		}
		isActivated = true;
	}
	
	public void onBreak() {
		EntityItem item = new EntityItem(worldObj, xCoord + 0.5d, yCoord + 0.5d, zCoord + 0.5d, new ItemStack(CommonProxy.artifact, 1, artifactMetadata));
		this.worldObj.spawnEntityInWorld(item);
		
		this.blockType.onBlockDestroyedByPlayer(worldObj, xCoord, yCoord, zCoord, this.blockMetadata);
		this.worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("artifactMetadata", this.artifactMetadata);
		tag.setBoolean("isActivated", isActivated);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.artifactMetadata = tag.getInteger("artifactMetadata");
		this.isActivated = tag.getBoolean("isActivated");
	}

}
