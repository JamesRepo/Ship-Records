import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
/*
 * ==== Ship Test ====
 * List of JUnit tests for Ship Service.
 * 
 */
public class ShipTest {
	/* Initialisation */
	private List<Ship> shipList;
	private ShipService shipService;
	@Before
	public void setUp() {
		JSONReader jsonReader = new JSONReader("src/main/resources/ships.json");
		jsonReader.readFile();
		shipList = jsonReader.getShipList();
		shipService = new ShipService(shipList);
	}
	/* Tests find ship by ID */
	@Test
	public void testFindID1() {
		Ship ship1 = shipList.get(0);
		Ship ship2 = shipService.getOneShip(1);
		assertEquals(ship1, ship2);
	}
	@Test
	public void testFindID2() {
		Ship ship1 = shipList.get(50);
		Ship ship2 = shipService.getOneShip(51);
		assertEquals(ship1, ship2);
	}
	@Test
	public void testFindID3() {
		Ship ship1 = shipList.get(125);
		Ship ship2 = shipService.getOneShip(126);
		assertEquals(ship1, ship2);
	}
	@Test
	public void testFindID4() {
		Ship ship1 = shipList.get(160);
		Ship ship2 = shipService.getOneShip(161);
		assertEquals(ship1, ship2);
	}
	@Test
	public void testNullID() {
		Ship ship1 = shipService.getOneShip(1000);
		assertEquals(ship1, null);
	}
	/* Tests find ship by owner */
	@Test
	public void testFindOwner1() {
		List<Ship> ownerTest1 = new ArrayList<Ship>();
		ownerTest1.add(shipList.get(11));
		ownerTest1.add(shipList.get(12));
		ownerTest1.add(shipList.get(13));
		ownerTest1.add(shipList.get(14));
		ownerTest1.add(shipList.get(15));
		ownerTest1.add(shipList.get(16));
		ownerTest1.add(shipList.get(17));
		ownerTest1.add(shipList.get(18));
		ownerTest1.add(shipList.get(19));
		ownerTest1.add(shipList.get(20));
		ownerTest1.add(shipList.get(21));
		ownerTest1.add(shipList.get(22));
		List<Ship> ownerTest2 = shipService.getShipByOwner("Mediterranean Shipping Company");
		assertEquals(ownerTest1, ownerTest2);
	}
	@Test
	public void testFindOwner2() {
		List<Ship> ownerTest1 = new ArrayList<Ship>();
		ownerTest1.add(shipList.get(0));
		ownerTest1.add(shipList.get(1));
		ownerTest1.add(shipList.get(2));
		ownerTest1.add(shipList.get(124));
		ownerTest1.add(shipList.get(125));
		ownerTest1.add(shipList.get(126));
		ownerTest1.add(shipList.get(127));
		ownerTest1.add(shipList.get(128));
		ownerTest1.add(shipList.get(129));
		ownerTest1.add(shipList.get(130));
		ownerTest1.add(shipList.get(131));
		ownerTest1.add(shipList.get(132));
		ownerTest1.add(shipList.get(133));
		List<Ship> ownerTest2 = shipService.getShipByOwner("OOCL (Hong Kong)");
		assertEquals(ownerTest1, ownerTest2);
	}
	@Test
	public void testFindOwner3() {
		List<Ship> ownerTest1 = new ArrayList<Ship>();
		ownerTest1.add(shipList.get(3));
		ownerTest1.add(shipList.get(4));
		ownerTest1.add(shipList.get(5));
		ownerTest1.add(shipList.get(6));
		List<Ship> ownerTest2 = shipService.getShipByOwner("Maersk Line");
		assertEquals(ownerTest1, ownerTest2);
	}
	@Test
	public void testFindOwner4() {
		List<Ship> ownerTest1 = new ArrayList<Ship>();
		ownerTest1.add(shipList.get(7));
		ownerTest1.add(shipList.get(8));
		ownerTest1.add(shipList.get(9));
		ownerTest1.add(shipList.get(10));
		List<Ship> ownerTest2 = shipService.getShipByOwner("Mitsui O.S.K. Lines");
		assertEquals(ownerTest1, ownerTest2);
	}
	@Test
	public void testNullOwner() {
		List<Ship> ownerTest1 = shipService.getShipByOwner("James");
		assertEquals(ownerTest1, null);
	}
}