import java.io.*;
import java.util.*;

public class Player implements Describable
{
	protected String name;
	protected List<Item> inventory;
	protected Integer health = new Integer(4);;
	protected Room currentRoom;

	public Player(String name, Room start)
	{
		this.inventory = new ArrayList<Item>();
		this.name = name;
		this.health = 100;
		this.currentRoom = start;
	}

	public void pickup(Item item)
	{
		this.inventory.add(item);
	}

	public String describe()
	{
		String out = "You are "+this.name;

		for(Item item : this.inventory)
		{
			out += "\n" + item;
		}

		return out;
	}
	
	public String lookAt(String[] tokens){
		String description = "";
		for(Item item : this.inventory){
			if(item.getName().equals(tokens[2])){
				description += item.describe()+"\n";
			}
		}
		
		description += currentRoom.lookAt(tokens[2]);

		if(description.equals("")){
			return "There is no item: "+tokens[2];
		}

		return description;
	}

	public String move(String direction) throws Exception
	{
		currentRoom = currentRoom.moveTo(direction);
		return currentRoom.describe();
	}
}
