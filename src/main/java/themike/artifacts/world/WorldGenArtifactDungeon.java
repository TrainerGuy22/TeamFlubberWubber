package themike.artifacts.world;

import java.util.Random;

import themike.artifacts.blocks.tile.TileDisplayGlass;
import themike.artifacts.common.CommonProxy;
import themike.artifacts.util.Coord2;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenArtifactDungeon implements IWorldGenerator {
	
	public int artifactMetadata = 0;
	
	public WorldGenArtifactDungeon(int artifactMetadata) {
		this.artifactMetadata = artifactMetadata;
	}
	
	public boolean canSpawn(World world, int x, int y, int z) {
		if(CommonProxy.dungeon_world_data == null) {
			CommonProxy.dungeon_world_data = CommonProxy.loadWorldSaveData(world);
		}
		if(CommonProxy.dungeon_world_data.artifacts[artifactMetadata] == 1)
			return false;
		if(world.getBlock(x + 6, y - 2, z - 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x + 6, y - 2, z + 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x - 3, y - 2, z - 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x - 3, y - 2, z + 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x + 6, y + 5, z - 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x + 6, y + 5, z - 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x - 3, y + 5, z - 3).isAir(world, x + 6, y - 2, z - 3) ||
		   world.getBlock(x - 3, y + 5, z - 3).isAir(world, x + 6, y - 2, z - 3)) {
			return false;
		}
		return true;
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider generator, IChunkProvider provider) {
		if(world.provider.dimensionId != 0) {
			return;
		}
		
		// Stupid not random Random.
		Random random = new Random();
		
		ChunkCoordinates spawnCoords = world.getSpawnPoint();
		
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = 10 + random.nextInt(7);
		
		if(random.nextInt(70) == 4 && canSpawn(world, x, y, z)) {
			CommonProxy.dungeon_world_data.artifacts[artifactMetadata] = 1;
			
			for(int countX = x - 3; countX != x + 6; countX++) {
				for(int countZ = z - 3; countZ != z + 4; countZ++) {
					for(int countY = y - 1; countY != y + 4; countY++) {
						world.setBlock(countX, countY, countZ, Blocks.air);
					}
					world.setBlock(countX, y - 2, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
					world.setBlock(countX, y + 4, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
				}
			}
			
			world.setBlock(x, y, z, CommonProxy.display_glass);
			((TileDisplayGlass) world.getTileEntity(x, y, z)).artifactMetadata = this.artifactMetadata;
			
			world.setBlock(x, y - 1, z, Blocks.quartz_block, 2, 3);
			
			world.setBlock(x - 1, y - 2, z - 1, Blocks.glowstone, 0, 1);
			world.setBlock(x - 1, y - 2, z + 1, Blocks.glowstone, 0, 1);
			world.setBlock(x + 1, y - 2, z - 1, Blocks.glowstone, 0, 1);
			world.setBlock(x + 1, y - 2, z + 1, Blocks.glowstone, 0, 1);
			
			for(int countZ = z - 3; countZ != z + 4; countZ++) {
				for(int countY = y - 1; countY != y + 4; countY++) {
					world.setBlock(x - 4, countY, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
					world.setBlock(x + 6, countY, countZ, CommonProxy.fake_stone, random.nextInt(3), 3);
				}
			}
			
			for(int countX = x - 3; countX != x + 6; countX++) {
				for(int countY = y - 1; countY != y + 4; countY++) {
					world.setBlock(countX, countY, z - 4, CommonProxy.fake_stone, random.nextInt(3), 3);
					world.setBlock(countX, countY, z + 4, CommonProxy.fake_stone, random.nextInt(3), 3);
				}
			}
			
			world.setBlock(x + 7, y, z, Blocks.glowstone, 0, 1);
			world.setBlock(x + 7, y + 1, z, CommonProxy.fake_stone, random.nextInt(3), 3);
			world.setBlock(x + 7, y - 1, z, Blocks.glowstone, 0, 1);
			
			world.setBlock(x + 7, y, z - 1, CommonProxy.fake_stone, random.nextInt(3), 3);
			world.setBlock(x + 7, y - 1, z - 1, CommonProxy.fake_stone, random.nextInt(3), 3);
			
			world.setBlock(x + 7, y, z + 1, CommonProxy.fake_stone, random.nextInt(3), 3);
			world.setBlock(x + 7, y - 1, z + 1, CommonProxy.fake_stone, random.nextInt(3), 3);
			
			
			// For debugging. This shouldn't be in the release build.
			System.out.println("Artifact dungeon of type " + this.artifactMetadata + " placed at " + x + ":" + y + ":" + z + ".");
		}		
	}

}
