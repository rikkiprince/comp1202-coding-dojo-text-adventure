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

        public String getExitDescription() {
		String description = "";
                for(String direction : exits.keySet())
		{
			description += direction + ": \n";

		}
        }

	public Room throughDoor(String direction) {
		Door door = exits.get(direction);
		return door.exit(this);
	}

}
