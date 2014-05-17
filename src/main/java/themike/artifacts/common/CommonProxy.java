package themike.artifacts.common;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import themike.artifacts.Artifacts;
import themike.artifacts.blocks.BlockDisplayGlass;
import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.entities.EntityStoneGolem;
import themike.artifacts.items.ItemArtifact;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CommonProxy {
	
	public static Item artifact;
	public static Block display_glass;
	
	public void init() {
		artifact = new ItemArtifact();
		display_glass = new BlockDisplayGlass();
		EntityRegistry.registerModEntity(EntityStoneGolem.class, "StoneGolem", 0, Artifacts.instance, 80, 3, false);
		GameRegistry.registerTileEntity(TileDisplayGlass.class, "display_glass");
	}

}
