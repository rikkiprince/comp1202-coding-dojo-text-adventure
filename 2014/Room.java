import java.util.*;
public class Room {
	String name;
	String description;
	Map<String,Room> attachedRooms;
	List<Item> items = new ArrayList<Item>();

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
		attachedRooms = new HashMap<String,Room>();
	}

	public void linkRoom(String direction, Room room ) {
		attachedRooms.put(direction, room);
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
}
