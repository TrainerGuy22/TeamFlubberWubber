package themike.artifacts.client.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.common.CommonProxy;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

@SideOnly(Side.CLIENT)
public class DisplayGlassRenderer extends TileEntitySpecialRenderer {
	
	public DisplayGlassRenderer() {
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double d0, double d1, double d2, float f) {
		EntityItem item = new EntityItem(tile.getWorldObj(), d0, d1, d2, new ItemStack(CommonProxy.artifact, 1, ((TileDisplayGlass) tile).artifactMetadata));
		(new RenderItem()).doRender(item, d0, d1, d2, f, 0.1f);
		GL11.glPopMatrix();
	}

}
