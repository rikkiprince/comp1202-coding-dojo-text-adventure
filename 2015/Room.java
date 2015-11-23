import java.util.*;

public class Room {
	private String description;
	Map<String,Door> exits = new HashMap<String,Door>();	
	
	public Room(String description) {
		this.description = description;
	}

	public void printDescription() {
		System.out.println(this.description);
	}

	public void setExit(String direction, Room room)
	{
		Door door = new Door(this, room);
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

	public Room throughDoor(String direction) throws Exception {
		if(!exits.containsKey(direction)) {
			throw new Exception("There is no exit to the "+direction);
		}
		Door door = exits.get(direction);
		return door.exit(this);
	}

}
