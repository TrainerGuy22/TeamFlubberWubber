package themike.artifacts.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFakeAir extends Block {

	public BlockFakeAir() {
		super(new MaterialFakeAir());
		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
		GameRegistry.registerBlock(this, "fake_air");	
	}

}
