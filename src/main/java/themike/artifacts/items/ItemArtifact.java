package themike.artifacts.items;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import themike.artifacts.Artifacts;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemArtifact extends Item {
	
	public static String[] colors = new String[]{"A3BBF4", "FF000", "1900FF", "00751D", "FFF700", "FFBB00", "FF00FF", "00FF22"};
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
		return Integer.parseInt(colors[stack.getItemDamage()], 16);
	}

}
