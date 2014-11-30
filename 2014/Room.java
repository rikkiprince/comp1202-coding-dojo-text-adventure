import java.util.*;
public class Room {
	String name;
	String description;
	Map<String,Room> attachedRooms;
	Map<String,String> knownOpposites;
	List<Item> items = new ArrayList<Item>();

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
		attachedRooms = new HashMap<String,Room>();
		knownOpposites = new HashMap<String,String>();
		initialiseKnownOpposites();
	}

	public void linkRoom(String direction, Room room ) {
		if(attachedRooms.get(direction) == room) return;	// stop recursive loop
		attachedRooms.put(direction, room);

		// reciprocal link
		if(knownOpposites.containsKey(direction) && knownOpposites.get(direction) != null) {
			room.linkRoom(knownOpposites.get(direction), this);
		}
	}

	public void linkRoomReciprically(String direction, Room room) {
		this.linkRoom(direction, room);
		// room.linkRoom( WHAT, this);
		return;
	}
	
	public Room goDirection(String direction) throws Exception {
		if(! attachedRooms.containsKey(direction)) {
			throw new Exception("No exit to the "+direction);
		}
		return attachedRooms.get(direction);
	}

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return this.name;
	}
	
	public void addItem(Item item){
		items.add(item);
	}

	public String getExits() {
		String out = "";
		for(Map.Entry<String,Room> exit : this.attachedRooms.entrySet()) {
			String direction = exit.getKey();
			String roomName = exit.getValue().getName();
			out += "* To the "+direction+" is "+roomName+"\n";
		}
		return out;
	}


	private void initialiseKnownOpposites() {
		knownOpposites.put("north", "south");
		knownOpposites.put("south", "north");
		knownOpposites.put("east", "west");
		knownOpposites.put("west", "east");
	}

}
