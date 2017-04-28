package adventure;

public class bunkroom implements Room{

	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 6.1D, 6.2 D, 6.3D
	 * @notes look method that allows the use to look around the bunker room 
	 */

	@Override
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("6.1 D");
		} else if (x == 2){
			AdventureModel.ReadINI("6.2 D");
		} else if (x== 3 && Adventurer.Inventory.contains("picture")){
			AdventureModel.ReadINI("6.31D");
		} else if (x==3){
			AdventureModel.ReadINI("6.3 D");
		}
		return x;
	}

	@Override
	/**
	 * @constructor public method
	 * @param x
	 * @keywords North, 6.1N,6.2N, 6.3 N, 6.4 N
	 * @return x
	 * @notes Go north method to move forward
	 */

	public int goNorth(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("6.1 N");
			x = 2;
		} else if (x==2){
			AdventureModel.ReadINI("6.2 N");
		} else if (x==3){
			AdventureModel.ReadINI("6.3 N");;
		} 
		return x;

	}
	/**
	 * @constructor public method
	 * @param south
	 * @keywords 6.1,6.2,6.3s
	 * @return x
	 * @notes go south,
	 */

	@Override
	public int goSouth(int x) {                 // nothing is south -- leave south  as "nothing is here" 
		if (x == 1){
			AdventureModel.ReadINI("6.1 S");
		} else if (x == 2){
			AdventureModel.ReadINI("6.2 S");
			x = 1;
		} else if (x ==3){
			AdventureModel.ReadINI("6.3 S");
		}
		return x;
	}
	
	/**
	 * @constructor public metho
	 * @param x
	 * @keywords 6.1e,6.2e,6.3e,6.4E
	 * @return x
	 * @notes the goeast method reads the INI file 
	 */
	
	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("6.1 E");
			x = 3;
		}else if (x == 2){
			AdventureModel.ReadINI("6.2 E"); 
		} else if (x == 3){
			AdventureModel.ReadINI("6.3 E");
	}
		return x;
	}
	
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 6.1W, 6.2W,6.3W
	 * @return x
	 * @notes gowest read ini File
	 */
	@Override
	public int goWest(int x) {                                 // window user can exit out window here 
		if  (x ==1){
			AdventureModel.ReadINI("6.1 W");
		} else if (x==2){
			AdventureModel.ReadINI("6.2 W");
		} else if (x==3){
			AdventureModel.ReadINI("6.3 W");
			x = 1;
		} 
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 6.1T, Rope
	 * @return x
	 * @notes take method and use  rope to use method
	 */

	@Override
	public int take(int x) {
		if (x == 3 && Adventurer.Inventory.contains("picture") == false){
			AdventureModel.ReadINI("6.3 T");
			Adventurer.Inventory.add("picture");
			Adventurer.Progress.add("CLUE 4 OBTAINED");
		} else {
			System.out.println("You can't take anything here.");
		}
		return x;
	}
	
	
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 6.1U, Rope, 6.2U,6.4u
	 * @return x
	 * @notes items method to use items and if not available to code stops running
	 */

	
	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("rope") && x == 2){
			AdventureModel.ReadINI("6.2 U");
			Adventurer.Inventory.remove("rope");
			AdventureModel.ReadINI("CRTYD");
			Adventurer.Progress.add("BUNK CHECKPOINT");
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


	@Override
	public int push(int x) {          // no pushing
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int open(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
