public class Door {
	private boolean locked;
	private Room leadsTo;

	public Door(Room leadsTo, boolean startsLocked) {
		this.locked = startsLocked;
		this.leadsTo = leadsTo;
	}

	public void unlock() {
		this.locked = false;
	}

	public Room proceedThrough() {
		return this.leadsTo;
	}
}
