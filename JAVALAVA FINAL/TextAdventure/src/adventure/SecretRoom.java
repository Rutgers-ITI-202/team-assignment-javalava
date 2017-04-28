package adventure;

public class SecretRoom implements Room {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 0.1N
	 * @notes look method that allows the use to look around the SECRET room 
	 */
	public int look(int x) {
			AdventureModel.ReadINI("0.1 D");	
		return x;
	}

	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 0.1N
	 * @notes look method that allows THE USER TO GO NORTH 
	 */

	public int goNorth(int x) {
			AdventureModel.ReadINI("0.1 N");
			AdventureModel.ReadINI("WOMAN");
			Adventurer.Progress.add("WOMAN APPROACHING");
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 0.1S
	 * @return VOID
	 * @notes look method that allows THE USER TO GO SOUTH
	 */
	public int goSouth(int x) {
			AdventureModel.ReadINI("0.1 S");
			Adventurer.Progress.add("IGNORED WOMAN");
			Adventurer.Progress.add("LEFT BLACK ROOM");
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 0.1E
	 * @return VOID
	 * @notes look method that allows THE USER TO GO EAST
	 */
	public int goEast(int x) {
			AdventureModel.ReadINI("0.1 E");
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 0.1W
	 * @return VOID
	 * @notes look method that allows THE USER TO GO WEST
	 */
	public int goWest(int x) {
				AdventureModel.ReadINI("0.1 W");

			return x;
		}

	public int take(int x) {
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords ACT, USE, GUN
	 * @return x
	 * @notes items method to use items and if not available to code stops running
	 */

	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("pistol") && Adventurer.Progress.contains("WOMAN APPROACHING")){
			AdventureModel.ReadINI("ACT 2");
			Adventurer.Progress.remove("WOMAN APPROACHING");
			Adventurer.Progress.add("SHOT WOMAN");
			AdventureModel.ReadINI("ACT 3");
			Adventurer.Progress.add("LEFT BLACK ROOM");
		} else if (select.equalsIgnoreCase("looked")) {
				return x; 
			} else if (Adventurer.Inventory.contains(select)){
						System.out.println("You can't use this here."); // if user uses item in wrong place
			} else if (select.equalsIgnoreCase("invalid")) {
				System.out.println("You can't do that.");
			} else if (select.equalsIgnoreCase("don't have")){
				System.out.println("You don't have that item.");
			}
			return x;
	
	}
	public int open(int x) {
		return x;
	}

	public int push(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}