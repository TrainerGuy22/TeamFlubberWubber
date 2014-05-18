package themike.artifacts.items;

import java.util.List;

import themike.artifacts.Artifacts;
import themike.artifacts.common.CommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemShimmeringStar extends Item {
	
	public ItemShimmeringStar() {
		super();
		this.setUnlocalizedName("shimmering_star");
		this.setCreativeTab(Artifacts.creative_tab);
		GameRegistry.registerItem(this, "shimmering_star");
		GameRegistry.addShapedRecipe(new ItemStack(this, 1), "123", "4x5", "678", 'x', Items.nether_star,
		'1', artifact(1), '2', artifact(2), '3', artifact(3), '4', artifact(4), '5', artifact(5), '6', artifact(6), '7', artifact(7), '8', artifact(8));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean dunno) {
		list.add("A radiant star, overflowing");
		list.add("with various enchantments.");
	}
	
	private ItemStack artifact(int meta) {
		return new ItemStack(CommonProxy.artifact, 1, meta - 1);
	}

}
