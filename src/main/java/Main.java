import java.util.Scanner;
/*
 * ==== Main ====
 * Handles input from user.
 * 
 */
public class Main {
	public static void main(String[] args) {
		// Input of file, read file, pass Ship Service object the list of ships from file.
		JSONReader jsonReader = new JSONReader("src/main/resources/ships.json");
		jsonReader.readFile();
		ShipService shipService = new ShipService(jsonReader.getShipList());
		// List of options for user.
		System.out.println("Pick an option.\n1. Print all ships\n2.Get one ship\n3. Get ships by owner");
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		// Exception caught if input is not a number. Prints an error and exits program.
		try {
			choice = Integer.parseInt(scan.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Error - Incorrect input.");
			System.exit(0);
		}
		// Handles choices and directs to appropriate service.
		switch (choice) {
			case 1:
				System.out.println(shipService.getAllShips());
				break;
			case 2:
				System.out.print("Enter ID: ");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println(shipService.getOneShip(id));
				break;
			case 3: 
				System.out.print("Enter Owner: ");
				String owner = scan.nextLine();
				System.out.println(shipService.getShipByOwner(owner));
				break;
			default: 
				System.out.println("Error - Incorrect input."); // Default message if a correct option is not entered.
				break;
		}
	}	
}