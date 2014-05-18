package themike.artifacts.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialTransparent;

public class MaterialFakeAir extends Material {

	public MaterialFakeAir() {
		super(MapColor.airColor);
	}
	
	@Override
	public boolean isReplaceable() {
		return false;
	}

}
