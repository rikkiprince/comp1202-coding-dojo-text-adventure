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
		
		Room a = new Room("You are in 7/3009. There are lots of undergraduates.");
		Room b = new Room("This is a corridor. 300 people are trying to leave 7/3009 while 300 are trying to get in.");
		a.setExit("east", b);
		b.setExit("west", a);

		this.currentRoom = a;

	}

	private void play() {
		String input;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");

		do {
			System.out.println("You are somewhere ");
			System.out.println("What do you want to do?");
			System.out.print("> ");
			input = this.in.nextLine();
	
			tokenise(input);
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
						 currentRoom.getExits();
						 break;
			case "move": System.out.println("Move where?");
						 break;
			case "n":	 System.out.println("Move north");
						 move("north");
						 break;
			case "e":	 System.out.println("Move east");
						 move("east");
						 break;
			case "s":	 System.out.println("Move south");
						 move("south");
						 break;
			case "w":	 System.out.println("Move west");
						 
						 break;
			default:	 System.out.println("I do not know how to "+verb);
		}
	}

	// If 2 arguments, then it's verb and object
	private void parse(String verb, String object) {
		switch(verb) {
			default: System.out.println("I do not know how to "+verb+" "+object);
		}
	}

	private void move(String to) {
		try {
			Room newRoom = currentRoom.throughDoor(to);
			this.currentRoom = newRoom;
		} catch(Exception e) {
			System.out.println("Cannot move to "+to);
		}
	}
}