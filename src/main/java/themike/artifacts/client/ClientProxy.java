package themike.artifacts.client;

import net.minecraftforge.client.MinecraftForgeClient;
import themike.artifacts.client.items.ArtifactItemRenderer;
import themike.artifacts.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init() {
		super.init();
		MinecraftForgeClient.registerItemRenderer(CommonProxy.artifact, new ArtifactItemRenderer());
	}

}
