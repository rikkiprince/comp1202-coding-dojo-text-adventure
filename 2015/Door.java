public class Door {
	private Room one;
	private Room two;

	public Door(Room one, Room two) {
		this.one = one;
		this.two = two;
	}

	public void setOne(Room one) {
		this.one = one;
	}
	public void setTwo(Room two) {
		this.two = two;
	}
}