package themike.artifacts.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockFakeStone extends Block {
	
	public BlockFakeStone() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setBlockName("fake_stone");
		this.setResistance(-1);
		GameRegistry.registerBlock(this, "fake_stone");
	}
	
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if(world.getBlockMetadata(x, y, z) == 3) 
			return 15;
		else
			return 0;
	}
	
	public IIcon getIcon(int side, int meta) {
		if(meta == 3)
			return Blocks.glowstone.getIcon(side, meta);
		else
			return Blocks.stonebrick.getIcon(side, meta);
	}

}
