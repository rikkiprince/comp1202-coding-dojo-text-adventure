import java.util.*;

public class Container extends Item {
	private List<Item> contents;
	private Integer capacity;
	
	public Container(String name) {
		this(name, 10);
	}
	public Container(String name, Integer maximumCapacity) {
		super(name);
		this.contents = new ArrayList<Item>();
		this.capacity = maximumCapacity;
	}
	
	public void addItem(Item itemToAdd) {
		if(this.contents.size() < this.capacity) {
			this.contents.add(itemToAdd);
		} else {
			System.out.println("not enough room in "+this);
		}
	}
	
	public Item takeItem(String item) {
		Iterator<Item> it = this.contents.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			if(i.toString().equals(item)) {
				it.remove();
				return i;
			}
		}
		return null;
	}
	
	public void displayItems() {
		for(Item item : this.contents) {
			System.out.println(item);
		}
	}
}
