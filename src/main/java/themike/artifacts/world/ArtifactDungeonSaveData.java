package themike.artifacts.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class ArtifactDungeonSaveData extends WorldSavedData {
	
	public Integer[] artifacts = new Integer[]{0,0,0,0,0,0,0,0};

	public ArtifactDungeonSaveData() {
		super("artifact_dungeon");
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		for(int count = 0; count != artifacts.length; count++) {
			artifacts[count] = tag.getInteger("artifact" + count);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		for(int count = 0; count != artifacts.length; count++) {
			tag.setInteger("artifact" + count, artifacts[count]);
		}
	}

}
