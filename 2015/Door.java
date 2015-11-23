public class Door {
	private Room linkedLocation;
	private Door reciprocalDoor;

	public Door(Room location) {
		this.linkedLocation = location;
	}

	public void setLocation(Room location) {
		this.linkedLocation = location;
	}
	public Room exit() {
		return this.linkedLocation;
	}
}
