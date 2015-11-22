import java.util.*;

public class TextAdventure {
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Scanner in;

	public TextAdventure() {
		this.in = new Scanner(System.in);
	}

	private void play() {
		String input;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");
		System.out.println("What do you want to do?");

		do {
			System.out.print("> ");
			input = this.in.nextLine();
	
			tokenise(input);
		} while(!input.equals("exit"));
		System.out.println("Goodbye");
	}

	private void tokenise(String input) {
		System.out.println(input);

		String[] words = input.split("\\s+", 2);

		if(words.length == 0) {
			System.out.println("You must type something!");
		}
		else if(words.length == 1) {
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
			case "look": System.out.println("Look at what?");
			case "move": System.out.println("Move where?");
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