import java.util.*;

public class TextAdventure {
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Scanner in;
	private Room currentRoom;

	public TextAdventure() {
		this.in = new Scanner(System.in);
		
		Room lectureTheatre = new Room("You are in 7/3009. There are lots of undergraduates.");
		Room corridor = new Room("This is a corridor. 300 people are trying to leave 7/3009 while 300 are trying to get in.");
		lectureTheatre.setExit("north", corridor);
		corridor.setExit("south", lectureTheatre);
		Room stairs = new Room("These stairs wind round and around.");
		corridor.setExit("west", stairs);
		stairs.setExit("east", corridor);
		Room road = new Room("This road is one way, except for cycles. Be vigilant for cyclists.");
		stairs.setExit("south", road);
		road.setExit("north", stairs);
		Room library = new Room("There are so many books in this library. You could stay here forever.");
		road.setExit("south", library);

		this.currentRoom = lectureTheatre;

	}

	private void play() {
		String input;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");
		System.out.println("You are in a room...");

		do {
			System.out.println("What do you want to do?");
			System.out.print("> ");
			input = this.in.nextLine().trim().toLowerCase();
	
			tokenise(input);
			System.out.println();
		} while(!input.equals("exit"));
		System.out.println("Goodbye");
	}

	private void tokenise(String input) {

		if(input.length() == 0) {
			System.out.println("You must type something!");
			return;
		}

		String[] words = input.split("\\s+", 2);

		if(words.length == 1) {
			parse(words[0]);
		}
		else if(words.length == 2) {
			parse(words[0], words[1]);
		}
		else {
			System.err.println("Too many words. Should not be possible!");
		}
	}

	// If 1 argument, then it's just a verb
	private void parse(String verb) {
		switch(verb) {
			case "exit": return;
			case "look": System.out.println("Look at what?");
						 currentRoom.printDescription();
						 currentRoom.printExits();
						 break;
			case "move": System.out.println("Move where?");
						 break;
			default:	 System.out.println("I do not know how to "+verb);
		}
	}

	// If 2 arguments, then it's verb and object
	private void parse(String verb, String object) {
		switch(verb) {
			case "move":	move(object);
							break;
			default: System.out.println("I do not know how to "+verb+" "+object);
		}
	}

	private void move(String to) {
		try {
			Room newRoom = currentRoom.throughDoor(to);
			this.currentRoom = newRoom;
			System.out.println("You are in a room...");
		} catch(Exception e) {
			System.out.println("Cannot move to "+to);
		}
	}
}
