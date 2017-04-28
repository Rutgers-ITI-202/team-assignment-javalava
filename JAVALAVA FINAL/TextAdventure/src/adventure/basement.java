package adventure;

public class basement implements Room  {

	/**
	 * @constructor public method
	 * @param x
	 * @keywords look, x, 
	 * @return 9.1D, 9.2 D, 9.3D
	 * @notes look method that allows the use to look around the basement room 
	 */


		// TODO Auto-generated method stub
		public int look(int x) {
			if (x ==1 && Adventurer.Progress.contains("CAGE OPEN")){
				AdventureModel.ReadINI("9.11D");
		} else if (x == 1){
				AdventureModel.ReadINI("9.1 D");
			} else if (x==2 && Adventurer.Progress.contains("CAGE OPEN")){
				AdventureModel.ReadINI("9.21D");
			} else if (x == 2 && Adventurer.Progress.contains("CAGE OPEN") == false){
				AdventureModel.ReadINI("9.2 D"); 
			} else if (x == 3 && Adventurer.Progress.contains("LAST DOOR OPEN")){
				AdventureModel.ReadINI("9.31D");
			} else if (x == 3){
				AdventureModel.ReadINI("9.3 D");
			} else if (x ==4 && Adventurer.Progress.contains("BLACK DOOR OPEN")){
				AdventureModel.ReadINI("9.41D");
			} else if (x==4){
				AdventureModel.ReadINI("9.4 D");
			}
			return x;
		}

		/**
		 * @constructor public method
		 * @param x
		 * @keywords North, 9.1N, 9.2N, 9.3 N, 9.4 N
		 * @return x
		 * @notes Go north method to move forward
		 */
	public int goNorth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("9.1 N");
		} else if (x==2) {
			AdventureModel.ReadINI("9.2 N");
			x = 4;
		} else if (x ==3){
			AdventureModel.ReadINI("9.3 N");
		} else if (x==3 && Adventurer.Progress.contains("SHOT WOMAN") || Adventurer.Progress.contains("TOUCHED BY WOMAN") || Adventurer.Progress.contains("IGNORED WOMAN")){
			AdventureModel.ReadINI("9.42");
		} else if (x ==4 && Adventurer.Progress.contains("BLACK DOOR OPEN")){
			AdventureModel.ReadINI("9.41N");
			Adventurer.Progress.add("ENTERED BLACK ROOM");
		} else if (x == 4 && Adventurer.Progress.contains("CAGE OPEN") == false){
			AdventureModel.ReadINI("9.43N");
		} else if (x ==4){
			AdventureModel.ReadINI("9.4 N");
		}
		return x;
	}

	/**
	 * @constructor public method
	 * @param x
	 * @keywords North, 9.1s, 9.2s, 9.3 s, 9.4 s
	 * @return x
	 * @notes Go South method to move forward
	 */
	public int goSouth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("9.1 S");
		} else if (x == 2){
			AdventureModel.ReadINI("9.2 S");
		} else if (x ==3){
			AdventureModel.ReadINI("9.3 S");
		} else if (x==4){
			AdventureModel.ReadINI("9.4 S");
			x = 2;
		}
		return x;
	}
	
	/**
	 * @constructor public method
	 * @param x
	 * @keywords North, 9.1E, 9.2E, 9.3 E, 9.4 E
	 * @return x
	 * @notes Go EAST method to move forward
	 */
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("9.1 E");
		} else if (x == 2){
			AdventureModel.ReadINI("9.2 E");
			x = 1;
		} else if (x ==3){
			AdventureModel.ReadINI("9.3 E");
			x = 2;
		} else if (x==4){
			AdventureModel.ReadINI("9.4 E");
		}
		return x;
	}
	/**
	 * @constructor public method
	 * @param x
	 * @keywords WEST, 9.1W, 9.2W, 9.3 W, 9.4 W
	 * @return x
	 * @notes Go WEST method to move forward
	 */
		public int goWest(int x) {
			if (x == 1 && Adventurer.Progress.contains("CAGE OPEN")){
				AdventureModel.ReadINI("9.11W");
				x = 2;
			} else if (x ==1){
				AdventureModel.ReadINI("9.1 W");
				x = 2;
			} else if (x == 2){
				AdventureModel.ReadINI("9.2 W");
				x = 3;
			} else if (x ==3 && Adventurer.Progress.contains("LAST DOOR OPEN") && Adventurer.Progress.contains("CAGE OPEN")== false){
				AdventureModel.ReadINI("9.31W");
			} else if (x ==3 && Adventurer.Progress.contains("CAGE OPEN") && Adventurer.Progress.contains("LAST DOOR OPEN")){
				AdventureModel.EndingCheck();
			} else if (x == 3){
				AdventureModel.ReadINI("9.3 W");
			} else if (x==4){
				AdventureModel.ReadINI("9.4 W");
			}
			return x;
	}
		
	
	public int take(int x) {
		return x;
	}
		
	/**
	 * @constructor public method
	 * @param x
	 * @keywords 9.1U, CAGE, DOOR 9.2U
	 * @return x
	 * @notes items method to use items and if not available to code stops running
	 */


		public int items(int x) {
			String select = Adventurer.ReadInventory();
			if (x == 2 && Adventurer.Progress.contains("CAGE OPEN")==false && select.equalsIgnoreCase("golden key")){
				AdventureModel.ReadINI("9.2 U");
				Adventurer.Progress.add("CAGE OPEN");
		}  else if (x == 4 && Adventurer.Inventory.contains("black key")){
				AdventureModel.ReadINI("9.41U");
				Adventurer.Progress.add("BLACK DOOR OPEN");
		} else if (x == 3){
				AdventureModel.ReadINI("9.3 U");
				Adventurer.Progress.add("LAST DOOR OPEN");
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
