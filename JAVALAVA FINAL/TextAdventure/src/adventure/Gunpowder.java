package adventure;

public class Gunpowder implements Room{
	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 5.1D, 5.2 D, 5.3D 5.41D, 5.4D 5.51D 5.5D,  PISTOL
	 * @notes look method that allows the use to look around the GUNPOWDER room 
	 */
	@Override
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("5.1 D");	 
		}else if (x == 2){
			AdventureModel.ReadINI("5.2 D"); 
		} else if (x == 3){
			AdventureModel.ReadINI("5.3 D");
		} else if (x ==4 && Adventurer.Inventory.contains("pistol")){
			AdventureModel.ReadINI("5.41D");
		} else if (x == 4){
			AdventureModel.ReadINI("5.4 D");
		} else if (x == 5 && Adventurer.Inventory.contains("pistol")){
			AdventureModel.ReadINI("5.51D");
		} else if (x == 5){
			AdventureModel.ReadINI("5.5 D");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords North, 5.1N, 5.2N, 5.3 N, 5.4 N
	 * @return x
	 * @notes Go north method to move forward
	 */
	@Override
	public int goNorth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("5.1 N");
			x = 3;
		}else if (x == 2){
			AdventureModel.ReadINI("5.2 N"); 
		} else if (x == 3){
			AdventureModel.ReadINI("5.3 N");
		} else if (x==4){
			AdventureModel.ReadINI("5.4 N");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords SOUTH, 5.1S , 6.2S, 6.3 S, 6.4 S
	 * @return x
	 * @notes Go SOUTH method to move forward
	 */
	@Override
	public int goSouth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("5.1 S");
			x = 3;
		}else if (x == 2){
			AdventureModel.ReadINI("5.2 S"); 
		} else if (x == 3){
			AdventureModel.ReadINI("5.3 N");
			x = 1;
		} else if (x==4){
			AdventureModel.ReadINI("5.4 N");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords EAST, 5.1E , 6.2E, 6.3 E, 6.4E
	 * @return x
	 * @notes Go EAST method to move forward
	 */
	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("5.1 E");
		}else if (x == 2){
			AdventureModel.ReadINI("5.2 E"); 
			x =3;
		} else if (x == 3){
			AdventureModel.ReadINI("5.3 E");
			x = 4;
		} else if (x==4){
			AdventureModel.ReadINI("5.4 E");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords WEST, 5.1W , 6.2W, 6.3 W, 6.4 W
	 * @return VOID
	 * @notes Go WEST method to move forward
	 */
	@Override
	public int goWest(int x) {
		if (x == 1){
			AdventureModel.ReadINI("5.1 W");
		}else if (x == 2){
			AdventureModel.ReadINI("5.2 W"); 
		} else if (x == 3){
			AdventureModel.ReadINI("5.3 W");
			x = 2;
		} else if (x==4){
			AdventureModel.ReadINI("5.4 W");
			x = 3;
		}
		return x;
	}

/**
	 * @constructor public method
	 * @param x
	 * @keywords 5.5 T, PISTOL
	 * @return VOID
	 * @notes take method and use  rope to use method
	 */
	@Override
	public int take(int x) {
		if (x==5 && Adventurer.Inventory.contains("pistol")==false){
			AdventureModel.ReadINI("5.5 T");
			Adventurer.Inventory.add("pistol");
			x = 4;
		} else {
			System.out.println("You can't do this here.");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 5.2 U, 5.3 U, 5.4 U, LIGHTER
	 * @return VOID
	 * @notes items method to use items and if not available to code stops running
	 */

	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("lighter") && x == 2){
			AdventureModel.ReadINI("5.2 U");
		} else if (select.equalsIgnoreCase("lighter") && x == 3){
			AdventureModel.ReadINI("5.3 U");
		} else if (select.equalsIgnoreCase("lighter") && x == 4){
			AdventureModel.ReadINI("5.4 U");
			Adventurer.Inventory.remove("lighter");
			AdventureModel.ReadINI("HALFD");
			Adventurer.Progress.add("GUNPOWDER CHECKPOINT");
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
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 5.5D, 5.4D, 5.5 D
	 * @return VOID
	 * @notes OPEN METHOD USED TO OPEN ITEMS AND OBJECTS and if not available to code stops running
	 */

	@Override
	public int open(int x) {
		if (x == 4 && Adventurer.Inventory.contains("pistol")){
			AdventureModel.ReadINI("5.51D");
		} else if (x == 4){
			AdventureModel.ReadINI("5.4 O");
			AdventureModel.ReadINI("5.5 D");
			x = 5;
		} else {
			System.out.println("You can't do this here.");
		}
		return x;
	
	}

	@Override
	public int push(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}