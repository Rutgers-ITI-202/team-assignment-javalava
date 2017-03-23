/*
An adventurer has:
•	A location (some room).
•	An inventory (the things being carried).  When the player executes the “take thing” command, the item should be added to the inventory.

An adventurer can:
•	Move from room to room.
•	Carry a number of objects.
•	Pick up, drop, look at, and use various objects.
*/

package adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Adventurer {
	
	// CONSTANTS	
		
	public static ArrayList<String> itemList = new ArrayList<String>();
	
	// END CONSTANTS

/**
 * Allows Player Access to Menu to view inventory, quit game, exit menu * 
 * @author Chris
 * @param origin - allows player to return to where they opened menu.
 * @since 2/22/17
 * @version 1.1
 * 
 */	
public static void MENU(String origin) {
	boolean menuLoop = false;
	System.out.println("<<MENU>> \rView Inventory: A \rQuit Game: B \rExit Menu: C");
	do {
	Scanner menu = new Scanner(System.in);
	String option = menu.nextLine();			
		if (option.equalsIgnoreCase("A") == true){			
			menuLoop = true;
			INVENTORY(origin);
		} else if (option.equalsIgnoreCase("B") == true) {
			TextAdventure.quitGame(origin);
			menuLoop = true;
		} else if (option.equalsIgnoreCase("C") == true){
			System.out.println("<<CLOSED MENU>>");
				if (origin.equalsIgnoreCase("MAINBREAKROOM") == true)
					AdventureModel.FirstRoomDescribe();
				else if (origin.equalsIgnoreCase("DESK") == true){
					AdventureModel.DeskDescribe();
				} else if (origin.equalsIgnoreCase("DRAWER") == true){
					AdventureModel.DeskDrawer();
				} else if (origin.equalsIgnoreCase("DOOR") == true){
					AdventureModel.DoorDescribe();
				}
			menuLoop = true;
		} else {
			System.out.println("You can't do that here.");
			MENU(origin);
		}	
}	while (menuLoop = false);
	
}

/** 
 * sets up initial inventory with GUM and WATCH
 * @author Chris
 * @since 2/16/17
 * @version 1.0 * 
 * @return itemList
 */

public static ArrayList<String> inventoryManage(){
	itemList.add("GUM"); itemList.add("WATCH");
	return itemList;
} 

/** Method to view inventory
 * @author Chris
 * @param origin
 * @see Menu() for description about origin parameter
 * @since 2/18/17
 * @version 1.1
 */


public static void INVENTORY(String origin){
	System.out.println("You have: " + itemList + ". Close or choose item.");
	Scanner p = new Scanner(System.in);
	String nextaction = p.nextLine();
		if (itemList.contains("GUM") && nextaction.equalsIgnoreCase("GUM") == true){
			gumMethod(origin);
		} else if (itemList.contains("WATCH") && nextaction.equalsIgnoreCase("WATCH") == true){			
			watchMethod(origin);
		} else if (nextaction.equalsIgnoreCase("CLOSE") == true){
			MENU(origin);
		} else if (itemList.contains("KEY") && nextaction.equalsIgnoreCase("KEY") == true){
			keyMethod(origin);
		}
		else if (itemList.isEmpty() == true){
		
			System.out.println("You don't have anything in your inventory.");
			MENU(origin);
		} else {		
			System.out.println("You don't have that.");
			INVENTORY(origin);
		}	

}

/**
 * Method includes all interactions with gum including LOOK, USE, and DROP
 * @author Chris
 * @since 2/22/17
 * @version 1.0
 * @param origin
 * @see Menu() for description about origin parameter
 * 
 */

public static void gumMethod(String origin){
	System.out.println("What do you want to do with the GUM?");
	Scanner g = new Scanner(System.in);
	String whatgum = g.next();
	if (whatgum.equalsIgnoreCase("USE") == true){
		System.out.println("You unwrap the gum and put it in your mouth. It's really minty.");
		MENU(origin);
	} else if (whatgum.equalsIgnoreCase("LOOK") == true){
		System.out.println("The gum advertises: \"Chewing Gum for Athletes and Cyclists!\"");
		MENU(origin);
	} else if (whatgum.equalsIgnoreCase("DROP") == true){
		System.out.println("You dropped the gum.");
		itemList.remove("GUM");
		MENU(origin);
	} else {
		System.out.println("You can't do that here.");
		gumMethod(origin);
	}
}



/**
 * Method for all interactions with watch including LOOK, USE, and DROP
 * @author Chris
 * @param origin
 * @see Menu() for description about origin parameter
 * @since 2/22/2017
 * @version 1.0
 */

public static void watchMethod(String origin){
	System.out.println("What do you want to do with the WATCH?");
	Scanner g = new Scanner(System.in);
	String whatwatch = g.next();
	if (whatwatch.equalsIgnoreCase("USE") == true){
		System.out.println("You can't use this here.");
		watchMethod(origin);
	} else if (whatwatch.equalsIgnoreCase("LOOK") == true){
		System.out.println("It's old and broken, stuck on the time 9:55 AM.");
		MENU(origin);
	} else if (whatwatch.equalsIgnoreCase("DROP") == true){
		System.out.println("You dropped the watch.");
		 itemList.remove("WATCH");
		MENU(origin);
	} else{
		System.out.println("You can't do that here.");
		watchMethod(origin);
	}
	
}
/**
 * Method for all interactions with the key, including LOOK, USE, and DROP
 * @author Chris
 * @param origin
 * @see Menu() for description about origin parameter
 * @since 2/22/2017
 * @version 1.0
 */

public static void keyMethod(String origin){
	System.out.println("What do you want to do with the KEY?");
	Scanner k = new Scanner(System.in);
	String whatkey = k.nextLine();
		if(whatkey.equalsIgnoreCase("LOOK") == true){
			System.out.println("The key is silver and heavy. It looks like it can be helpful here.");
			MENU(origin);
		} else if (whatkey.equalsIgnoreCase("USE") == true && origin == "DOOR"){
			System.out.println("The key fits! You open the door, and find a long hallway -- and a long adventure -- ahead.");
			System.out.println("DEMO END! THANKS FOR PLAYING!");
		} else if (whatkey.equalsIgnoreCase("USE") == true){
			System.out.println("You can't use this here.");	
			MENU(origin);
		} else if (whatkey.equalsIgnoreCase("DROP") == true){
			System.out.println("This key looks important. You decide not to drop it.");
			MENU(origin);
		} else {
			System.out.println("You can't do that here.");
			MENU(origin);
		} 

}

}

