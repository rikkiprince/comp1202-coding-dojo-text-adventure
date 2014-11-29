public class Player {
	Room currentRoom;
	Item inventory; 

	public Player(Room r) {
		this.currentRoom = r;
	}

	public void pick(Item item){
		inventory = item;
	}

	public void move(String direction) {
		Room newRoom = currentRoom;

		try {
			newRoom = currentRoom.goDirection(direction);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}

		if(newRoom == null) {
			newRoom = currentRoom;
		}

		if(newRoom == currentRoom) {
			System.out.println("You haven't moved room.");
		}

		this.currentRoom = newRoom;
	}

	public Room getRoom() {
		return this.currentRoom;
	}

	public void look() {
		System.out.println(this.currentRoom.getDescription());
	}

	public void quit() {
		System.out.println("This is the end of your game!");
		System.exit(1);
	}	
}
