package themike.artifacts.world;

import java.util.Random;

import themike.artifacts.util.Coord2;
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
		ChunkCoordinates spawnCoords = world.getSpawnPoint();
		
		int x = chunkX * 16;
		int z = chunkZ * 16;
		int y = 10 + random.nextInt(7);

		Coord2 spawn = new Coord2(spawnCoords.posX, spawnCoords.posZ);
		Coord2 chunk = new Coord2(x, z);
		
		// if(spawn.distance(chunk) <= 2000) {
		if(random.nextInt(60) == 4 && canSpawn(world, x, y, z)) {
				
		}
		// }
		
		
		
	}

}
