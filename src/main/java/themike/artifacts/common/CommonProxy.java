package themike.artifacts.common;

import java.util.HashMap;
import java.util.Map;

import themike.artifacts.items.ItemArtifact;
import net.minecraft.item.Item;

public class CommonProxy {
	
	public static Item artifact;
	
	public void init() {
		artifact = new ItemArtifact();
	}

}
