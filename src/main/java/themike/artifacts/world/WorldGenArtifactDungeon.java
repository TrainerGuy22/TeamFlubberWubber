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

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider generator, IChunkProvider provider) {
		ChunkCoordinates spawnCoords = world.getSpawnPoint();
		
		Coord2 spawn = new Coord2(spawnCoords.posX, spawnCoords.posZ);
		Coord2 chunk = new Coord2(chunkX * 16, chunkZ * 16);
		if(spawn.distance(chunk) <= 2000) {
			
		}
	}

}
