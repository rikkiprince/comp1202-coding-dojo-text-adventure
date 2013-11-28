class Player{
	private Room currentRoom;
	private ContainerItem inventory  = new ContainerItem("Bag", "Your faithful bindle");
	//private ??? inventory;
	//
	public Player(Room start) {
		this.currentRoom = start;
	}
	public String look(){

		return currentRoom.getDescription();

	}

	public Room getCurrentRoom(){
		return currentRoom;
	}
	public Room move(String direction){
		this.currentRoom = this.currentRoom.move(direction);
		return this.currentRoom;
	}
}
