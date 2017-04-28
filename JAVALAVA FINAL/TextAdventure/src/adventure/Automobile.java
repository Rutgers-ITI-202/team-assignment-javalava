package adventure;

public class Automobile implements Room{
	/**
	 * @constructor public Method
	 * @param  x 
	 * @return none
	 * @keyboards redkey, conveyor belt on ,
	 * @notes Inni file for looking in automobile 
	 */

	@Override
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("3.1 D");
		} else if (x == 2 && Adventurer.Progress.contains("CONVEYOR BELT ON") && Adventurer.Progress.contains("RED KEY FELL")){
			AdventureModel.ReadINI("3.21D");
		} else if (x == 2 && Adventurer.Progress.contains("RED KEY FELL")){
			AdventureModel.ReadINI("3.23D");
		} else if (x== 2 && Adventurer.Inventory.contains("red key") && Adventurer.Progress.contains("RED KEY FELL")){
			AdventureModel.ReadINI("3.22D");
		} else if (x== 2){
			AdventureModel.ReadINI("3.2 D");
		} else if (x == 3 && Adventurer.Progress.contains("RED KEY FELL")){
			AdventureModel.ReadINI("3.31D");
		} else if (x == 3){
			AdventureModel.ReadINI("3.3 D");
		}
		return x;
	}
	/** 
	 * @constructor  public method
	 * @param x
	 * @keyboards red key, 3.11N, 3.1N, 3.2N, 3.3N
	 * @notes goNorth method and red key to open door
	 */

	@Override
	public int goNorth(int x) {
		if (x == 1 && Adventurer.Inventory.contains("red key")){
			AdventureModel.ReadINI("3.11N");
			Adventurer.Progress.remove("HALLWAY 1 CHECKPOINT");
			Adventurer.Progress.add("AUTOMOBILE CHECKPOINT");
		} else if (x==1){
			AdventureModel.ReadINI("3.1 N");
		} else if (x ==2){
			AdventureModel.ReadINI("3.2 N");
			x = 1;
		} else if (x ==3){
			AdventureModel.ReadINI("3.3 N");
		}
		return x;
	}
	/** 
	 * @constructor Public Method
	 * @param x
	 * @Keywords 3.1s, 3.2s,3.3S
	 * @return x
	 * @notes go south ini files
	 */

	@Override
	public int goSouth(int x) {
		if (x == 1){
			AdventureModel.ReadINI("3.1 S");
			x = 2;
		} else if (x == 2){
			AdventureModel.ReadINI("3.2 S");
		} else if (x ==3){
			AdventureModel.ReadINI("3.3 S");
		}
		return x;
	}
	/**
	 * @constructor Public Method
	 * @param x
	 * @keywords 3.1E, 3.2 E, 3.3 E
	 * @return x
	 * @notes GOeast method reading ini file
	 */
	@Override
	public int goEast(int x) {
		if (x == 1){
			AdventureModel.ReadINI("3.1 E");
		} else if (x == 2){
			AdventureModel.ReadINI("3.2 E");

		} else if (x ==3){
			AdventureModel.ReadINI("3.3 E");
			x = 1;
		}
		return x;
	}

/**
	 * @constructor  Public Method
	 * @param x
	 * @keywords 3.1 W, 3.2 W, 3.3 W
	 * @return x
	 * @notes Gowest method of reading in Ini files
	 */

	@Override
	public int goWest(int x) {
		if (x == 1){
			AdventureModel.ReadINI("3.1 W");
			x = 3;
		} else if (x == 2){
			AdventureModel.ReadINI("3.2 W");
		} else if (x ==3){
			AdventureModel.ReadINI("3.3 W");
		}
		return x;
	}
	/**
	 * @constructor Public Method
	 * @param x
	 * @keywords 3.3T,3.23T, 3.22T, 3.21T, 3.2 T
	 * @return x
	 * @notes Conveyor belt game,  3 times to grab the key of the game, 
	 */
	@Override
	public int take(int x) {
		if (x==3 && Adventurer.Progress.contains("RED KEY FELL")){
			System.out.println("You can't do that anymore.");
		} else if (x == 3){
			AdventureModel.ReadINI("3.3 T");
			Adventurer.Progress.add("RED KEY FELL");
		} else if (x == 2 && Adventurer.Progress.contains("CONVEYOR BELT TRY 3")){
			AdventureModel.ReadINI("3.23T");
			Adventurer.Progress.remove("CONVEYOR BELT TRY 3");
			Adventurer.Progress.add("CLUE 1 OBTAINED");
			for (int c = 1; c<=8;c++){
				AdventureModel.ReadINI("CLU1 "+c);
				}
		} else if (x == 2 && Adventurer.Progress.contains("CONVEYOR BELT TRY 2")){
			AdventureModel.ReadINI("3.22T");
			Adventurer.Progress.remove("CONVEYOR BELT TRY 2");
			Adventurer.Progress.add("CONVEYOR BELT TRY 3");
		} else if (x == 2 && Adventurer.Progress.contains("CONVEYOR BELT TRY 1")){
			AdventureModel.ReadINI("3.21T");
			Adventurer.Inventory.add("red key");
			Adventurer.Progress.remove("CONVEYOR BELT TRY 1");
			Adventurer.Progress.add("CONVEYOR BELT TRY 2");
		} else if (x == 2 && Adventurer.Progress.contains("CONVEYOR BELT ON")){
			AdventureModel.ReadINI("3.2 T");
			Adventurer.Progress.add("CONVEYOR BELT TRY 1");
		} else if (x == 2 && Adventurer.Progress.contains("CLUE 1 OBTAINED")){
			AdventureModel.ReadINI("3.24T");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
	}
	
	/** 
	 * @constructor public method
	 * @param X
	 * @keywords 3.3U, redkey,conveyor belt on 
	 * @return x
	 * @notes  used for accession items in the automobile room puzzles
	 */
	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("rope") && x == 3 && Adventurer.Progress.contains("RED KEY FELL") == false){
			AdventureModel.ReadINI("3.3 U");
			Adventurer.Inventory.add("red key");
			Adventurer.Progress.add("AUTOMOBILE COMPLETE");
		}  else if (select.equalsIgnoreCase("looked")) {
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
	public int open(int x) {
		// TODO Auto-generated method stub
		return 0;
	}
	/** 
	 * @constructor public method
	 * @param X
	 * @keywords 3.3U, redkey,conveyor belt on 
	 * @return x
	 * @notes  push for opening the button for conveyor belt.
	 */
	@Override
	public int push(int x) {
		if (x == 3 && Adventurer.Progress.contains("CONVEYOR BELT ON")){
			AdventureModel.ReadINI("3.32P");
		}	else if (x == 3 && Adventurer.Progress.contains("RED KEY FELL")){
			AdventureModel.ReadINI("3.31P");
			Adventurer.Progress.add("CONVEYOR BELT ON");
		} else if (x == 3){
			AdventureModel.ReadINI("3.3 P");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
		
	}

}