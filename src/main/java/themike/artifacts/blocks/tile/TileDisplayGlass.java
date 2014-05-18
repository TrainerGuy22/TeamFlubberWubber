package themike.artifacts.blocks.tile;

import java.util.List;

import themike.artifacts.common.CommonProxy;
import themike.artifacts.entities.EntityStoneGolem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileDisplayGlass extends TileEntity {
	
	public int artifactMetadata = 2;
	public boolean isActivated;
	public int cooldown = 0;
	
	public TileDisplayGlass() {
	}
	
	public void updateEntity() {
		if(cooldown != 0)
			cooldown--;
		
		if(isActivated && cooldown == 0) {
			int x = this.xCoord;
			int y = this.yCoord;
			int z = this.zCoord;
			
			AxisAlignedBB range = AxisAlignedBB.getBoundingBox(x - 3, y - 1, z - 3, x + 7, y + 4, z + 4);
			List<EntityStoneGolem> golems = this.worldObj.getEntitiesWithinAABB(EntityStoneGolem.class, range);
			if(golems.size() == 0) {
				isActivated = false;
				onBreak();
			}
		}
	}
	
	public void onActivated() {
		if(!isActivated && !worldObj.isRemote) {
			
			worldObj.setBlock(xCoord + 6, yCoord, zCoord, Blocks.air);
			worldObj.setBlock(xCoord + 6, yCoord + 1, zCoord, Blocks.air);
			worldObj.setBlock(xCoord + 6, yCoord - 1, zCoord, Blocks.air);
			
			worldObj.setBlock(xCoord + 6, yCoord, zCoord - 1, Blocks.air);
			worldObj.setBlock(xCoord + 6, yCoord - 1, zCoord - 1, Blocks.air);
			
			worldObj.setBlock(xCoord + 6, yCoord, zCoord + 1, Blocks.air);
			worldObj.setBlock(xCoord + 6, yCoord - 1, zCoord + 1, Blocks.air);
			
			EntityStoneGolem golem = new EntityStoneGolem(worldObj);
			golem.setLocationAndAngles(xCoord + 5, yCoord - 1, zCoord, 0.0f, 0.0f);
			((EntityLiving) golem).onSpawnWithEgg((IEntityLivingData) null);
			worldObj.spawnEntityInWorld(golem);
		}
		isActivated = true;
		cooldown = 5;
	}
	
	private void replaceBlock(World world, int x, int y, int z, Block replacement) {
		world.setBlock(x, y, z, replacement, world.getBlockMetadata(x, y, z), 3);
	}
	
	public void onBreak() {
		if(worldObj.isRemote)
			return;
		
		EntityItem item = new EntityItem(worldObj, xCoord + 0.5d, yCoord + 0.5d, zCoord + 0.5d, new ItemStack(CommonProxy.artifact, 1, artifactMetadata));
		this.worldObj.spawnEntityInWorld(item);
		this.worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
				
		for(int countX = xCoord - 3; countX != xCoord + 6; countX++) {
			for(int countZ = zCoord - 3; countZ != zCoord + 4; countZ++) {
				worldObj.setBlock(countX, y - 2, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
				worldObj.setBlock(countX, y + 4, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
			}
		}		
		
		worldObj.setBlock(x - 1, y - 2, z - 1, Blocks.glowstone, 0, 1);
		worldObj.setBlock(x - 1, y - 2, z + 1, Blocks.glowstone, 0, 1);
		worldObj.setBlock(x + 1, y - 2, z - 1, Blocks.glowstone, 0, 1);
		worldObj.setBlock(x + 1, y - 2, z + 1, Blocks.glowstone, 0, 1);
		
		for(int countZ = z - 3; countZ != z + 4; countZ++) {
			for(int countY = y - 1; countY != y + 4; countY++) {
				worldObj.setBlock(x - 4, countY, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
				worldObj.setBlock(x + 6, countY, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
			}
		}
		
		for(int countX = x - 3; countX != x + 6; countX++) {
			for(int countY = y - 1; countY != y + 4; countY++) {
				worldObj.setBlock(countX, countY, z - 4, CommonProxy.fake_stone, random.nextInt(3), 3);
				worldObj.setBlock(countX, countY, z + 4, CommonProxy.fake_stone, random.nextInt(3), 3);
			}
		}
		
		worldObj.setBlock(x + 7, y, z, Blocks.glowstone, 0, 1);
		worldObj.setBlock(x + 7, y + 1, z, CommonProxy.fake_stone, random.nextInt(3), 3);
		worldObj.setBlock(x + 7, y - 1, z, Blocks.glowstone, 0, 1);
		
		worldObj.setBlock(x + 7, y, z - 1, CommonProxy.fake_stone, random.nextInt(3), 3);
		worldObj.setBlock(x + 7, y - 1, z - 1, CommonProxy.fake_stone, random.nextInt(3), 3);
		
		worldObj.setBlock(x + 7, y, z + 1, CommonProxy.fake_stone, random.nextInt(3), 3);
		worldObj.setBlock(x + 7, y - 1, z + 1, CommonProxy.fake_stone, random.nextInt(3), 3);
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
