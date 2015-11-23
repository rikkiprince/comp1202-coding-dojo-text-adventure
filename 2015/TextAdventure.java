import java.util.*;

public class TextAdventure {
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Scanner in;
	private Room[][] map;
	private Integer x, y;

	public TextAdventure() {
		this.in = new Scanner(System.in);
		
		Room a = new Room();
		Room b = new Room();
		a.setExit("east", b);
		b.setExit("west", a);


	}

	private void play() {
		String input;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");
		System.out.println("What do you want to do?");

		do {
			System.out.println("You are at "+x+","+y);
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
						 break;
			case "move": System.out.println("Move where?");
						 break;
			case "n":	 System.out.println("Move north");
						 y = y - 1;
						 break;
			case "e":	 System.out.println("Move east");
						 x = x + 1;
						 break;
			case "s":	 System.out.println("Move south");
						 y = y + 1;
						 break;
			case "w":	 System.out.println("Move west");
						 x = x - 1;
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
}