package themike.artifacts.client.items;

import org.lwjgl.opengl.GL11;

import themike.artifacts.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ArtifactItemRenderer implements IItemRenderer {
	
	public RenderItem renderer = new RenderItem();
	
	public ArtifactItemRenderer() {
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("artifacts", "artifact"));
		renderer.renderIcon(0, 0, CommonProxy.artifact.getIconFromDamage(0), 16, 16);
	}

}
