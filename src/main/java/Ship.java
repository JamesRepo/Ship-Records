/*
 * ==== Ship ====
 * Class to store information on the ships in the JSON file.
 */
public class Ship implements Comparable<Ship> {
	/* Variables representing the data names */
	private Integer id;
	private int built;
	private String name;
	private double lengthMeters;
	private double beamMeters;
	private int maxTEU;
	private String owner;
	private String grossTonnage;
	/* Empty constructor */
	public Ship() {}
	/* Get methods */
	public int getId() {
		return id;
	}
	public int getBuilt() {
		return built;
	}
	public String getName() {
		return name;
	}
	public double getLengthMeters() {
		return lengthMeters;
	}
	public double getBeamMeters() {
		return beamMeters;
	}
	public int getMaxTEU() {
		return maxTEU;
	}
	public String getOwner() {
		return owner;
	}
	public String getGrossTonnage() {
		return grossTonnage;
	}
	/* Set methods */
	public void setId(int id) {
		this.id = id;
	}
	public void setBuilt(int built) {
		this.built = built;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLengthMeters(double lengthMeters) {
		this.lengthMeters = lengthMeters;
	}
	public void setBeamMeters(double beamMeters) {
		this.beamMeters = beamMeters;
	}
	public void setMaxTEU(int maxTEU) {
		this.maxTEU = maxTEU;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setGrossTonnage(String grossTonnage) {
		this.grossTonnage = grossTonnage;
	}
	/*
	 * Over ride to string method to print a ships information and format it correctly. 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ID: %d\nBuilt: %s\nName: %s\nLength: %.2f\nBeam: %.2f\nMax TEU: %d\nOwner: %s\nGross Tonnage: %s\n\n", id, built, name, lengthMeters, beamMeters, maxTEU, owner, grossTonnage);
	}
	/**
	 * Implementation of compare to.
	 * Allows a binary search of ships and allows ships to be printed out in order of ID.
	 */
	public int compareTo(Ship ship) {
		int comp = id.compareTo(ship.getId());
		return comp;
	}
}