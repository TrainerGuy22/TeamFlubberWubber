package themike.artifacts.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFakeAir extends Block {

	public BlockFakeAir() {
		super(Material.air);
		this.setBlockUnbreakable();
		this.setResistance(-1);
		GameRegistry.registerBlock(this, "fake_air");	
	}

}
