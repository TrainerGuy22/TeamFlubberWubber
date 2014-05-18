package themike.artifacts.blocks;

import themike.artifacts.Artifacts;
import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.common.CommonProxy;
import themike.artifacts.entities.EntityStoneGolem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDisplayGlass extends BlockGlass implements ITileEntityProvider {

	public BlockDisplayGlass() {
		super(Material.ice, false);
		this.setResistance(-1);
		this.setHardness(-1);
		this.setCreativeTab(Artifacts.creative_tab);
		this.setBlockName("display_glass");
		GameRegistry.registerBlock(this, "display_glass");
		this.isBlockContainer = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister renderer) {
		this.blockIcon = renderer.registerIcon("artifacts:display_glass");
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		super.onBlockDestroyedByPlayer(world, x, y, z, meta);
		this.dropBlockAsItem(world, x, y, z, new ItemStack(CommonProxy.artifact, 1, ((TileDisplayGlass) world.getTileEntity(x,  y, z)).blockMetadata));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		((TileDisplayGlass) world.getTileEntity(x,  y, z)).isActivated = true;
		if(world.isRemote)
			return true;
		
		EntityStoneGolem golem = new EntityStoneGolem(world);
		golem.setLocationAndAngles(x, y + 1, z, 0.0f, 0.0f);
		((EntityLiving) golem).onSpawnWithEgg((IEntityLivingData) null);
		world.spawnEntityInWorld(golem);
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileDisplayGlass();
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, Block block, int dunno) {
        super.breakBlock(world, x, y, z, block, dunno);
        world.removeTileEntity(x, y, z);
    }

}
