import java.io.*;
import java.util.*;

public class ContainerItem extends Item
{

	protected List<Item> contents;

	protected int maxNumberOfItems;
	protected int maxWeight;
	
	public ContainerItem(String name)
	{
		super(name);
		this.contents = new ArrayList<Item>();
	}

	public void addItem(Item item)
	{
		this.contents.add(item);
	}
	public Item removeItem(Item item)
	{
		//Item i = this.contents.get(item);
		this.contents.remove(item);
		return null;
	}
}
