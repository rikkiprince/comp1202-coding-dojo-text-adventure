import java.util.*;

public class TextAdventure {
	
	private Room currentRoom;
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Parser parser;
	
	public TextAdventure() {
		parser = new Parser();
		this.currentRoom = new Room("Bagend");
		Room garden = new Room("Bilbo Baggin's garden");
		this.currentRoom.linkRoom("south", garden, "north");
		Room camelHut = new Room("An inexplicable camel hut");
		garden.linkRoom("desert", camelHut, "garden");
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
			
			if(action.equals("north") 
			|| action.equals("south") 
			|| action.equals("east") 
			|| action.equals("west")) {
				System.out.println("you want to move "+action);
				currentRoom = currentRoom.moveTo(action);
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
			} else {
				System.out.println("I do not know how to '"+action+"'");
			}

		} while(!parser.getUserInput().equals("exit"));

		System.out.println("Goodbye");
	}

}
