package themike.artifacts.items;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import themike.artifacts.Artifacts;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemArtifact extends Item {
	
	public ItemArtifact() {
		super();
		this.setUnlocalizedName("artifact");
		this.setCreativeTab(Artifacts.creative_tab);
		GameRegistry.registerItem(this, "artifact");
		this.hasSubtypes = true;
	}
	
	@Override
	public void registerIcons(IIconRegister renderer) {
		this.itemIcon = renderer.registerIcon("artifacts:artifact");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean dunno) {
		// Geeky reference. Carry on.
		list.add("A rare artifact, from");
		list.add("a more civilized age.");
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List subItems) {
		for(int count = 0; count < 8; count++) {
			subItems.add(new ItemStack(item, 1, count));
		}
	}

}
