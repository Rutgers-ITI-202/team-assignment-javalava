package adventure;

public class BreakRoom implements Room{

/**
 * @constructor public
 * @param look, x 
 * @returns x
 * @keyboards Breakroom,  look 
 * @notes inni file for  method look

 */

// first room
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("1.1 D");	
		} else if (x == 2 && Adventurer.Progress.contains("BLUE DOOR UNLOCKED")){
			AdventureModel.ReadINI("1.21D");
		}else if (x == 2){
			AdventureModel.ReadINI("1.2 D"); 
		} else if (x == 3 && Adventurer.Inventory.contains("blue key") == true){
			AdventureModel.ReadINI("1.31D");
		} else if (x == 3){
			AdventureModel.ReadINI("1.3 D");
		} else if (x ==4 && Adventurer.Inventory.contains("blue key") == true){
			AdventureModel.ReadINI("1.41D");
			x = 3;
		} else if (x ==4){
			AdventureModel.ReadINI("1.4 D");
		}
		return x;
	}
	/**
	 * @constructor public 
	 * @param x 
	 * @returns x
	 * @keyboards 1.1 N 1.2N
	 * @note  Go North ini file
	 */

	public int goNorth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("1.1 N");	
		} else if (x == 2){
			AdventureModel.ReadINI("1.2 N");
			x = 1;
		} else {
			System.out.println("You can't go there right now.");
		} 
		return x;
	}

/**
	 * @constructor public
	 * @param  x  
	 * @returns x
	 * @keyboards Breakroom,  gosouth 
	 * @notes inni file for  method look

	 */

	@Override
	public int goSouth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("1.1 S");
			x = 2;
		} else if (x == 2 && Adventurer.Progress.contains("BLUE DOOR UNLOCKED")){
			AdventureModel.ReadINI("1.21S");
			Adventurer.Progress.add("BREAK ROOM CHECKPOINT");
		} else if (x == 2){
			AdventureModel.ReadINI("1.2 S");
		} else {
			System.out.println("You can't go there right now.");
		}
		return x;
	}

	/**
	 * @constructor public 
	 * @param x 
	 * @returns x
	 * @keyboards 1.1 E
	 * @note  Go east inni file
	 */
	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("1.1 E");
			x = 3;
		} else {
			System.out.println("You can't go there right now.");
		}
		return x;
	}
	/**
	 * @constructor public 
	 * @param x 
	 * @returns x
	 * @keyboards 1.1 W 1.3W
	 * @note  Go West inni file
	 */

	@Override
	public int goWest(int x) {
		if (x == 1){
			AdventureModel.ReadINI("1.1 W");
			x = 2;
		} else if (x == 3){
			AdventureModel.ReadINI("1.3 W");
			x = 1;
		}
		else {
			System.out.println("You can't go there right now.");
		}
		return x;
	}
	/**
	 * @constructor public
	 * @param x 
	 * @returns x
	 * @keyboards blue key, 1.4 T
	 * @note Taking file.  
	 */

	@Override
	public int take(int x) {
		if (x == 4){
			AdventureModel.ReadINI("1.4 T");
			Adventurer.Inventory.add("blue key");
			x = 3;
		} else {
			System.out.println("You can't do that now.");
		}
		return x;
	}
	/**
	 * @constructor public
	 * @param x 
	 * @returns x
	 * @keyboards blue key, 1.21U 
	 * @note Items file.  
	 */

	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("blue key") && x == 2){
			AdventureModel.ReadINI("1.21U");
			Adventurer.Progress.add("BLUE DOOR UNLOCKED");
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
	 * @returns x
	 * @keyboards bluekey, 1.4D, inni files
	 * @notes  The inni files for method Open 
	 */
	@Override
	public int open(int x) {
		if (x == 3 && Adventurer.Inventory.contains("blue key")){
			AdventureModel.ReadINI("1.41D");
		} else if (x == 3){
			AdventureModel.ReadINI("1.3 O");
			AdventureModel.ReadINI("1.4 D");
			x = 4;
		} else if (x == 2 && Adventurer.Progress.contains("BLUE DOOR UNLOCKED")){
			AdventureModel.ReadINI("1.21O");
		} else if (x == 2){
			AdventureModel.ReadINI("1.2 O");
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