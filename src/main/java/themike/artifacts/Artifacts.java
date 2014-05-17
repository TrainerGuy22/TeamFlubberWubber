package themike.artifacts;

import net.minecraft.creativetab.CreativeTabs;
import themike.artifacts.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "artifacts", name = "Artifacts", version = "ModJam version")
public class Artifacts {
	
	@Instance("artifacts")
	public static Artifacts instance;
	
	@SidedProxy(clientSide = "themike.artifacts.client.ClientProxy", serverSide = "themike.artifacts.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs creative_tab = new ArtifactsTab(); 
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.init();
	}
	
}
