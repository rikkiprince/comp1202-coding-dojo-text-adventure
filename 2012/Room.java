import java.io.*;
import java.util.*;

public class Room implements Describable{

	HashMap<String,Room> exits = new HashMap<String,Room>();
	ArrayList<Item> items = new ArrayList<Item>();
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
		String out = this.description+"\n The exits are: ";
		
		int i=0;
		for(String exit : exits.keySet())
		{
			System.out.println("Exit "+(++i));
			Room target = exits.get(exit);
			out += "\n"+exit+" : "+target;
		}

		return out;
	}

	public boolean addExit(String direction, Room room){
		exits.put(direction, room);
		return true;
	}

	public boolean addItem(Item item){
		items.add(item);
		return true;
	}

	public Room moveTo(String direction) throws Exception{
		if(exits.containsKey(direction)){
			return exits.get(direction);
		}
			
		throw new Exception("There is no exit " + direction);
	}

	public String lookAt(String thing)
	{
		if(thing.equals("room"))
			return this.describe();
		for(Item item : items)
		{
			if(item.getName().equals(thing))
			{
				return item.describe();
			}
		}
		return thing+" does not exist in the room!\n";
	}

	public String toString()
	{
		return this.name;
	}

}
