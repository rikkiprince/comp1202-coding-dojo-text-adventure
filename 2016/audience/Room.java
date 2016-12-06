import java.util.*;

public class Room {
	// name
	// x,y location?
	
	private String name;
	private Integer size;
	private Container roomItems;
	
	// directions
	private Map<String,Room> adjacentRooms; // direction -> room object
	
	public Room(String name) {
		this.name = name;
		this.adjacentRooms = new HashMap<String, Room>();
		this.roomItems = new Container("room"); //new ArrayList<Item>();
	}
	
	public void addItem(String itemName) {
		this.roomItems.addItem(new Item(itemName));
	}
	
	public void displayItems() {
		this.roomItems.displayItems();
	}
	
	public Item takeItem(String item) {
		return this.roomItems.takeItem(item);
	}
	
	public void print() {
		System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" / You are in "+this.name);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("You can move in:");
		for(String direction : this.adjacentRooms.keySet()) {
			System.out.println(" * "+direction);
		}
	}
	
	// add one-way link
	public void linkRoom(String direction, Room addedRoom) {
		linkRoom(direction, addedRoom, null);
	}
	// add two-way link
	public void linkRoom(String direction, Room addedRoom, String reverseDirection) {
		this.adjacentRooms.put(direction, addedRoom);
		if(reverseDirection != null) {
			addedRoom.linkRoom(reverseDirection, this, null);
		}
	}
	
	public Room moveTo(String direction) {
		/*switch(direction) {
			case "north":
				return this.northRoom;
			case "south":
				return this.southRoom;
			case "east":
				return this.eastRoom;
			case "west":
				return this.westRoom;
		}*/
		if(this.adjacentRooms.containsKey(direction)) {
			return this.adjacentRooms.get(direction);
		}
		
		System.out.println("Unknown direction '"+direction+"'.");
		return this;	// throw exception?
	}
}
