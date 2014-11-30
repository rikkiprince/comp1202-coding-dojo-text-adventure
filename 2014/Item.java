public class Item {

	protected int size;
	private int cost;
	private int rarity;
	private int damaged;
	private String name;
	private String description;
	private boolean pickupable;

	public Item(String name, String description, boolean pickupable, int size){
		this.name = name;
		this.description = description; 
		this.pickupable = pickupable;
		this.size = size;
	}

	public Item(String name, String description) {
		this(name, description, true, 3); // small by default
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean canBePickedUp() {
		return pickupable;
	}
	
	public int getSize() {
		return size;
	}
}
