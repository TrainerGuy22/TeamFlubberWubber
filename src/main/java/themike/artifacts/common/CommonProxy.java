package themike.artifacts.common;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import themike.artifacts.Artifacts;
import themike.artifacts.blocks.BlockDisplayGlass;
import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.entities.EntityStoneGolem;
import themike.artifacts.items.ItemArtifact;
import themike.artifacts.world.ArtifactDungeonSaveData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

public class CommonProxy {
	
	public static Item artifact;
	public static Block display_glass;
	
	public static ArtifactDungeonSaveData dungeon_world_data;
	
	public void init() {
		artifact = new ItemArtifact();
		display_glass = new BlockDisplayGlass();
		EntityRegistry.registerModEntity(EntityStoneGolem.class, "StoneGolem", 0, Artifacts.instance, 80, 3, false);
		GameRegistry.registerTileEntity(TileDisplayGlass.class, "display_glass");
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		ArtifactDungeonSaveData data = (ArtifactDungeonSaveData) event.world.mapStorage.loadData(ArtifactDungeonSaveData.class, "artifact_dungeon");
		
		if(data == null) {
			data = new ArtifactDungeonSaveData();
			event.world.mapStorage.setData("artifact_dungeon", data);
		}
		
		dungeon_world_data = data;
	}

}
