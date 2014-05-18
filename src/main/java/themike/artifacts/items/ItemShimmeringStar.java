package themike.artifacts.items;

import java.util.List;

import themike.artifacts.Artifacts;
import themike.artifacts.common.CommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemShimmeringStar extends Item {
	
	private Potion[] potions = new Potion[]{
		Potion.moveSpeed,
		Potion.damageBoost,
		Potion.jump
	};
	
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
		list.add("Gives you various potion effects.");
	}
	
	private ItemStack artifact(int meta) {
		return new ItemStack(CommonProxy.artifact, 1, meta - 1);
	}
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int whocares1, boolean whocares2) {
		if(!(entity instanceof EntityPlayer))
			return;
		EntityPlayer player = (EntityPlayer) entity;
		if(stack.getTagCompound() == null) {
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setInteger("cooldown", 0);
		} else {
			stack.getTagCompound().setInteger("cooldown", stack.getTagCompound().getInteger("cooldown") - 1);
		}
		if(stack.getTagCompound().getInteger("cooldown") == 0) {
			for(Potion potion : potions) {
				player.addPotionEffect(new PotionEffect(potion.id, 480));
			}
			stack.getTagCompound().setInteger("cooldown", 480);
		}
	}


}
