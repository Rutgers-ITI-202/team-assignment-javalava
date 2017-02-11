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

import java.util.Scanner;

public class Adventurer {

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
	while (menuLoop = false){
	Scanner menu = new Scanner(System.in);
	String option = menu.nextLine();			
		if (option.equalsIgnoreCase("A") == true){
			// METHOD TO VIEW INVENTORY HERE
			menuLoop = true;
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
}		
	
}

	
}

