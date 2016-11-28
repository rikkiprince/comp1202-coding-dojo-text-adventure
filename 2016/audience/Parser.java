import java.util.*;

public class Parser {
	
	private Scanner in;
	private String action;
	private ArrayList<String> arguments;
	private String input;

	public Parser() {
		in = new Scanner(System.in);
		arguments = new ArrayList<String>();
	}

	public boolean promptPlayer(String promptText) {
		System.out.println(promptText);
		System.out.print("> ");
		input = this.in.nextLine();

		tokenise(input);
		System.out.println();
		return input.length() == 0;
	}

	public String getAction() { 
		return this.action;
	}

	public ArrayList<String> getArguements() {
		return arguments;
	}

	public String getUserInput() {
		return input;
	}

	private void tokenise(String input) {
		
		input = input.trim().toLowerCase();
		if(input.length() == 0) {
			System.out.println("You must type something!");
			return;
		}

		String[] words = input.split("\\s+");

		if(words.length < 0 || words.length > 2) {
			System.out.println("Instruction too long, I only understand 1 or 2 words");
		}	

		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));
		
		action = wordList.remove(0);
	}

}
