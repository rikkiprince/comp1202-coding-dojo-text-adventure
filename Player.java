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
		String out = "";

		for(Item item : this.inventory)
		{
			out += item + "\n";
		}

		return out;
	}
}
