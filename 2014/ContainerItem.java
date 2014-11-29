import java.util.ArrayList;

public class ContainerItem extends Item {
	ArrayList<Item> inside = new ArrayList<Item>();
	int capacity = 20;
	
	public void insertItem(Item item) {
		if(this.getSize() < capacity) {
			inside.add(item);
		}
	}
	
	public int getSize(){
		int size = this.size;
		for(Item item : inside) {
			size += item.getSize();
		}
		return size;
	}
	
}
