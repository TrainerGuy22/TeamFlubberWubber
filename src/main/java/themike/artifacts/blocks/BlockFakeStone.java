package themike.artifacts.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFakeStone extends Block {

	protected BlockFakeStone() {
		super(Material.air);
		this.setBlockUnbreakable();
		this.setBlockName("fake_stone");
		this.setResistance(-1);
	}
	
	

}
