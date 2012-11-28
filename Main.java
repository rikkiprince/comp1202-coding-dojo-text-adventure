public class Main {

	public static void main(String[] args){
		Room first = new Room("Bilbo's lounge", "There is a burning fire in the corner.");
		first.addExit(Room.NORTH, new Room("Shire", "The shire seems pieceful a horse and cart passes."));

		System.out.println(first.describe());

		Player p = new Player("Bilbo", first);
		p.pickup(new Item("fire"));
		System.out.println(p.describe());
	}

}
