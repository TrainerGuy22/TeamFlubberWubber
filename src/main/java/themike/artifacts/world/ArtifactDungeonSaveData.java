package themike.artifacts.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class ArtifactDungeonSaveData extends WorldSavedData {
	
	public static Integer[] artifacts = new Integer[8];

	public ArtifactDungeonSaveData(String par1Str) {
		super("artifact_dungeon");
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		
	}

}
