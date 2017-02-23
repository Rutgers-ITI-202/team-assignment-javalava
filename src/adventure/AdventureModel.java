/*
This class:
•	Creates the Rooms, the Things, and the Adventurer.
•	Connects the Rooms with "paths" to other Rooms.
•	Places Things in the Rooms.
•	Places the Adventurer in some Room.
•	Accepts commands from the player, and executes them.
	o	As commands are entered, they should be copied to the main text area.
	o	The method that executes commands should return a String to be displayed in the main text area.
*/

package adventure;

import java.util.Scanner;

public class AdventureModel {



/**
 * Introduces character
 * Can possibly print whenever the user wants context?
 * @author Chang and Chris
 * @since 2/16/17
 */

public static void CharacterIntro() {			
	System.out.println("You are a child of the 1800's Industrial Revolution. \r"
			+ "You came to this factory to work, but the owner seems to have other plans for you. \r"
			+ "While the factory is closed down, you have to escape. \r");
}

/**
 * Describes the room
 * Can be evoked again to remind player of what the room looks like.
 * @author Chang and CHris
 * @since 2/16/17
 */

public static void FirstRoomDescribe(){
	System.out.print("You wake up, alone, on a chair in the break room. \r"
			+ "There's an intimidating metal door at the far end of the room, and \r"
			+ "a desk where the supervisor usually sits and smokes cigars.\r");
	FirstRoomAdventure();
	
}

// Dave : Might want to integrate some sort of notation that lets the player know exactly what to type, like "You can \[Look\], \[Go to desk\], \[Go to door\] 

/**
 * Preliminary First Room Actions
 * From this position player can view menu, look at the room, or go to the desk or door.
 * @author Cheng and Chris
 * @since 2/16/17
 */

public static void FirstRoomAdventure() {
	System.out.println("What do you want to do? You can [MENU] [LOOK] [GO TO DESK] [GO TO DOOR]");
	Scanner m = new Scanner(System.in);
	String action = m.nextLine();
		if (action.equalsIgnoreCase("MENU") == true){
			Adventurer.MENU("MAINBREAKROOM");	// opens menu in Adventurer class
		} else if (action.equalsIgnoreCase("LOOK") == true){
			AdventureModel.FirstRoomDescribe();
		} else if (action.equalsIgnoreCase("GO TO DESK") == true) {
			DeskDescribe();
		} else if (action.equalsIgnoreCase("GO TO DOOR") == true) {
			DoorDescribe();
		} else {			// catch exceptions
			System.out.println("You can't do that here.");
			FirstRoomAdventure();
		}
}

/**
 * Desk Description 
 * Note: Describes the desk when the player goes near it. Can be reused
 * @author Dave
 * @since 2/19/17 
 */

public static void DeskDescribe( ){
	
	System.out.println("You cautiously approach your boss' desk. The smell of cigar ashes reminds you of the fact that they could be lurking about");
	System.out.println("You see a partially opened drawer the the desk.");
	FirstRoomDesk();	
}

/**
 * Desk Actions 
 * Note: This is a set of actions for when the user comes up to the desk
 * @author Dave
 * @since 2/19/17 
 */

public static void FirstRoomDesk() { 
	System.out.println( "You can: [MENU] [LOOK] [OPEN DRAWER] [RETURN]");
	Scanner D = new Scanner(System.in) ;
	String action = D.nextLine();
	 if (action.equalsIgnoreCase("MENU") == true) {
		 Adventurer.MENU("DESK");  // Goes to menu in Adventurer Class
	 }
		 else if (action.equalsIgnoreCase("Look") == true){
		DeskDescribe(); 
	 }	 
		 else if (action.equalsIgnoreCase("Open Drawer") == true) {		
			 DeskDrawer();
}
		 else if (action.equalsIgnoreCase("Return") == true){
		System.out.println("You have returned to the main area of the break room.");	 
			 AdventureModel.FirstRoomAdventure() ;
		 } else { 
			 System.out.println("You can't do that here.");
			 FirstRoomDesk();
		 }
}

/**
 * Method includes interactions with the desk drawer.
 * @author Chris
 * @since 2/22/17
 * @version 1.0
 */

public static void DeskDrawer(){
	if (Adventurer.itemList.contains("KEY") == true){
		System.out.println("Now there's nothing here but dust bunnies.");
		FirstRoomDesk();
	} else {
	System.out.println("Aside from the dust bunnies, you see a silver key in the drawer. It looks like it can fit the door.");
	System.out.println("You can: [MENU] [TAKE] [RETURN]");
	Scanner t = new Scanner(System.in);
	String take = t.nextLine();
		if(take.equalsIgnoreCase("TAKE") == true){
			System.out.println("You pick up the key and put it into your bag.");
			Adventurer.itemList.add("KEY");
			DeskDrawer();
		} else if (take.equalsIgnoreCase("MENU") == true){
			Adventurer.MENU("Drawer");
		} else if (take.equalsIgnoreCase("RETURN") == true){
			System.out.println("You closed the drawer.");
			FirstRoomDesk();
		} else {
			System.out.println("You can't do that here.");
			DeskDrawer();
		}
	}
}

public static void DoorDescribe(){
	System.out.println("You go to the door, which is made of heavy metal. There's no breaking dowh this thing."
			+ "\rThere's a little keyhole in the doorknob, though.");
	FirstRoomDoor();
}

public static void FirstRoomDoor(){
	System.out.println("You can: [LOOK] [MENU] [OPEN DOOR] [RETURN]");
	Scanner d = new Scanner(System.in);
	String action = d.nextLine();
		if (action.equalsIgnoreCase("OPEN DOOR") == true && Adventurer.itemList.contains("KEY") == true){
			System.out.println("The key fits! You open the door, and find a long hallway -- and a long adventure -- ahead.");
			System.out.println("DEMO END! THANKS FOR PLAYING!");
		} else if (action.equalsIgnoreCase("LOOK") == true){
			DoorDescribe();
		}else if (action.equalsIgnoreCase("MENU") == true){
			Adventurer.MENU("DOOR");
		} else if (action.equalsIgnoreCase("RETURN") == true){
			System.out.println("You have returned to the main area of the break room.");
			FirstRoomAdventure();
		} else if (action.equalsIgnoreCase("OPEN DOOR") == true){
			System.out.println("You fiddle with the doorknob, but it won't budge.");
			FirstRoomDoor();
		} else {
			System.out.println("You can't do that here.");
			FirstRoomDoor();
		}
	
}

}