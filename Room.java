import java.util.*;

public class Room {
	private String name;
	private String description;
	private List<Item> items;
	

	private Room north;
	//private List<Room> exits; // how do I know which room?
	private Map<String, Door> exits;

	public Room(String name, String description) {
		this.name = name;
		this.description = description;

		this.items = new ArrayList<Item>();
		this.exits = new HashMap<String, Door>();
	}

	public String getDescription() {
		String desc = this.description;
		if(this.items.size() > 0){
			desc += "\n\nYou see:\n";
			for(Item i: this.items){
				desc += "    "+i.getName()+"\n";
			}
		}
		return desc;
	}

	public void addItem(Item i) {
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
			return this;
		}
	}
}
