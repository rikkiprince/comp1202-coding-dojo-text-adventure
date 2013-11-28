public class Item {

	String name = "no name";
	String description = "There is nothing signifcant";

	public Item(String name) {
		this(name, "It's just a "+name);
	}
	
	public Item(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String describe() {
		return this.description;
	}	
	
	public String getName(){
		return this.name;
	}
}
