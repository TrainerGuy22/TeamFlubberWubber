package themike.artifacts.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.MinecraftForgeClient;
import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.client.entity.RenderStoneGolem;
import themike.artifacts.client.render.DisplayGlassRenderer;
import themike.artifacts.common.CommonProxy;
import themike.artifacts.entities.EntityStoneGolem;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	@SideOnly(Side.CLIENT)
	public void init() {
		super.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneGolem.class, new RenderStoneGolem());
		// ClientRegistry.bindTileEntitySpecialRenderer(TileDisplayGlass.class, new DisplayGlassRenderer());
	}

}
