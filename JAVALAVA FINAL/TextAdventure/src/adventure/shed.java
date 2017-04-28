package adventure;

public class shed implements Room{
	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 8.1D,8.21D, 8.2 D,8.31D, 8.3D, 8.4D
	 * @notes look method that allows the use to look around the bunker room 
	 */

		public int look(int x) {
			if (x == 1){
				AdventureModel.ReadINI("8.1 D");	
			} else if (x==2 && Adventurer.Progress.contains("SECRET DOOR OPEN")){
				AdventureModel.ReadINI("8.21D");
			} else if (x == 2){
				AdventureModel.ReadINI("8.2 D"); 
			} else if (x == 3 && Adventurer.Progress.contains("SECRET DOOR OPEN")){
				AdventureModel.ReadINI("8.31D"); 
			} else if (x == 3){
				AdventureModel.ReadINI("8.3 D");
			} else if (x==4){
				AdventureModel.ReadINI("8.4 D");
			}
			return x;
		}

		/**
		 * @constructor public method
		 * @param x
		 * @keywords North, 8.1N,8.2N, 8.3 N, 8.4 N
		 * @return VOID
		 * @notes Go north method to move forward
		 */
	@Override
	public int goNorth(int x) {
		if  (x ==1){   
			AdventureModel.ReadINI("8.1 N");
			x = 3;
		} else if (x==3 && Adventurer.Progress.contains("SECRET DOOR OPEN")){
			AdventureModel.ReadINI("8.31N");
			Adventurer.Progress.add("SHED CHECKPOINT");
		} else if (x==2){
			AdventureModel.ReadINI("8.2 N");
		} else if (x==3){
			AdventureModel.ReadINI("8.3 N");;
		} else if (x==4){
			AdventureModel.ReadINI("8.4 N");
			x = 1;
		}
		return x; 
		} 
	

/**
	 * @constructor public method
	 * @param south
	 * @keywords 8.1S,8.2S,8.3S
	 * @return VOID
	 * @notes go south,
	 */

	@Override
	public int goSouth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("8.1 S"); // can't go back to the room
			x = 4;
		} else if (x == 2){
			AdventureModel.ReadINI("8.2 S");
		} else if (x ==3){
			AdventureModel.ReadINI("8.3 S");
			x = 1;
		} else if (x==3){
			AdventureModel.ReadINI("8.4 S");
		}
		return x;
	}
	/**
	 * @constructor public metho
	 * @param x
	 * @keywords 8.1e,8.2e,8.3e,8.4E
	 * @return x
	 * @notes the goeast method reads the INI file 
	 */

	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("8.1 E");
			x = 2;
		} else if (x == 2){
			AdventureModel.ReadINI("8.2 E");
		} else if (x ==3){
			AdventureModel.ReadINI("8.3 E");
		} else if (x ==4){
			AdventureModel.ReadINI("8.4 E");
		}
		return x;
	}

/**
	 * @constructor public method
	 * @param x
	 * @keywords 8.1W, 8.2W,8.3W
	 * @return x
	 * @notes gowest read ini File
	 */

	@Override
		public int goWest(int x) {
			if (x == 1){
				AdventureModel.ReadINI("8.1 W");
			} else if (x == 2){
				AdventureModel.ReadINI("8.2 W");
				x = 1;
			} else if (x ==3){
				AdventureModel.ReadINI("8.3 W");
			} else if (x ==4){
				AdventureModel.ReadINI("8.4 W");
			}
			return x;
		}

	/**
	 * @constructor public method
	 * @param x
	 * @keywords 8.1U, 8.2U,8.4u
	 * @return VOID
	 * @notes items method to use items and if not available to code stops running
	 */


	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory(); 
		  if (select.equalsIgnoreCase("looked")) {
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
	 * @keywords 8.2 GOLDEN KEY
	 * @return x
	 * @notes METHOD USED TO OPEN OBJECTS AND ITEMS
	 */

	@Override
	public int open(int x) {
		if (x == 2 && Adventurer.Inventory.contains("golden key")==false){
			AdventureModel.ReadINI("8.2 O");
			Adventurer.Inventory.add("golden key");
		} else if (x == 2 && Adventurer.Inventory.contains("golden key")){
			AdventureModel.ReadINI("8.21O");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
	}


	@Override
	public int push(int x) {   // no pushes for the door 
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @constructor public method
	 * @param x
	 * @keywords 6.2T, SECRET DOOR
	 * @return x
	 * @notes USED TO OPEN SECRET DOOR
	 */
	@Override
	public int take(int x) {
		if (x==2 && Adventurer.Progress.contains("SECRET DOOR OPEN") == false){
			AdventureModel.ReadINI("8.2 T");
			Adventurer.Progress.add("SECRET DOOR OPEN");
			Adventurer.Inventory.add("book");
		} else {
			System.out.println("There's nothing to take here.");
		}
		return x;
	}

}