package themike.artifacts.items;

import themike.artifacts.Artifacts;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemArtifact extends Item {
	
	public ItemArtifact() {
		super();
		this.setUnlocalizedName("artifact");
		this.setCreativeTab(Artifacts.creative_tab);
	}
	
	@Override
	public void registerIcons(IIconRegister renderer) {
		this.itemIcon = renderer.registerIcon("artifacts:artifact");
	}

}
