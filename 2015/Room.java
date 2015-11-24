import java.util.*;

public class Room {
	private String description;
	private static Map<String,String> directionMap;
	private List<Item> items;
	
	Map<String,Door> exits = new HashMap<String,Door>();	
	
	public Room(String description) {
		this.description = description;
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item i) {
		this.items.add(i);
	}
	public Item take(String s) throws Exception {
		for(Integer i=0; i<items.size(); i++) {
			Item item = this.items.get(i);
			if(s.equals(item.getName().toLowerCase())) {
				this.items.remove(item);
				return item;
			}
		}
		throw new Exception("No item called "+s);
	}

	public void printDescription() {
		System.out.println(this.description);
	}

	public void setExit(String direction, Room room)
	{
		this.setOneWayExit(direction, room);
		String reverseDirection = Room.reverseDirection(direction);
		if(reverseDirection != null) {
			room.setOneWayExit(reverseDirection,this);
		}
	}

	public void setOneWayExit(String direction, Room room) {
		Door door = new Door(room);
		this.exits.put(direction, door);
	}


	public void printExits() {
		if(exits.isEmpty()) {
			System.out.println("There is no escape.");
			return;
		}
		System.out.println("There are the following exits: ");
		for(String direction : exits.keySet())
		{
			System.out.println( "\t"+direction );
		}
	}

	public void printItems() {
		if(this.items.isEmpty()) {
			return;
		}
		System.out.println("In the room you find: ");
		for(Item item : this.items) {
			System.out.println("\t"+item);
		}
	}

	public Room throughDoor(String direction) throws Exception {
		if(!exits.containsKey(direction)) {
			throw new Exception("There is no exit to the "+direction);
		}
		Door door = exits.get(direction);
		return door.exit();
	}
	
	public static String reverseDirection(String direction){ 
		if(directionMap == null) {
			// initialise on first use
			Room.directionMap = new HashMap<String,String>();

			Room.directionMap.put("north","south");
			Room.directionMap.put("south","north");
			Room.directionMap.put("west","east");
			Room.directionMap.put("east","west");
			Room.directionMap.put("up","down");
			Room.directionMap.put("down","up");
		}

		return Room.directionMap.get(direction);
	}

}
