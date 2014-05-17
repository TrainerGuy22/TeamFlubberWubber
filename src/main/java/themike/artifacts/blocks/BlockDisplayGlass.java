package themike.artifacts.blocks;

import themike.artifacts.Artifacts;
import themike.artifacts.entities.EntityStoneGolem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockDisplayGlass extends BlockGlass {

	public BlockDisplayGlass() {
		super(Material.ice, false);
		this.setResistance(-1);
		this.setHardness(-1);
		this.setCreativeTab(Artifacts.creative_tab);
		this.setBlockName("display_glass");
		GameRegistry.registerBlock(this, "display_glass");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister renderer) {
		this.blockIcon = renderer.registerIcon("glass");
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		EntityStoneGolem golem = new EntityStoneGolem(world);
		golem.setPosition(x, y + 1, z);
		world.spawnEntityInWorld(golem);
	}

}
