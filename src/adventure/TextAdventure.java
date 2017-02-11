/*
This class:
�	Contains the main method used to start the game.
�	Talks to the AdventureModel and to the Adventurer classes, as needed.
*/

package adventure;

import java.util.Scanner;

/**
 * Main method of text adventure
 * @author ChrisMCD
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
 * @since: 2/11/17
 */

	public static void startGame() {
		System.out.println("<<Press A to Start>>");
		Scanner begin = new Scanner(System.in);
		String A = begin.nextLine();
			if (A.equalsIgnoreCase("a") == true){
				System.out.println("Game loading...");
							// INSERT METHOD TO INTRODUCE ROOM AND PLAYER
			} else if (A.equalsIgnoreCase("a") == false){
				System.out.println("You entered " + A + ", which did not work.");
				startGame();
			}
		
	}

}
