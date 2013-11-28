import java.io.*;

class Main{

	// String to primpt the user for input, much like a shell
	private static String prompt = ">";

	
	public static void main(String[] args){

		// Still running? (i.e. not quit or exploding horribly)
		boolean running = true;

		// Need to read things from the user, do it with this...
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		/* State variables */

		// Game state, i.e. the world
		World gameState = new World();

		// Representation of the player
		Player player = gameState.getPlayer();

		// Which Room are we in?
		Room currentRoom = gameState.getStartingRoom();

		// Main game loop - read, eval, print stylee
		while(running){

			// TODO print current state
			//System.out.println("It is very dark. You are likely to be eaten by a grue.");
			System.out.println(currentRoom.getDescription());

			// Prompt for input ("wat do?")
			try{
				System.out.print(prompt);
				String userInput = input.readLine();

				String[] sentence = userInput.split(" ");

				// No input
				if (sentence.length < 1){
					System.out.println("Huh?");
					continue;

				// Too many words, waah!
				} 
				else if(sentence.length > 2){
					System.out.println("You're being too clever for my simple two-word brain :-(");
					continue;
				}

				// NB we will lowecase all verbs and actions to make life easier

				// We have one or two words, first is the verb
				String verb = sentence[0].toLowerCase();
				
				// Second is the noun if we have one
				String noun = null;
				if (sentence.length == 2){
					noun = sentence[1].toLowerCase();
				}

				// Quit and exit are easy...
				if ("quit".equals(verb) || "exit".equals( verb)){
						// Don't really need to set running = false, but just in case...
						running = false;
						break;
				}



				/* 1-word actions */
				if(noun == null){
					// Look around
					if("look".equals(verb)){
							System.out.println("Looking around...");
							if(currentRoom == null){
								System.out.println("You are in limbo! Waah!");
							} else{
								System.out.println(currentRoom.getDescription());
							}
					}
	
					else{
							System.out.println("I DO NOT KNOW WHAT YOU ARE BLATHERING ABOUT.");
					}


				/* 2-word actions */
				}
				else{

					// Examine item (or "look item" because people will do that)
					if("examine".equals(verb) || "look".equals(verb)){
						// Check for item in current room
						// If it doesn't exist...
						System.out.println("You do not see a '"+noun+"' here.");

						// If it does exist, describe() it
					}

					// Move to another room
					else if ("move".equals(verb) || "go".equals(verb)){
						System.out.println("Going "+noun);
					}

					// Fondle things
					else if ("touch".equals(verb)){
						System.out.println("It feels warm, and slightly moist.");
					}

					else if ("prod".equals(verb)){
						System.out.println("It wobbles slightly, but doesn't prod you back.");
					}
	
					else{
							System.out.println("I DO NOT KNOW WHAT YOU ARE BLATHERING ABOUT.");
					}
				
				}


			}
			catch(IOException io){
				System.out.println("Something bad happened :-( Try something else.");
			}

			// TODO Parse input
			
			// TODO update state
			
		}
	}

}
