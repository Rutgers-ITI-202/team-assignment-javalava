package adventure;

/**
 * @constructor - public 
 * @parameters Takes x - Location 
 * @Key words - Green Door - Red Door
 * @Return - void
 * @Notes This is the method for the textile room
 *
 */

public class Hallway implements Room{

	@Override
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("2.1 D");
		} else if (x == 2 && Adventurer.Progress.contains("GREEN DOOR UNLOCKED") == true){
			AdventureModel.ReadINI("2.21D");
		} else if (x == 2){
			AdventureModel.ReadINI("2.2 D");
		}else if (x == 3 && Adventurer.Inventory.contains("green key") == true){
			AdventureModel.ReadINI("2.31D");
		} else if (x ==3 ){
			AdventureModel.ReadINI("2.3 D");
		} else if (x == 4 && Adventurer.Progress.contains("RED DOOR UNLOCKED") == true){
			AdventureModel.ReadINI("2.41D");
		} else if (x ==4){
			AdventureModel.ReadINI("2.4 D");
		} else if (x == 5 && Adventurer.Progress.contains("YELLOW DOOR UNLOCKED") == true){
			AdventureModel.ReadINI("2.51D");
		} else if (x == 5) {
			AdventureModel.ReadINI("2.5 D");
		}
		return x;
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words
	 * @Return - void
	 * @Notes This is a method used for moving the user north
	 *
	 */

	@Override
	public int goNorth(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("2.1 N");
		} else if (x==2){
			AdventureModel.ReadINI("2.2 N");
			x = 1;
		} else if (x==3){
			AdventureModel.ReadINI("2.3 N");
			x = 5;
		} else if (x==4){
			AdventureModel.ReadINI("2.4 N");
			x = 3;
		} else if (x==5 && Adventurer.Progress.contains("YELLOW DOOR UNLOCKED")== true){
			AdventureModel.ReadINI("2.51N");
			Adventurer.Progress.remove("TEXTILE CHECKPOINT");
			Adventurer.Progress.add("HALLWAY CLEARED CHECKPOINT");
		} else if (x == 5) {
			AdventureModel.ReadINI("2.5 N");
		}
		return x;
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words - red key - green key
	 * @Return - void
	 * @Notes This is a method used for moving the user south
	 *
	 */
	@Override
	public int goSouth(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("2.1 S");
			x = 2;
		} else if (x==2 && Adventurer.Inventory.contains("red key")){
			AdventureModel.ReadINI("2.22S");
		} else if (x==2 && Adventurer.Inventory.contains("green key")){
			AdventureModel.ReadINI("2.21S");
			Adventurer.Progress.add("HALLWAY 1 CHECKPOINT");
		} else if (x==2){
			AdventureModel.ReadINI("2.2 S");
		} else if (x== 3){
			AdventureModel.ReadINI("2.3 S");
			x = 4;
		}  else if (x==4 && Adventurer.Inventory.contains("yellow key")){
			AdventureModel.ReadINI("2.42S");
		} else if (x==4 && Adventurer.Progress.contains("RED DOOR UNLOCKED")){
			AdventureModel.ReadINI("2.41S");
			Adventurer.Progress.add("HALLWAY 2 CHECKPOINT");
		} else if (x==4){
			AdventureModel.ReadINI("2.4 S");
		}else if (x == 5) {
			AdventureModel.ReadINI("2.5 S");
			x = 3;
		}
		return x;
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words
	 * @Return - void
	 * @Notes This is a method used for moving the user East
	 *
	 */

	@Override
	public int goEast(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("2.1 E");
			x = 3;
		} else if (x==2){
			AdventureModel.ReadINI("2.2 E");
			x = 4;
		} else if (x==3){
			AdventureModel.ReadINI("2.3 E");
		} else if (x==4){
			AdventureModel.ReadINI("2.4 E");
		} else if (x == 5) {
			AdventureModel.ReadINI("2.5 E");
		}
		return x;
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words
	 * @Return - void
	 * @Notes This is a method used for moving the user west
	 *
	 */

	@Override
	public int goWest(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("2.1 W");
		} else if (x==2){
			AdventureModel.ReadINI("2.2 W");
		} else if (x==3){
			AdventureModel.ReadINI("2.3 W");
			x = 1;
		} else if (x==4){
			AdventureModel.ReadINI("2.4 W");
			x = 2;
		} else if (x == 5) {
			AdventureModel.ReadINI("2.5 W");
		}
		return x;
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x integer
	 * @Key words GreenKey 
	 * @Return - void
	 * @Notes This is a method used for having the user take items from the room
	 *
	 */
	@Override
	public int take(int x) {
		if (x == 3 && Adventurer.Inventory.contains("green key") == false){
			AdventureModel.ReadINI("2.3 T");
		} else if (x == 3 && Adventurer.Inventory.contains("green key")){
			AdventureModel.ReadINI("2.31U");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
		
		
	}
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words
	 * @Return - void
	 * @Notes This is a method used for having the user use items in this room
	 *
	 */

	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
		if (select.equalsIgnoreCase("rope") && x == 3 && Adventurer.Inventory.contains("green key")){
			AdventureModel.ReadINI("2.31U");
		} else if (select.equalsIgnoreCase("rope") && x == 3){
			AdventureModel.ReadINI("2.3 U");
			Adventurer.Inventory.add("green key");
		} else if (select.equalsIgnoreCase("green key") && x ==2){
			AdventureModel.ReadINI("2.2 U");
			Adventurer.Progress.add("GREEN DOOR UNLOCKED");
		} else if (select.equalsIgnoreCase("red key") && x == 4){
			AdventureModel.ReadINI("2.4 U");
			Adventurer.Progress.add("RED DOOR UNLOCKED");
		} else if (select.equalsIgnoreCase("yellow key") && x ==5){
			AdventureModel.ReadINI("2.5 U");
			Adventurer.Progress.add("YELLOW DOOR UNLOCKED");
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
	/**
	 * @constructor - public 
	 * @parameters Takes x - Location 
	 * @Key words
	 * @Return - void
	 * @Notes This is a method used for having the user open areas in the room
	 *
	 */
	@Override
	public int open(int x) {
		if (x==2 && Adventurer.Progress.contains("GREEN DOOR UNLOCKED")){
			AdventureModel.ReadINI("2.21O");
		} else if (x==2){
			AdventureModel.ReadINI("2.2 O");
		} else if (x==4 && Adventurer.Progress.contains("RED DOOR UNLOCKED")){
			AdventureModel.ReadINI("2.41O");
		} else if (x==4){
			AdventureModel.ReadINI("2.4 O");
		} else if (x==5 && Adventurer.Progress.contains("YELLOW DOOR UNLOCKED")){
			AdventureModel.ReadINI("2.21O");
		} else if (x==5){
			AdventureModel.ReadINI("2.2 O");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
	}

	@Override
	public int push(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}