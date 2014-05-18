package themike.artifacts.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockFakeStone extends Block {
	
	public BlockFakeStone() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setBlockName("fake_stone");
		this.setResistance(-1);
		GameRegistry.registerBlock(this, "fake_stone");
	}
	
	public IIcon getIcon(int side, int meta) {
		return Blocks.stonebrick.getIcon(side, meta);
	}

}
