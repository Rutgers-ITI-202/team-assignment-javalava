/*
This class:
•	Contains the main method used to start the game.
•	Talks to the AdventureModel and to the Adventurer classes, as needed.
*/

package adventure;

import java.util.Scanner;

/**
 * Main method of text adventure
 * @author Chris
 * @since 2/11/17
 *
 */

public class TextAdventure {

	public static void main(String[] args) {
	
System.out.println("GAME TITLE TBA");
		
startGame(); // start game sequence


	}

/**
 * Method to boot the game
 * @author: ChrisMDC
 * @since: 2/16/17
 */

	public static void startGame() {
		System.out.println("<<Press A to Start>>");
		Scanner begin = new Scanner(System.in);
		String A = begin.nextLine();
			if (A.equalsIgnoreCase("a") == true){
				System.out.println("Game loading...");
							AdventureModel.Tutorial();		// introduction to the game, all Strings in AdventureModel
							AdventureModel.CharacterIntro();
							AdventureModel.FirstRoomDescribe();
							AdventureModel.FirstRoomAdventure();							
			} else if (A.equalsIgnoreCase("a") == false){		// catch exceptions
				System.out.println("You entered " + A + ", which did not work.");
				startGame();
			}
		
	}

}
