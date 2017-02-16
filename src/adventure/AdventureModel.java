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
	
public static void Tutorial() {
	System.out.println("Basic commands are: LOOK, TAKE, USE, GO to LOCATION, and MENU \r");
}

public static void CharacterIntro() {
	System.out.println("You are a child of the 180's Industrial Revolution. \r"
			+ "You came to this factory to work, but the owner seems to have other plans for you. \r"
			+ "While the factory is closed down, you have to escape. \r");
}

public static void FirstRoomDescribe(){
	System.out.print("You see looms, currently unused, lining the room. \r"
			+ "There's an intimidating metal door at the far end of the room, and \r"
			+ "a desk where the supervisor usually sits and smokes cigars. \r \rWhat do you want to do? \r");
	
}

public static void FirstRoomAdventure() {
	Scanner m = new Scanner(System.in);
	String action = m.nextLine();
		if (action.equalsIgnoreCase("MENU") == true){
			Adventurer.MENU();
		} else if (action.equalsIgnoreCase("LOOK") == true){
			AdventureModel.FirstRoomDescribe();
		} else if (action.equalsIgnoreCase("GO TO DESK") == true) {
			/// GOES TO DESK
		} else if (action.equalsIgnoreCase("GO TO DOOR") == true) {
			/// GO TO DOOR
		} else {
			System.out.println("You can't do that here.");
		}
}

}