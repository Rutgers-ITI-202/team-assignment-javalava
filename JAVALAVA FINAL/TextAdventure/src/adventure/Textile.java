package adventure;
/**
 * @constructor - public 
 * @parameters Takes x - Location 
 * @Key words
 * @Return - void
 * @Notes This is the method for the textile room
 *
 */

public class Textile implements Room{
	/**
	 * @constructor - Public
	 * @parameters Takes x - Location 
	 * @Key words - burned rags - vat died
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method accesses the ini file and lets the palyer lpook around the room
	 *
	 */

	@Override
	public int look(int x) {
		if (x == 1){
			AdventureModel.ReadINI("4.1 D");
		} else if (x == 2 && Adventurer.Progress.contains("BURNED RAGS")){
			AdventureModel.ReadINI("4.21D");
		} else if (x == 2){
			AdventureModel.ReadINI("4.2 D");
		} else if (x== 3 && Adventurer.Progress.contains("VAT DIED")){
			AdventureModel.ReadINI("4.31D");
		} else if (x== 3){
			AdventureModel.ReadINI("4.3 D");
		}
		return x;
	}
	/**
	 * @constructor - Public
	 * @parameters Takes x - Location 
	 * @Key words - YELLOW KEY
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method accesses the ini file and causes the user to go north
	 *
	 */

	@Override
	public int goNorth(int x) {
		if  (x ==1 && Adventurer.Inventory.contains("yellow key")){
			AdventureModel.ReadINI("4.11N");
			Adventurer.Progress.add("TEXTILE CHECKPOINT");
		} else if (x==1){
			AdventureModel.ReadINI("4.1 N");
		} else if (x==2){
			AdventureModel.ReadINI("4.2 N");;
		} else if (x==3){
			AdventureModel.ReadINI("4.3 N");
			x = 1;
		} 
		return x;

	}
	/**
	 * @constructor - Public
	 * @parameters Takes x - Location 
	 * @Key words - none
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method accesses the ini file and causes the user to go South
	 *
	 */

	@Override
	public int goSouth(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("4.1 S");
			x = 3;
		} else if (x==2){
			AdventureModel.ReadINI("4.2 S");
		} else if (x==2){
			AdventureModel.ReadINI("4.2 S");;
		} else if (x==3){
			AdventureModel.ReadINI("4.3 S");
		}
		return x; 
	}

	/**
	 * @constructor - Public
	 * @parameters Takes x - Location 
	 * @Key words - YELLOW KEY
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method accesses the ini file and causes the user to go East
	 *
	 */
	
	@Override
	public int goEast(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("4.1 E");
		} else if (x==2){
			AdventureModel.ReadINI("4.2 E");
			x = 1;
		} else if (x==2){
			AdventureModel.ReadINI("4.3 E");;
		} 
		return x;
	}
	/**
	 * @constructor - Public
	 * @parameters Takes x - Location 
	 * @Key words - none
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method accesses the ini file and causes the user to go West
	 *
	 */

	@Override
	public int goWest(int x) {
		if  (x ==1){
			AdventureModel.ReadINI("4.1 W");
			x = 2;
		} else if (x==2){
			AdventureModel.ReadINI("4.2 W");
		} else if (x==2){
			AdventureModel.ReadINI("4.3 W");;
		} 
		return x;
	}
	/**
	 * @constructor - Public
	 * @parameters Takes x, also searches for items in the inventory
	 * @Key words - Clue 2, Rag Search
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method allows the user to take items in the room 
	 *
	 */
	
	@Override
	public int take(int x) {
		if(x == 2 && Adventurer.Progress.contains("BURNED RAGS")){
			AdventureModel.ReadINI("4.24T");
		} else if (x == 2 && Adventurer.Progress.contains("CLUE 2 OBTAINED")){
			AdventureModel.ReadINI("4.23T");
		} else if (x == 2 && Adventurer.Progress.contains("RAG SEARCH 2") && Adventurer.Progress.contains("BURNED RAGS")==false){
			AdventureModel.ReadINI("4.22T");
			Adventurer.Progress.remove("RAG SEARCH 2");
			Adventurer.Progress.add("CLUE 2 OBTAINED");
			for (int c = 1; c<=8;c++){
				AdventureModel.ReadINI("CLU2 "+c);
				}
		} else if (x == 2 && Adventurer.Progress.contains("RAG SEARCH 1") && Adventurer.Progress.contains("BURNED RAGS") == false){
			AdventureModel.ReadINI("4.21T");
			Adventurer.Progress.remove("RAG SEARCH 1");
			Adventurer.Progress.add("RAG SEARCH 2");
		} else if (x == 2 && Adventurer.Progress.contains("BURNED RAGS") == false){
			AdventureModel.ReadINI("4.2 T");
			Adventurer.Progress.add("RAG SEARCH 1");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
	}
	/**
	 * @constructor - Public
	 * @parameters Takes x, also searches for items in the inventory
	 * @Key words - yellow key, blue key, lighter
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method allows the user to interct with items in the room 
	 *
	 */
	
	@Override
	public int items(int x) {
		String select = Adventurer.ReadInventory();
	if (select.equalsIgnoreCase("lighter") && x == 2 && Adventurer.Inventory.contains("yellow key")){
			AdventureModel.ReadINI("4.21U");
	} else if (select.equalsIgnoreCase("lighter") && x ==2){
			AdventureModel.ReadINI("4.2 U");
			Adventurer.Progress.add("BURNED RAGS");
			Adventurer.Inventory.add("yellow key");
	} else if (select.equalsIgnoreCase("blue key") && x == 3 && Adventurer.Progress.contains("VAT ON")){
			AdventureModel.ReadINI("4.3 U");
			Adventurer.Progress.add("CLUE 3 OBTAINED");
				for (int c = 1; c<=7;c++){
					AdventureModel.ReadINI("CLU3 "+c);
					}
	} else if (x == 3 && select.equalsIgnoreCase("red key") && Adventurer.Progress.contains("VAT ON")||x == 3 && select.equalsIgnoreCase("yellow key") 
			&& Adventurer.Progress.contains("VAT ON")|| x == 3 && select.equalsIgnoreCase("green key") && Adventurer.Progress.contains("VAT ON")){
			AdventureModel.ReadINI("4.31U");
			Adventurer.Progress.add("VAT DIED");
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
	 * @constructor - Public
	 * @parameters Takes x, also searches for items in the inventory
	 * @Key words - vat died
	 * @Return - void 
	 * @author - Javalava
	 * @Notes - This method allows the user to push obkjects in the room in the room 
	 *
	 */
	
	@Override
	public int push(int x) {
		if (x == 3 && Adventurer.Progress.contains("VAT DIED")){
			AdventureModel.ReadINI("4.32P");
		} else if (x == 3 && Adventurer.Progress.contains("VAT ON")){
			AdventureModel.ReadINI("4.31P");
			Adventurer.Progress.remove("VAT ON");
			Adventurer.Progress.add("VAT DIED");
		} else if (x==3){
			AdventureModel.ReadINI("4.3 P");
			Adventurer.Progress.add("VAT ON");
		} else {
			System.out.println("You can't do that here.");
		}
		return x;
				
		}
	}

