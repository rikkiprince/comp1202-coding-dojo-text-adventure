public class Room {
	Map<String,Room> exits = new HashMap<String,Door>();	
	

	public void setExit(String direction, Room room)
	{
		Door door = new Door(this, room);
		this.exits.put(direction, door);
	}
}
