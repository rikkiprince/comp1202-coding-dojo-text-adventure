import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args){
		boolean test = false;
		Room first = new Room("Bilbo's lounge", "There is a burning fire in the corner.");
		first.addExit(Room.NORTH, new Room("Shire", "The shire seems pieceful a horse and cart passes."));

		System.out.println(first.describe());

		// Print a blank a new line
		System.out.println();

		Player p = new Player("Bilbo", first);
		Fire fire = new Fire();
		//p.pickup(fire);

		first.addItem(fire);

		Item apple = new Item("apple");
		ContainerItem box = new ContainerItem("casket");
		box.addItem(apple);
		p.pickup(box);
		box.addItem(fire);

		System.out.println(first.lookAt("fire"));

		if(test){
			System.out.println(p.describe());
			return;
		}

		System.out.println("   /===============================/");
		System.out.println("  / Welcome to Unventure          / ");
		System.out.println(" / the COMP1202 Coding Dojo game /  ");
		System.out.println("/===============================/   "); 

		System.out.println(first.describe());

		System.out.print("\n> ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		try {
			while ((line = in.readLine()) != null){
				try{
					if(line.equals("exit")) { 
						return; 
					}

					String[] tokens = line.split(" ");
					String verb = tokens[0];

					if(verb.equals("look")){
						String typeOfLook = tokens[1];
						if(typeOfLook.equals("at"))
						{
							System.out.println(p.lookAt(tokens));
						}
						else
						{
							System.err.println("I only know how to look at something");
						}
					}
					else if(verb.equals("move")) {
						String direction = tokens[1];
						System.out.println(p.move(direction));
						System.out.println(p.describe());
					}
					else {
						System.err.println("Unrecognised instruction");
					}

				}catch(Exception e){
					System.err.println("Exception: "+e.getMessage());
					e.printStackTrace();
				}
				System.out.print("\n> ");
			}
		} catch(IOException ioe) {
			System.err.println("Failed to read line from System.in");
			ioe.printStackTrace();
		}
	
	}

}
