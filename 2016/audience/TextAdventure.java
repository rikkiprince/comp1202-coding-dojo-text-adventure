import java.util.*;

public class TextAdventure {
	
	private Room currentRoom;
	private Container inventory;	
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Parser parser;
	
	public TextAdventure() {
		parser = new Parser();
		
		this.inventory = new Container("");
		
		this.currentRoom = new Room("Bagend");
		Room garden = new Room("Bilbo Baggin's garden");
		this.currentRoom.linkRoom("south", garden, "north");
		this.currentRoom.addItem("Patrick");
		this.currentRoom.addItem("banana");
		
		Room camelHut = new Room("An inexplicable camel hut");
		garden.linkRoom("desert", camelHut, "garden");
		camelHut.addItem("camel");
	}

	private void play() {
		String action;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");
		System.out.println("You are in a room...");

		do {
			currentRoom.print();	// ????
			parser.promptPlayer("What do you want to do?");

			action = parser.getAction();
			
			// Handle compass direction commands
			if(action.equals("north") 
			|| action.equals("south") 
			|| action.equals("east") 
			|| action.equals("west")) {
				System.out.println("you want to move "+action);
				currentRoom = currentRoom.moveTo(action);
			// Handle 'move' command (can use any direction)
			} else if(action.equals("move")) {
				List<String> arguments = parser.getArguments();
				if(arguments.size() >= 1) {
					String direction = arguments.get(0);
					//System.out.println("you are trying to move "+direction);
					// am allowed to move
					// update the current room to point the new room
					currentRoom = currentRoom.moveTo(direction);
				} else {
					System.out.println("you need to specify which direction to move in");
				}
			} else if(action.equals("i") || action.equals("inventory")) {
				// list player's items
				System.out.println("----------------------------------");
				System.out.println("|     Inventory                  |");
				System.out.println("|                                |");
				this.inventory.displayItems();
			} else if(action.equals("look")) {
				currentRoom.displayItems();
			} else if(action.equals("pickup") || action.equals("get") || action.equals("take")) {
				List<String> arguments = parser.getArguments();
				if(arguments.size() >= 1) {
					String itemName = arguments.get(0);
					// take object from room and put it in inventory
					Item takenItem = currentRoom.takeItem(itemName);
					if(takenItem != null) {
						this.inventory.addItem(takenItem);
					} else {
						System.out.println("can't find item "+itemName);
					}
				} else {
					System.out.println("you need to specify which object to take");
				}
			// Unknown actions
			} else {
				System.out.println("I do not know how to '"+action+"'");
			}

		} while(!parser.getUserInput().equals("exit"));

		System.out.println("Goodbye");
	}

}
