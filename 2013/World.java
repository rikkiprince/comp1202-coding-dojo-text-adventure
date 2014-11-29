import java.util.List;
import java.util.ArrayList;

public class World {
	private List<Room> rooms = new ArrayList<Room>();
	private Player player;

	public World() {

		Room field = new Room("a field", "Surrounding you is beautiful greenery and some trees. To the north is another field and to the west is a large shed.");
		this.addRoom(field);

		Room shed = new Room("a shed", "This shed is bigger than yours. It has a roof and a window. To the north is a wheelbarrow.");

		field.addRoom("west", shed);

		Room anotherField = new Room("a field", "This field is somewhat desolated. To the east is a small cafe.");

		field.addRoom("north", anotherField);


		this.player = new Player(field);
	}

	public void addRoom(Room r) {
		this.rooms.add(r);
	}

	public Player getPlayer() {
		return this.player;
	}

	public Room getStartingRoom(){
		return this.rooms.get(0);
	}
}
