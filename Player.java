class Player{
	private Room currentRoom;
	private ContainerItem inventory  = new ContainerItem("Bag", "Your faithful bindle");
	//private ??? inventory;
	//
	
	public String look(){

		return currentRoom.getDescription();

	}

	public Room getCurrentRoom(){
		return currentRoom;
	}
}
