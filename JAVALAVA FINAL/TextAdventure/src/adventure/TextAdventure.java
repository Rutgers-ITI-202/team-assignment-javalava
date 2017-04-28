/*
This class:
•	Contains the main method used to start the game.
•	Talks to the AdventureModel and to the Adventurer classes, as needed.
*/

package adventure;

// comments
import java.util.Scanner;

/**
 * Main method of text adventure
 * @author Chris
 * @since 2/11/17
 *
 */

public class TextAdventure {

	public static void main(String[] args) {
		
startGame(); // start game sequence

	}



/**
 * Method to boot the game
 * @author: ChrisMDC
 * @since: 2/16/17
 */

	public static void startGame() {
		AdventureModel.loadINI();
		for (int x = 1; x<=6;x++){
			AdventureModel.ReadINI("ASCII"+x);
			}
		
		int start = 0;
		do {System.out.println("Press A to Start");
		Scanner begin = new Scanner(System.in);
		String A = begin.nextLine();
			if (A.equalsIgnoreCase("a") == true){
				start = 1;
				Adventurer.inventoryManage();
				AdventureModel.ReadINI("OPEN");
				AdventureModel.EnterRoomOne(1);					
			} else if (A.equalsIgnoreCase("a") == false){		// catch exceptions
				System.out.println("You entered " + A + ", which did not work.");
			}
		} while (start == 0) ;
	}

}