import java.util.List;
/*
 * ==== My Ships ====
 * This data class is needed to retrieve data from the JSON file with GSON.
 * 
 */
public class MyShips {
	/* List of ships */
	private List<Ship> ships;
	/* Get the list */
	public List<Ship> getShipList() {
		return ships;
	}
}