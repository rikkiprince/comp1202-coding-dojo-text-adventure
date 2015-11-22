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

		System.out.print("> ");
		input = this.in.nextLine();

		System.out.println(input);
	}
}