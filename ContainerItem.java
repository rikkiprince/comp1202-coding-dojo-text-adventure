import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ContainerItem extends Item {

	List<Item> contents = new ArrayList<Item>();

	public ContainerItem(String title){
		super(title);
	}

	public ContainerItem(String title, String description){
		super(title, description);
	}

	public void add(Item item){
		contents.add(item);
	}

	public Item remove(String name){
		Iterator<Item> it = contents.iterator();
		while(it.hasNext())
		{
			Item item = it.next();
			if(item.getName().equals(name)){
				it.remove();
				return item;
			}
		}
		return null;
	}

	public String describe() {
		//String description = (String)this.description.clone();
		//description += "\nIt contains: \n"; 
		String description = this.description + "\nIt contains: \n";
		for(Item item : contents){
			description += item+"\n";
		}

		return description;
	}

	public String describe(String itemName){
		for(Item item : contents) {
			if(item.getName().equals(itemName)) {
				return item.describe();
			}
		}
		return null;
	}
	
}
