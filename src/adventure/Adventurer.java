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
		
	// END CONSTANTS

/**
 * Allows Player Access to Menu to view inventory, quit game, exit menu
 * More functionalities to come
 * @author ChrisMDC
 * @since 2/11/2017
 *
 */	
public static void MENU() {
	boolean menuLoop = false;
	System.out.println("<<OPEN MENU>> \rView Inventory: A \rQuit Game: B \rExit Menu: C");
	do {
	Scanner menu = new Scanner(System.in);
	String option = menu.nextLine();			
		if (option.equalsIgnoreCase("A") == true){			
			menuLoop = true;
			INVENTORY();
		} else if (option.equalsIgnoreCase("B") == true) {
			// METHOD TO QUIT GAME HERE
			menuLoop = true;
		} else if (option.equalsIgnoreCase("C") == true){
			System.out.println("<<CLOSED MENU>>");
			// return to game
			menuLoop = true;
		} else {
			System.out.println("Your entry " + option + ", is not a viable option. Enter again.");
		}	
}	while (menuLoop = false);
	
}

/** 
 * Method to add / drop things from inventory
 * @author Chris
 * @since 2/16/17
 * @version 1.0
 * @return itemList
 */

public static ArrayList<String> inventoryManage(){
	ArrayList<String> itemList = new ArrayList<String>();
	itemList.add("GUM"); itemList.add("WATCH");
	return itemList;
}

/** Method to view inventory
 * @author Chris
 * @param itemsList
 * @since 2/18/17
 * @version 1.1
 */


public static void INVENTORY(){
	System.out.println("You have: " + inventoryManage() + ". What do you want to do? Close or choose item: ");
	Scanner p = new Scanner(System.in);
	String nextaction = p.nextLine();
		if (nextaction.equalsIgnoreCase("GUM") == true){
			gumMethod();
		} else if (nextaction.equalsIgnoreCase("WATCH") == true){
			
			watchMethod();
		} else if (nextaction.equalsIgnoreCase("CLOSE") == true){
			// close menu, return to game
		} else {
			System.out.println("You can't do that here.");
		}
	
}
	// TODO Auto-generated method stub

public static void gumMethod(){
	System.out.println("What do you want to do with the GUM?");
	Scanner g = new Scanner(System.in);
	String whatgum = g.next();
	if (whatgum.equalsIgnoreCase("USE") == true){
		System.out.println("You unwrap the gum and put it in your mouth. It's really minty.");
	} else if (whatgum.equalsIgnoreCase("LOOK") == true){
		System.out.println("The gum advertises: \"Chewing Gum for Athletes and Cyclists!\"");
	}
}

public static void watchMethod(){
	System.out.println("What do you want to do with the WATCH?");
	Scanner g = new Scanner(System.in);
	String whatgum = g.next();
	if (whatgum.equalsIgnoreCase("USE") == true){
		System.out.println("You can't use this here.");
	} else if (whatgum.equalsIgnoreCase("LOOK") == true){
		System.out.println("It's old and broken, stuck on the time 9:55 AM.");
	}
	
}
	
}

