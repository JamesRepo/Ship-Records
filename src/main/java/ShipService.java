import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * ==== Ship Service ====
 * Handles the logic behind the three endpoints.
 * 
 */
public class ShipService {
	/* Instance variables */
	private List<Ship> shipList;
	/**
	 * Constructor. List of ships is the only paremeter.
	 * @param shipList
	 */
	public ShipService(List<Ship> shipList) {
		this.shipList = shipList;
		Collections.sort(shipList); // Sort ships by ID
	}
	/**
	 * Get All Ships.
	 * Prints the details of all ships.
	 * 
	 * @return
	 */
	public String getAllShips() {
		StringBuilder sb = new StringBuilder();
		for (Ship s : shipList) {
			sb.append(s.toString());
		}
		return sb.toString();
	}
	/**
	 * Get One Ship.
	 * Searches through the list of ships to find the specific one as per inputed ID. 
	 * 
	 * Binary search. Able as the ship list is sorted in constructor. 
	 * 
	 * @param id
	 * @return
	 */
	public Ship getOneShip(int id) {
		// Low & High variables
		int start = 0;
		int end = shipList.size() - 1;
		// While loop until value has been found or start and end meet
		while (start <= end) {
			// Halfway point of remaining values
			int mid = (start + end) / 2;
			// If the mid point is the ID then return it
			if (shipList.get(mid).getId() == id) {
				return shipList.get(mid);
			}
			// If value is lower than mid point, eliminate the second half of remaining values
			else if (shipList.get(mid).getId() > id) {
				end = mid - 1;
			}
			// If value is higher than midpoint, eliminate the first half of remaining values
			else if (shipList.get(mid).getId() < id) {
				start = mid + 1;
			}
		}
		// If there is no ship by that ID, return null
		return null;
	}
	/**
	 * Get Ship by Owner.
	 * Iterates through the list of ships and adds the ship the a list if it has the owner being searched for. 
	 * 
	 * @param owner
	 * @return
	 */
	public List<Ship> getShipByOwner(String owner) {
		// Need dynamic data structure as we won't know how many ships will be on the list
		List<Ship> owned = new ArrayList<Ship>();
		for (Ship s : shipList) {
			if (s.getOwner().equals(owner)) {
				owned.add(s);
			}
		}
		// If the list is empty, meaning there is not owner by that name, return null
		if (owned.size() == 0) {
			return null;
		}
		// Return 
		return owned;
	}
}