package themike.artifacts.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockFakeAir extends Block {

	public BlockFakeAir() {
		super(new MaterialFakeAir());
		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
		GameRegistry.registerBlock(this, "fake_air");	
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
		if(x + 1 < entity.posX && entity.prevPosX > entity.posX)
			super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
	}
	
	@Override
    public int getRenderType() {
        return -1;
    }
	
}
