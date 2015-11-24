public class Item {
	private String name;
	private Integer size;

	public Item(String name, Integer size) {
		this.name = name;
		this.size = size;
	}

	public String toString() {
		return this.name;
	}

	public Integer getSize() {
		return this.size;
	}
	public void setSize(Integer newSize) {
		this.size = newSize;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
}