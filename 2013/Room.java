import java.util.*;

public class Room {
	private String name;
	private String description;
	private ContainerItem items;
	

	private Room north;
	//private List<Room> exits; // how do I know which room?
	private Map<String, Door> exits;

	public Room(String name, String description) {

		this.items = new ContainerItem(name,description);
		this.exits = new HashMap<String, Door>();
	}

	public String getDescription() {
		return items.describe();
	}

	public void addItem(Item i) throws Exception{
		this.items.add(i);
	}

	public void addRoom(String direction, Room r) {
		this.exits.put(direction, new Door(r, false));
	}

	public Room move(String direction) {
		if(this.exits.containsKey(direction)) {
			Door d = this.exits.get(direction);
			return d.proceedThrough();
		}
		else {
			System.out.println("There is no "+direction+"!!!");
			return this;
		}
	}
}
