public class Item implements Describable
{
	String name;

	public Item(String name)
	{
		this.name = name;
	}

	public Item()
	{
		this("An unknown item");
	}

	public String toString()
	{
		return this.name;
	}

	public String describe()
	{
		return this.name;
	}
}
