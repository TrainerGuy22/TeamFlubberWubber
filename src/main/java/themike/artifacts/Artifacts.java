package themike.artifacts;

import themike.artifacts.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "artifacts", name = "Artifacts", version = "ModJam version")
public class Artifacts {
	
	@SidedProxy(clientSide = "themike.artifacts.client.ClientProxy", serverSide = "themike.artifacts.common.CommonProxy")
	public CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.init();
	}
	
}
