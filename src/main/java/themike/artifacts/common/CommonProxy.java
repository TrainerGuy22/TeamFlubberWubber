package themike.artifacts.common;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.registry.EntityRegistry;
import themike.artifacts.Artifacts;
import themike.artifacts.entities.EntityStoneGolem;
import themike.artifacts.items.ItemArtifact;
import net.minecraft.item.Item;

public class CommonProxy {
	
	public static Item artifact;
	
	public void init() {
		artifact = new ItemArtifact();
		EntityRegistry.registerModEntity(EntityStoneGolem.class, "StoneGolem", 0, Artifacts.instance, 80, 3, false);
	}

}
