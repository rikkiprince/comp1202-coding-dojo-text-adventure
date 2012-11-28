import java.io.*;
import java.util.*;

public class Room implements Describable{

	HashMap exits = new HashMap<String,Room>();
	ArrayList items = new ArrayList<Item>();
	String name = "";
	String description = "";
	public static final String NORTH = "north";
	public static final String SOUTH = "south";
	public static final String WEST = "west";
	public static final String EAST = "east";

	public Room(String name, String description){
		this.name = name;
		this.description = description;
	}

	public String describe() {
		String decscription + "\n The exits are: ";
		// TODO put room exits listed here
		return this.description;
	}

	public boolean addExit(String direction, Room room){
		exits.put(direction, room);
		return true;
	}

	public boolean addItem(Item item){
		items.add(item);
	}

	public Room moveTo(String direction) throws Exception{
		if(exits.contains(direction)){
			return exits.get(direction);
		}
			
		return new Exception("There is no exit " + direction);
	}

}
