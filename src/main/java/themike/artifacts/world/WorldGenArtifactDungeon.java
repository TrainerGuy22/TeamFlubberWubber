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
		if(CommonProxy.dungeon_world_data == null)
			CommonProxy.loadWorldSaveData(world);
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
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider generator, IChunkProvider provider) {
		if(world.provider.dimensionId != 0) {
			return;
		}
		
		ChunkCoordinates spawnCoords = world.getSpawnPoint();
		
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = 10 + random.nextInt(7);

		Coord2 spawn = new Coord2(spawnCoords.posX, spawnCoords.posZ);
		Coord2 chunk = new Coord2(chunkX * 16, chunkZ * 16);
		
		// if(spawn.distance(chunk) <= 2000) {
		if(random.nextInt(60) == 4 && canSpawn(world, x, y, z)) {
			CommonProxy.dungeon_world_data.artifacts[artifactMetadata] = 1;
			
			for(int countX = x - 3; countX != x + 6; countX++) {
				for(int countZ = z - 3; countZ != z + 3; countZ++) {
					for(int countY = y - 1; countY != y + 4; countY++) {
						world.setBlock(countX, countY, countZ, Blocks.air);
					}
					world.setBlock(countX, y - 2, countZ, Blocks.stonebrick);
					world.setBlock(countX, y + 4, countZ, Blocks.stonebrick);
				}
			}
			
			world.setBlock(x, y, z, CommonProxy.display_glass);
			((TileDisplayGlass) world.getTileEntity(x, y, z)).artifactMetadata = this.artifactMetadata;
			
			world.setBlock(x, y - 1, z, Blocks.quartz_block, 2, 3);
			
			world.setBlock(x - 1, y - 2, z - 1, Blocks.glowstone);
			world.setBlock(x - 1, y - 2, z + 1, Blocks.glowstone);
			world.setBlock(x + 1, y - 2, z - 1, Blocks.glowstone);
			world.setBlock(x + 1, y - 2, z + 1, Blocks.glowstone);
			
			for(int countZ = z - 3; countZ != z + 4; countZ++) {
				for(int countY = y - 1; countY != y + 3; countY++) {
					world.setBlock(x - 4, countY, countZ, Blocks.stonebrick);
					world.setBlock(x + 6, countY, countZ, Blocks.stonebrick);
				}
			}
			
			for(int countX = x - 3; countX != x + 6; countX++) {
				for(int countY = y - 1; countY != y + 3; countY++) {
					world.setBlock(countX, countY, z - 4, Blocks.stonebrick);
					world.setBlock(countX, countY, z + 4, Blocks.stonebrick);
				}
			}
			
			// For debugging. This shouldn't be in the release build.
			System.out.println("Artifact dungeon of type " + this.artifactMetadata + " placed at " + x + ":" + y + ":" + z + ".");
		}
		
		// }		
		
	}

}
