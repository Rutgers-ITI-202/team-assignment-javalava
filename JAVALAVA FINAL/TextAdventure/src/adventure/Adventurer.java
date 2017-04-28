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
		
	public static ArrayList<String> Inventory = new ArrayList<String>();
	public static ArrayList<String> Progress = new ArrayList<String>();
	
	// END CONSTANTS



public static void inventoryManage(){ // adds the initial items to your inventory
	Inventory.add("rope"); Inventory.add("lighter");
} 

public static String ReadInventory() {
	int r = 0;
	System.out.println("You currently have: " + Inventory + "\nWhich item do you want to select?"); // reads iventory
	Scanner s = new Scanner(System.in);
	String select = s.nextLine();
	if (Inventory.contains(select) == true){
		System.out.println("What would you like to do with the "+ select + "?");
		String action = s.nextLine();
		if (action.equalsIgnoreCase("USE")){
			return select;
		} else if (action.equalsIgnoreCase("LOOK")){
			if (select.equalsIgnoreCase("book")){
				Adventurer.Inventory.add("black key");
				Adventurer.Inventory.remove("book");
			}
			select = select.substring(0, 4); // cuts the selection to the first 4 letters so it can be read in the ini file
			select = select+"D";			// D is the marker for item description
			AdventureModel.ReadINI(select);	// reads the description in the ini file
			select = "looked";
		} else {
			select = "invalid";
		}
	} else {
		select = "don't have";
	}
	return select;
}

}
