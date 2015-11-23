public class Door {
	private Room one;
	private Room two;

	public Door(Room one, Room two) {
		this.one = one;
		this.two = two;
	}

	public setOne(Room one) {
		this.one = one;
	}
	public setTwo(Room two) {
		this.two = two;
	}
}