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
/** 
 * @author Java Lava
 *Prof File, TA Josh Rochette
 *Text adventure game: The Search for Pablo
 */

/** @constructor public method
    * @param Text, Data,
    * @return  none 
    * @keywords ini.tx. line
    * @Read ini.txt
    */

package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureModel {
	
	public static ArrayList<String> Text = new ArrayList<String>();
	/**
	 * @constructor public method
	 * @param loadini
	 * @return none
	 * @keywords INI
	 * @notes This method accesses the ini file for the game
	 */
	public static void loadINI() {
		File data = new File("ini.txt");		
		try {
			Scanner r = new Scanner(data);
			while (r.hasNextLine()){
			String line = r.nextLine();
			Text.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("INI File missing! Please locate to play the game.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @constructor public method
	 * @param search
	 * @return none
	 * @keywords text
	 * @notes Having the String Search
	 */

	public static void ReadINI(String search) {
		int r = 0;
		do {
			String toPrint = AdventureModel.Text.get(r);
			r++;
			if (toPrint.contains(search)){
			System.out.println(toPrint.substring(6, toPrint.length()));
			}
			} while (r < AdventureModel.Text.size());
	}
	
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Breakroom, locations, 
	 * @notes settings the rooms 
	 */


	public static void EnterRoomOne(int location){
		Room BR = new BreakRoom();
		if (Adventurer.Progress.contains("BREAK ROOM CHECKPOINT")){
			EnterHallway(1);
		}
		System.out.println("What do you want to do?");
		Scanner a = new Scanner(System.in);
		String action = a.nextLine();
			if (action.equalsIgnoreCase("LOOK") == true){
				EnterRoomOne(BR.look(location));
			} else if (action.equalsIgnoreCase("GO NORTH") == true){
				EnterRoomOne(BR.goNorth(location));
			} else if (action.equalsIgnoreCase("GO SOUTH")== true){
				EnterRoomOne(BR.goSouth(location));
			} else if (action.equalsIgnoreCase("GO EAST") == true){
				EnterRoomOne(BR.goEast(location));
			} else if (action.equalsIgnoreCase("GO WEST") == true){
				EnterRoomOne(BR.goWest(location));
			} else if (action.equalsIgnoreCase("ITEMS") == true){
				EnterRoomOne(BR.items(location));		
			} else if (action.equalsIgnoreCase("TAKE") == true){
				EnterRoomOne(BR.take(location));
			} else if (action.equalsIgnoreCase("OPEN") == true){
				EnterRoomOne(BR.open(location));
			} else {
				System.out.println("You can't do that right now");
				EnterRoomOne(location);
			}
	} 
	/**
	 * @constructor Public Method
	 * @param automobile 
	 * @return none
	 * @keywords Breakroom, locations, Look 
	 * @notes settings the rooms 
	 */

	public static void EnterHallway(int location){
		Room HW = new Hallway();
		if (Adventurer.Progress.contains("HALLWAY 1 CHECKPOINT")){
			EnterAutomobile(1);
		} else if (Adventurer.Progress.contains("HALLWAY 2 CHECKPOINT")){
			EnterTextile(1);
		}else if (Adventurer.Progress.contains("HALLWAY CLEARED CHECKPOINT")){
			EnterGunpowder(1);
		}
			System.out.println("What do you want to do?");
			Scanner a = new Scanner(System.in);
			String action = a.nextLine();
				if (action.equalsIgnoreCase("LOOK") == true){
					EnterHallway(HW.look(location));
				} else if (action.equalsIgnoreCase("GO NORTH") == true){
					EnterHallway(HW.goNorth(location));
				} else if (action.equalsIgnoreCase("GO SOUTH")== true){
					EnterHallway(HW.goSouth(location));
				} else if (action.equalsIgnoreCase("GO EAST") == true){
					EnterHallway(HW.goEast(location));
				} else if (action.equalsIgnoreCase("GO WEST") == true){
					EnterHallway(HW.goWest(location));
				} else if (action.equalsIgnoreCase("ITEMS") == true){
					EnterHallway(HW.items(location));		
				} else if (action.equalsIgnoreCase("TAKE") == true){
					EnterHallway(HW.take(location));
				} else if (action.equalsIgnoreCase("OPEN") == true){
					EnterHallway(HW.open(location));
				}  else {
					System.out.println("You can't do that right now");
					EnterHallway(location);
				}
		}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Automobile Room, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterAutomobile(int location){
		if (Adventurer.Progress.contains("AUTOMOBILE CHECKPOINT")){
			EnterHallway(2);
		} else if (Adventurer.Progress.contains("HALLWAY 2 CHECKPOINT")){
			EnterTextile(1);
		} 
		Room AR = new Automobile();
			System.out.println("What do you want to do?");
			Scanner a = new Scanner(System.in);
			String action = a.nextLine();
				if (action.equalsIgnoreCase("LOOK") == true){
					EnterAutomobile(AR.look(location));
				} else if (action.equalsIgnoreCase("GO NORTH") == true){
					EnterAutomobile(AR.goNorth(location));
				} else if (action.equalsIgnoreCase("GO SOUTH")== true){
					EnterAutomobile(AR.goSouth(location));
				} else if (action.equalsIgnoreCase("GO EAST") == true){
					EnterAutomobile(AR.goEast(location));
				} else if (action.equalsIgnoreCase("GO WEST") == true){
					EnterAutomobile(AR.goWest(location));
				} else if (action.equalsIgnoreCase("ITEMS") == true){
					EnterAutomobile(AR.items(location));		
				} else if (action.equalsIgnoreCase("TAKE") == true){
					EnterAutomobile(AR.take(location));
				} else if (action.equalsIgnoreCase("PUSH") == true){
					EnterAutomobile(AR.push(location));
				} else {
					System.out.println("You can't do that right now");
					EnterAutomobile(location);
				}
		} 
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Textile room locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterTextile(int location){
		if (Adventurer.Progress.contains("TEXTILE CHECKPOINT")){
			Adventurer.Progress.remove("HALLWAY 2 CHECKPOINT");
			EnterHallway(4);
		}
		Room TT = new Textile();
		System.out.println("What do you want to do?");
		Scanner a = new Scanner(System.in);
		String action = a.nextLine();
			if (action.equalsIgnoreCase("LOOK") == true){
				EnterTextile(TT.look(location));
			} else if (action.equalsIgnoreCase("GO NORTH") == true){
				EnterTextile(TT.goNorth(location));
			} else if (action.equalsIgnoreCase("GO SOUTH")== true){
				EnterTextile(TT.goSouth(location));
			} else if (action.equalsIgnoreCase("GO EAST") == true){
				EnterTextile(TT.goEast(location));
			} else if (action.equalsIgnoreCase("GO WEST") == true){
				EnterTextile(TT.goWest(location));
			} else if (action.equalsIgnoreCase("ITEMS") == true){
				EnterTextile(TT.items(location));		
			} else if (action.equalsIgnoreCase("TAKE") == true){
				EnterTextile(TT.take(location));
			} else if (action.equalsIgnoreCase("PUSH") == true){
				EnterTextile(TT.push(location));
			} else {
				System.out.println("You can't do that right now");
				EnterTextile(location);
			}
		
	}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Breakroom, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterGunpowder(int location) {
		if (Adventurer.Progress.contains("GUNPOWDER CHECKPOINT")){
			Adventurer.Progress.remove("AUTOMOBILE CHECKPOINT");
			Adventurer.Progress.remove("TEXTILE CHECKPOINT");
			EnterBunk(1);
		}
		Room GP = new Gunpowder();
		System.out.println("What do you want to do?");
		Scanner a = new Scanner(System.in);
		String action = a.nextLine();
			if (action.equalsIgnoreCase("LOOK") == true){
				EnterGunpowder(GP.look(location));
			} else if (action.equalsIgnoreCase("GO NORTH") == true){
				EnterGunpowder(GP.goNorth(location));
			} else if (action.equalsIgnoreCase("GO SOUTH")== true){
				EnterGunpowder(GP.goSouth(location));
			} else if (action.equalsIgnoreCase("GO EAST") == true){
				EnterGunpowder(GP.goEast(location));
			} else if (action.equalsIgnoreCase("GO WEST") == true){
				EnterGunpowder(GP.goWest(location));
			} else if (action.equalsIgnoreCase("ITEMS") == true){
				EnterGunpowder(GP.items(location));		
			} else if (action.equalsIgnoreCase("TAKE") == true){
				EnterGunpowder(GP.take(location));
			} else if (action.equalsIgnoreCase("OPEN") == true){
				EnterGunpowder(GP.open(location));
			} else {
				System.out.println("You can't do that right now.");
				EnterGunpowder(location);
			}
	}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Bunker room, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterBunk(int location){
		if (Adventurer.Progress.contains("BUNK CHECKPOINT")){
			EnterCourtyard(1);
		}
		Room BB = new bunkroom();
		System.out.println("What do you want to do?");
		Scanner a = new Scanner(System.in);
		String action = a.nextLine();
			if (action.equalsIgnoreCase("LOOK") == true){
				EnterBunk(BB.look(location));
			} else if (action.equalsIgnoreCase("GO NORTH") == true){
				EnterBunk(BB.goNorth(location));
			} else if (action.equalsIgnoreCase("GO SOUTH")== true){
				EnterBunk(BB.goSouth(location));
			} else if (action.equalsIgnoreCase("GO EAST") == true){
				EnterBunk(BB.goEast(location));
			} else if (action.equalsIgnoreCase("GO WEST") == true){
				EnterBunk(BB.goWest(location));
			} else if (action.equalsIgnoreCase("ITEMS") == true){
				EnterBunk(BB.items(location));		
			} else if (action.equalsIgnoreCase("TAKE") == true){
				EnterBunk(BB.take(location));
			} else {
				System.out.println("You can't do that right now");
				EnterBunk(location);
			}
		
	}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Courtyard, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterCourtyard(int location){
		if (Adventurer.Progress.contains("COURTYARD CHECKPOINT")){
			EnterShed(1);
		} 
		Room CY = new Courtyard();
			System.out.println("What do you want to do?");
			Scanner a = new Scanner(System.in);
			String action = a.nextLine();
				if (action.equalsIgnoreCase("LOOK") == true){
					EnterCourtyard(CY.look(location));
				} else if (action.equalsIgnoreCase("GO NORTH") == true){
					EnterCourtyard(CY.goNorth(location));
				} else if (action.equalsIgnoreCase("GO SOUTH")== true){
					EnterCourtyard(CY.goSouth(location));
				} else if (action.equalsIgnoreCase("GO EAST") == true){
					EnterCourtyard(CY.goEast(location));
				} else if (action.equalsIgnoreCase("GO WEST") == true){
					EnterCourtyard(CY.goWest(location));
				} else if (action.equalsIgnoreCase("ITEMS") == true){
					EnterCourtyard(CY.items(location));		
				} else {
					System.out.println("You can't do that right now");
					EnterCourtyard(location);
				}
	}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Shed, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterShed(int location){
		if (Adventurer.Progress.contains("SHED CHECKPOINT")){
			EnterBasement(1);
		} 
		Room SD = new shed();
			System.out.println("What do you want to do?");
			Scanner a = new Scanner(System.in);
			String action = a.nextLine();
				if (action.equalsIgnoreCase("LOOK") == true){
					EnterShed(SD.look(location));
				} else if (action.equalsIgnoreCase("GO NORTH") == true){
					EnterShed(SD.goNorth(location));
				} else if (action.equalsIgnoreCase("GO SOUTH")== true){
					EnterShed(SD.goSouth(location));
				} else if (action.equalsIgnoreCase("GO EAST") == true){
					EnterShed(SD.goEast(location));
				} else if (action.equalsIgnoreCase("GO WEST") == true){
					EnterShed(SD.goWest(location));
				} else if (action.equalsIgnoreCase("ITEMS") == true){
					EnterShed(SD.items(location));		
				} else if (action.equalsIgnoreCase("TAKE") == true){
					EnterShed(SD.take(location));
				}else if (action.equalsIgnoreCase("OPEN")){
					EnterShed(SD.open(location));
				} else {
					System.out.println("You can't do that right now");
					EnterShed(location);
				}
	}
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Basement, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

	public static void EnterBasement(int location){
			if (Adventurer.Progress.contains("ENTERED BLACK ROOM")){
				EnterSecret(1);
			} 
			if (Adventurer.Progress.contains("ALTERNATE ENDING")){
				AdventureModel.AlternateEnding();
			}

			Room BM = new basement();
				System.out.println("What do you want to do?");
				Scanner a = new Scanner(System.in);
				String action = a.nextLine();
					if (action.equalsIgnoreCase("LOOK") == true){
						EnterBasement(BM.look(location));
					} else if (action.equalsIgnoreCase("GO NORTH") == true){
						EnterBasement(BM.goNorth(location));
					} else if (action.equalsIgnoreCase("GO SOUTH")== true){
						EnterBasement(BM.goSouth(location));
					} else if (action.equalsIgnoreCase("GO EAST") == true){
						EnterBasement(BM.goEast(location));
					} else if (action.equalsIgnoreCase("GO WEST") == true){
						EnterBasement(BM.goWest(location));
					} else if (action.equalsIgnoreCase("ITEMS") == true){
						EnterBasement(BM.items(location));		
					} else {
						System.out.println("You can't do that right now");
						EnterBasement(location);
					}
		
		}	
	/**
	 * @constructor Public Method
	 * @param location
	 * @return none
	 * @keywords Secretroom, locations, Look 
	 * @notes settings the rooms, north south and north
	 */

		public static void EnterSecret(int location){
			int fin = 0;
			do {
			if (Adventurer.Progress.contains("LEFT BLACK ROOM")){
				Adventurer.Progress.remove("ENTERED BLACK ROOM");
				EnterBasement(4);
			}
				Room SC = new SecretRoom();
				System.out.println("What do you want to do?");
				Scanner a = new Scanner(System.in);
				String action = a.nextLine();
				if (Adventurer.Progress.contains("SHOT WOMAN") || Adventurer.Progress.contains("TOUCHED BY WOMAN")){
					EnterBasement(4);
				} 
				if (Adventurer.Progress.contains("WOMAN APPROACHING")&& Adventurer.Progress.contains("CLUE 1 OBTAINED") && Adventurer.Progress.contains("CLUE 2 OBTAINED") && Adventurer.Progress.contains("CLUE 3 OBTAINED") && Adventurer.Progress.contains("CLUE 4 OBTAINED")){
					AdventureModel.ReadINI("ACT 4");
					AdventureModel.ReadINI("COUNT");
					fin = 1;
					break;
				}
				else if (Adventurer.Progress.contains("WOMAN APPROACHING") && action.equalsIgnoreCase("ITEMS") == false){
					AdventureModel.ReadINI("ACT 1");
					Adventurer.Progress.remove("WOMAN APPROACHING");
					Adventurer.Progress.add("TOUCHED BY WOMAN");
					AdventureModel.ReadINI("ACT 3");
					Adventurer.Progress.add("LEFT BLACK ROOM");
				} 
					if (action.equalsIgnoreCase("LOOK") == true){
						EnterSecret(SC.look(location));
					} else if (action.equalsIgnoreCase("GO NORTH") == true){
						EnterSecret(SC.goNorth(location));
					} else if (action.equalsIgnoreCase("GO SOUTH")== true){
						EnterSecret(SC.goSouth(location));
					} else if (action.equalsIgnoreCase("GO EAST") == true){
						EnterSecret(SC.goEast(location));
					} else if (action.equalsIgnoreCase("GO WEST") == true){
						EnterSecret(SC.goWest(location));
					} else if (action.equalsIgnoreCase("ITEMS") == true){
						EnterSecret(SC.items(location));		
					} else {
						System.out.println("You can't do that right now");
						EnterSecret(location);
					} 
			}while (fin==0);
			AdventureModel.AlternateEnding();
		}
		/**
		 * @constructor Public Method
		 * @param location
		 * @return none
		 * @keywords Alternate endings, locations, Look 
		 * @notes changing the endings of the game based on how far the player gets
		 */

		public static void AlternateEnding(){
			System.out.println("Do you still want to go find Pablo?");
			Scanner x = new Scanner(System.in);
			String choice = x.nextLine();
			if (choice.equalsIgnoreCase("YES")){
				Adventurer.Progress.add("ALT ENDING YES");
				EndingCheck();
			} else if (choice.equalsIgnoreCase("NO")){
				Adventurer.Progress.add("ALT ENDING NO");
				EndingCheck();
			} else {
				System.out.println("Don't dodge the question. Do you still want to go find Pablo?");
				AlternateEnding();
			}
		}
		/**
		 * @constructor Public Method
		 * @param location
		 * @return none
		 * @keywords End 1,2,3,4,5,6
		 * @notes This accesses the ini file and implements different endings
		 */

		public static void EndingCheck(){
			if (Adventurer.Progress.contains("ALT ENDING YES")){
				AdventureModel.ReadINI("END 6");
			} else if (Adventurer.Progress.contains("ALT ENDING NO")){
				AdventureModel.ReadINI("END 5");
			} else if (Adventurer.Progress.contains("SHOT WOMAN")){
				AdventureModel.ReadINI("END 4");
			} else if (Adventurer.Progress.contains("TOUCHED BY WOMAN")){
				AdventureModel.ReadINI("END 3");
			} else if (Adventurer.Progress.contains("IGNORED WOMAN")){
				AdventureModel.ReadINI("END 2");
			} else {
				AdventureModel.ReadINI("END 1");
			}
			
			System.out.println("......THE END");
			System.exit(0);
		}

	}
	
	

	

