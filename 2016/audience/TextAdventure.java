import java.util.*;

public class TextAdventure {
	
	public static void main(String[] args) {
		TextAdventure textAdventure = new TextAdventure();
		textAdventure.play();
	}

	private Parser parser;
	
	public TextAdventure() {
		parser = new Parser();
	}

	private void play() {
		String action;

		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println(" Welcome to COMP1202 Adventure ");
		System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("");
		System.out.println("You are in a room...");

		do {

			parser.promptPlayer("What do you want to do?");

			action = parser.getAction();

		} while(!parser.getUserInput().equals("exit"));

		System.out.println("Goodbye");
	}

}
