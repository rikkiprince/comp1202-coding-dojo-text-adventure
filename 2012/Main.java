import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args){
		game();
	}
	public static void testHarness()
	{
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
	}

	public static Player load(String name)
	{
		/*
			S G
			L K
		*/

		Room lounge = new Room("Bilbo's lounge", "There is a burning fire in the corner.");
		lounge.addItem(new Fire());

		Room shire = new Room("Shire", "The shire seems peaceful; a horse and cart passes.");

		Room garden = new Room("Garden", "A rabbit darts out from between the cabbage patches.");

		Room kitchen = new Room("Kitchen", "A kettle gently whistles.");
		kitchen.addItem(new Item("kettle"));

		lounge.addExit(Room.NORTH, shire);
		shire.addExit(Room.EAST, garden);
		garden.addExit(Room.SOUTH, kitchen);
		kitchen.addExit(Room.WEST, lounge);

		return new Player(name, lounge);
	}

	public static void game()
	{
		Player p = load("Bilbo");

		System.out.println("   /===============================/");
		System.out.println("  / Welcome to Unventure          / ");
		System.out.println(" / the COMP1202 Coding Dojo game /  ");
		System.out.println("/===============================/   "); 

		System.out.println(p.whereAmI());

		System.out.print("\n> ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		try {
			while ((line = in.readLine()) != null){
				try{
					if(line.equals("exit") || line.equals("quit")) { 
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
						//System.out.println(p.describe());
					}
					else if(verb.equals("i")) {
						System.out.println(p.inventory());
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
