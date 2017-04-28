package adventure;

public class Courtyard implements Room{
	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 7.1 D, 7.2 D
	 * @notes look method that allows the use to look around the COURTYARD room 
	 */
	@Override
	public int look(int x) {
		if (x==1){
			AdventureModel.ReadINI("7.1 D");
		} else if (x==2){
			AdventureModel.ReadINI("7.2 D");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 7.1N, 7.2N 
	 * @return x
	 * @notes Go north method to move forward
	 */
	@Override
	public int goNorth(int x) {
		if (x==1){
			AdventureModel.ReadINI("7.1 N");
		} else if (x==2){
			AdventureModel.ReadINI("7.2 N");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 7.1 S, 7.2 S
	 * @return x
	 * @notes Go SOUTH method to move forward
	 */
	@Override
	public int goSouth(int x) {
		if (x==1){
			AdventureModel.ReadINI("7.1 S");
		} else if (x==2){
			AdventureModel.ReadINI("7.2 S");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 7.1 E, 7.2 E 
	 * @return x
	 * @notes Go EAST method to move forward
	 */
	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("7.1 E");
			Adventurer.Progress.add("COURTYARD CHECKPOINT");
		} else if (x==2){
			AdventureModel.ReadINI("7.2 E");
			Adventurer.Progress.add("COURTYARD CHECKPOINT");
		}
		return x;
		
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 7.1 W, 7.2 W
	 * @return x
	 * @notes Go WEST method to move forward
	 */
	@Override
	public int goWest(int x) {
		if (x==1){
			AdventureModel.ReadINI("7.1 W");
			x = 2;
		} else if (x==2){
			AdventureModel.ReadINI("7.2 W");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords NA
	 * @return x
	 * @notes take method 
	 */
	@Override
	public int take(int x) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 7.2 U, PISTOL
	 * @return x
	 * @notes items method to use items and if not available to code stops running
	 */
	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
	if (select.equalsIgnoreCase("pistol") && x == 2 && Adventurer.Inventory.contains("pistol")){
			AdventureModel.ReadINI("7.2 U");
			Adventurer.Progress.add("DOG KILLED");
	} else if (Adventurer.Inventory.contains(select)){
		System.out.println("You can't use this here."); // if user uses item in wrong place
	} else if (select.equalsIgnoreCase("invalid")) {
		System.out.println("You can't do that.");
	} else if (select.equalsIgnoreCase("don't have")){
		System.out.println("You don't have that item.");
	}
		return x;
	
	}

	@Override
	public int open(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int push(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}