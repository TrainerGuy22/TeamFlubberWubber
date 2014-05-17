package themike.artifacts;

import themike.artifacts.common.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArtifactsTab extends CreativeTabs {

	public ArtifactsTab() {
		super("artifacts");
	}

	@Override
	public Item getTabIconItem() {
		return CommonProxy.artifact;
	}

}
