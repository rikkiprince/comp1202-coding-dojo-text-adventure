public class GameMap {
	Room[][] rooms = new Room[100][100];

	public void setRoom(Integer x, Integer y, Room r) {
		this.rooms[x][y] = r;
	}
}