package themike.artifacts.util;

public class Coord2 {
	
	public int x;
	public int z;
	
	public Coord2(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public int distance(Coord2 coord) {
		return (int) Math.sqrt(Math.pow(coord.x - this.x, 2) + Math.pow(coord.z - this.z, 2));
	}

}
