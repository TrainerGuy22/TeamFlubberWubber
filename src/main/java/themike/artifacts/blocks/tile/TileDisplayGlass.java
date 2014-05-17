package themike.artifacts.blocks.tile;

import java.util.List;

import themike.artifacts.entities.EntityStoneGolem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileDisplayGlass extends TileEntity {
	
	public int artifactMetadata;
	public boolean isActivated;
	
	public TileDisplayGlass() {
	}
	
	public void updateEntity() {
		if(isActivated) {
			int x = this.xCoord;
			int y = this.yCoord;
			int z = this.zCoord;
			
			AxisAlignedBB range = AxisAlignedBB.getBoundingBox(x - 3, y - 1, z - 5, x + 6, y + 5, z + 4);
			List<EntityStoneGolem> golems = this.worldObj.getEntitiesWithinAABB(EntityStoneGolem.class, range);
		}
	}
	
	public void onActivated() {
		
	}
	
	public void onBreak() {
		
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
