import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
/*
 * ==== JSON Reader ====
 * Class to handle the reading of the JSON file.
 * 
 */
public class JSONReader {
	/* Instance variables */
	String fileName;
	MyShips myShips;
	/**
	 * Constructor - file name is obtained here.
	 * @param fileName
	 */
	public JSONReader(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * Read File method.
	 * Uses GSON, a library used to handle JSON files.
	 */
	public void readFile() {
		Gson gson = new Gson();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			myShips = gson.fromJson(reader, MyShips.class);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns list of ships from the My Ships object.
	 * @return
	 */
	public List<Ship> getShipList() {
		return myShips.getShipList();
	}
}