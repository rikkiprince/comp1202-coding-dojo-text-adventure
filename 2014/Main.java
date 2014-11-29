import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.reflect.*;

public class Main {

	private static String prompt = "> ";
	private Map<String, String> commands;	// regex => method name in Player class


	public static Room loadRooms() {
		// paste in stuff
		Room kitchen = new Room("Your kitchen", "The kitchen is in a frightful state. In the corner the sink is piled high with crockery in a pool of putrescent water. A number of items are strewn close at hand.");
		Room garden = new Room("The garden", "The garden is largely unmaintained. Amongst the quivering blades of your meadow are strewn parts of your unfinished time machine.");
		Room university = new Room("The University of Southampton", "As you approach the towering edifice of the Gower building looms over you. The campus is quiet today with only a few comatose undergraduates trudging between buildings in the chill of the wind.");

		kitchen.linkRoom("south", garden);

		return kitchen;
	}



	public static void main(String[] args) {

		Main m = new Main();
		Room start = loadRooms();
		Player p = new Player(start);
		m.interact(p);

	}


	public Main() {
		this.commands = new HashMap<String, String>();
		setupCommands();
	}


	private void setupCommands() {
		commands.put("(exit|quit).*", "quit");
		commands.put("(look at) (.+)", "inspect");	// example - might not keep
	}


	private void interact(Player player) {
		System.out.println("   /===============================/");
		System.out.println("  / Welcome to Unventure          / ");
		System.out.println(" / the COMP1202 Coding Dojo game /  ");
		System.out.println("/===============================/   ");

		boolean running = true;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while(running) {

			// Prompt for input ("wat do?")
			try  {
				// Extra line to space out the responses and make it more readable
				System.out.println();

		System.out.println("You are in "+player.getRoom().getName());
		System.out.println(player.getRoom().getDescription());

				System.out.print(Main.prompt);
				String userInput = input.readLine();



				//------------------------------------------------------------
				// Fancy attempt at handling as many common cases as possible.
				//------------------------------------------------------------
				if(jazzyHandling(userInput, player)) {
					continue;
				}



				//******************************************
				// Manual approach (in case the above fails)
				//******************************************

				String[] sentence = userInput.split("\\s+");

				// No input
				if (sentence.length < 1) {
					System.out.println("Huh?");
					continue;

				// Too many words, waah!
				} 
				else if(sentence.length > 2){
					System.out.println("You're being too clever for my simple two-word brain :-(");
					continue;
				}

				// NB we will lowercase all verbs and actions to make life easier

				// We have one or two words, first is the verb
				String verb = sentence[0].toLowerCase();
				
				// Second is the noun if we have one
				String noun = null;
				if (sentence.length == 2) {
					noun = sentence[1].toLowerCase();
				}

				// Quit and exit are easy...
				if ("quit".equals(verb) || "exit".equals( verb)) {
						// Don't really need to set running = false, but just in case...
						running = false;
						break;
				}

				/* 1-word actions */
				if(noun == null) {
					// Look around
					if("look".equals(verb)) {
						//System.out.println(player.look());
					}
	
					else {
							System.out.println("I DO NOT KNOW WHAT YOU ARE BLATHERING ABOUT.");
					}


				/* 2-word actions */
				}
				else {

					System.out.println("You have chosen to "+verb+" a "+noun);

				
				}


			}

			// lolololol...
			catch(IOException io) {
				System.out.println("Something bad happened :-( Try something else.");
			}

		}
	}


	/**
	  * Do not copy this code as an example. It uses reflection and a lot of other 
	  * mess to make my life easier in the dojo.
	  */
	public boolean jazzyHandling(String userInput, Player player) {
		// check all regexes
		for(Map.Entry<String, String> command : this.commands.entrySet()) {
			String regex = command.getKey();
			String methodName = command.getValue();
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(userInput);
			if(m.matches()) {
				// get groups of matches
				String commandName = m.group(1);
				List<String> argList = new ArrayList<String>();
				//Class[] argTypes = new Class[m.groupCount()-1];
				for(Integer c = 2; c <= m.groupCount(); c++) {
					argList.add(m.group(c));
					//argTypes[c-2] = String.class;
				}
				Class[] argTypes = generateArrayOfClass(m.groupCount()-1, String.class);
				String[] args = new String[argList.size()];
				args = argList.toArray(args);

				if(executeMethod(player, methodName, argTypes, args))
					return true; // First one that successfully invokes wins, so return that we've handled this
				else
					continue;
			}
		}

		// else split by spaces and look for method in [0] with n-1 args
		{
			String[] sentence = userInput.split("\\s+");
			String methodName = sentence[0];
			Class[] argTypes = generateArrayOfClass(sentence.length-1, String.class);
			String[] args = Arrays.copyOfRange(sentence, 1, sentence.length);
			if(executeMethod(player, methodName, argTypes, args))
				return true;
		}

		// else split on first space for method in [0] with 1 arg?
		{
			Integer firstSpace = userInput.indexOf(" ");
			String methodName = userInput.substring(0, firstSpace);
			String[] args = new String[1];
			args[0] = userInput.substring(firstSpace+1, userInput.length());
			Class[] argTypes = generateArrayOfClass(1, String.class);
			if(executeMethod(player, methodName, argTypes, args))
				return true;
		}


		return false;
	}

	private static boolean executeMethod(Object o, String methodName, Class[] argTypes, Object[] args) {
		//System.err.println("Trying: "+o.getClass().getName()+"."+methodName+"("+Arrays.toString(args)+")");
		try {
			Method method = o.getClass().getMethod(methodName, argTypes);
			method.invoke(o, args);
			
			return true;
		}
		catch(NoSuchMethodException nsme) {
			return false;
		}
		catch(IllegalAccessException iae) {
			return false;
		}
		catch(InvocationTargetException ite) {
			return false;
		}
	}
	private static Class[] generateArrayOfClass(Integer howMany, Class type) {
		Class[] types = new Class[howMany];
		for(Integer n = 0; n < types.length; n++) {
			types[n] = type;
		}
		return types;
	}
}
