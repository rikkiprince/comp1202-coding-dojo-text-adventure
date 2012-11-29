import java.io.*;
import java.util.*;

public class Room implements Describable{

	HashMap<String,Room> exits = new HashMap<String,Room>();
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
		String decscription = "\n The exits are: ";
		// TODO put room exits listed here
		for(String exit : exits.keySet())
		{
			Room target = exits.get(exit);
			description += "\n"+exit+" : "+target;
		}

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
		if(exits.containsKey(direction)){
			return exits.get(direction);
		}
			
		throw new Exception("There is no exit " + direction);
	}

}
