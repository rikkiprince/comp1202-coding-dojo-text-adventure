public class Door {
	private Room one;
	private Room two;
	private Door reciprocalDoor;

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
	public Room exit(Room roomToLeave) {
		if(one.equals(roomToLeave)) {
			return two;
		} 
		return one;
	}
}
