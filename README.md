# TextAdventure
## Text Adventure Group Project
### ITI 202: Object-Oriented Programming

Professor Charlie File
Due Date: 2/24/2017

This is group assignment.  You are allowed to collaborate within your group, but not with other groups.  You should have no more than three people in your group.

Please refer to the Syllabus for information regarding Rutgers' Academic Integrity Policy. 

## Purpose

- To give you an opportunity to put into practice everything you have learned about object-oriented programming
- To let you express your creativity
- To give you a chance to experience what it's like to work on a software development team
- To practice giving oral presentations

## Overview

For this final group project, the goal is to write a text adventure game.  Never played one before?  
Examples:
- [http://www.ifiction.org/](http://www.ifiction.org/)
- "Colossal Cave Adventure" (available on both iOS and Android) 
- "Frotz" (iOS only)

The basic concept is that everything in the game is described via text, and the user gets a specific set of commands (up, down, left, right, eat, examine, store, etc.) that they can perform.  The goal is typically to move through a series of rooms until reaching the end goal.

This project will consist of 3 components:

1. Game Map, Documentation, Instructions - 20%
2. Source Code - 60%
3. Presentation Demo - 20%

## Game Map, Documentation, Instructions - 20%

An important part of any game (and, indeed, any piece of software) are the instructions and guides that go with it.   The Game Map should include the title of the game, the rooms and their connections, and any additional information such as enemies or interactive objects. The Game Map should also look pretty.  It does not need to be something created in Photoshop, but it should be something a little better than Microsoft Paint.

I recommend collaborating on a Google document such as Google Slides or Google Drawing as a good starting point.  The process of creating your Game Map, Documentation, Instructions, etc. will help you to figure out what the overall structure of your world will look like. 

Note that a rough draft of the Game Map is due before the Presentation.  This is mainly for me to provide you with feedback, so the more detailed you can make it, the more feedback I will be able to provide you. Include a walkthrough to tell me how to play your game to a successful completion.

Deliverables for this portion include:

1.	An attractive game map
2.	A user guide, including instructions and a walkthrough that describes how to successfully complete the game
3.	An internal design and requirements document that the team will use to move from the design stage to the implementation stage. This document should be as complete as possible; ideally the team should be able to send this document to a team of offshore contractors and get back exactly the game they expect.

This design document should include:

- A description of the flow, logic, and organization of the game, including a flowchart of user interaction with the game
- A full list of the rooms and their characteristics, including any puzzles or objects that appear in them
- A full list of commands that the player can execute, what they can be executed on, and the expected outcome
- Error handling and reporting requirements
- Anything else you feel is needed

## Source Code - 60%

In a text adventure game, the central character is the Adventurer, which is an object representing the human player. You need this object because you need to keep track of where the player is, what the player is holding, and anything else you need to remember about the player.

A text adventure also contains locations, usually called Rooms.  A "Room" might be anyplace: A hallway, in a boat, a wooded area, at the north end of a long corridor, etc.

A text adventure has Things, such as knives, batteries, vending machines, flowers, etc. Most Things have some use in the game (but they also may not). If a Thing has a multi-word name, such as "box of chocolates," the player has to refer to it by one word, possibly "box" and possibly "chocolates." (If you wish, you could allow either word.)

A game is supposed to be fun. There are some minimal conditions for a game to be fun:
- A game should have a goal. The goal should be either stated explicitly, or quickly discovered. Wandering around aimlessly for a long time, wondering what you are supposed to be doing, isn't much fun.  This can be accomplished by having a sense of mystery (maybe something happened and the player must figure out how or why), or a sense of urgency (the Princess has been kidnapped and you must save her!), for example. 
- A game should have puzzles to solve. The important thing to realize about puzzles is that they are always much harder than you expect them to be. (It would be a good idea to try out your game on a friend or classmate before handing it in.)
- A game should have a mood: It should be tense, or funny, or grim, or ridiculous. Or something. Decide on a mood and try to achieve it.
- A game should reward the player who wins. At the very least, provide a congratulatory message. Don't leave the player wondering if the game is over.

The adventurer plays the game by typing in commands. Commands consist of one or two words (more than two is too much work).

There are several commands that are found in nearly every game:
```
go [direction]
```
Moves the Adventurer from one Room to another. The direction is usually one of "north", "south", "east", "west", and sometimes "up" and "down." Occasionally other directions are used, such as "northwest" or "sideways". Directions can usually be abbreviated, such as "n" for north, "u" for up, etc. Many games allow the verb "go" to be omitted, so "n" is short for "go north".
```
look
```
Gives a full description of the Room that the Adventurer is in.
look thing	Gives a full description of the named Thing. For this command to work, the Adventurer must either be holding the named Thing, or at least be in the same Room with it. Looking at a thing sometimes reveals surprising details about it.
```
take [thing]
```
Picks up a Thing that is in the same room as the Adventurer. The game might contain Things that cannot be picked up, such as a vending machine, or a cave painting.
```
drop [thing]
```
Puts down a Thing that the player is holding. Usually this means that the Thing is put into the Room that the Adventurer is in, but there may be exceptions (if the Adventurer is on a tightrope, for example), depending on the game.

Here is a command that is occasionally available:
```
use [thing]
```
This is a very general command, whose meaning depends on the Thing. Using a gun is very different from using a key, or a chocolate. Most often, though, games require more specific verbs: shoot gun, open safe, eat chocolate. Depending on your game and specific items, this may or may not be needed.

Every command should get a response. If there is nothing much to say, the response can be simply OK. If the command can't be done, the player should be told, for instance, "I don't understand" or "You can't go that way." When the player moves to a new location, the response should usually be a full description of the newly-entered Room.

### Program Details

An adventure game consists of:

1. A TextAdventure class. This class:
  - Contains the main method used to start the game.
  - Talks to the AdventureModel and to the Adventurer classes, as needed.
2. An AdventureModel class. This class:
  - Creates the Rooms, the Things, and the Adventurer.
  - Connects the Rooms with "paths" to other Rooms.
  - Places Things in the Rooms.
  - Places the Adventurer in some Room.
  - Accepts commands from the player, and executes them.
  - As commands are entered, they should be copied to the main text area.
  - The method that executes commands should return a String to be displayed in the main text area.
3. An Adventurer (the human player).
  - An adventurer has:
    - A location (some room).
    - An inventory (the things being carried).  When the player executes the "take thing" command, the item should be added to the inventory.
  - An adventurer can:
    - Move from room to room.
    - Carry a number of objects.
    - Pick up, drop, look at, and use various objects.
4. Some number of Rooms. A room has:
  - A name.
  - A description, possibly several sentences long.
  - Contents: the things in the room.
  - Exits: paths to other rooms (usually some of north, south, east, and west).
  - Some number of Things. A thing has:
    - A name
	  -(If some of your Things have multi-word names, such as "fire-breathing dragon" or "that thing that your aunt gave you that you don't know what it is", then you might want to give your Things both a full name and a one-word name.)
    - A description, to be shown when the adventurer "looks" at it.
    - One or more methods for using the Thing. You can have a multi-purpose use verb, or you can make up your own verbs (for instance, drink water or pour water), which determines what the thing does when the adventurer tries to use it.
    - For simplicity, we will say that the adventurer can only use things being carried (in the inventory)
    - Whether "using" a thing does anything or not (or exactly what it does) can depend on what room it is in, what other things are in the room or in the inventory, or any other conditions you can think of.

Your assignment is to write an adventure game with your group. It should have:

- A general location (battlefield, outer space, etc.)
- At least 10 rooms
- At least 6 objects (At least 4 of the objects should have some "use" relevant to the game.)
- An inventory for the player to store items
- At least 3 examples of Inheritance
- At least 2 examples of Overridden Methods
- Be sure only the minimum methods are public; most of your methods and variables should be private

The theme of the game, and the goal of the game, is up to you.
So that your adventure game is not too difficult to grade, please don't let the player "die" or otherwise get into a situation from which there is no possibility of winning the game.

### Structure of the program 

- Project name: TextAdventure
- Package name: adventure
- Class names and method signatures: As above.
- Submit all file via GitHub

The above are requirements. You may have additional classes and methods as needed.

## Presentation Demo - 20%

After the Game Map and Source Code have been completed, your final task of this project will be to present your Text Adventure game to the class in a 5-10 minute presentation.

I expect each team member to participate.  During the presentation, you are expected to present your Game Map and a demo of your Text Adventure Game.  

Do your best to set the scene for your game.  Imagine that you were pitching your game to a video game company such as Activision: why should they publish YOUR game?  Be as creative as possible: do a skit, use Powerpoint, whatever fits your game.

Just don't forget to demo the game, and show the class your Game Map.

## Due dates

This project will have three milestones, at which time you are expected to deliver part of your work on this project. They are:

1. Group Assignment 1, due 2/24/2017
  - Demonstrate core implementation of the game engine including TestAdventure, AdventureModel, and Adventurer, and Room classes, demonstrating:
    - Setup and loading of the game
    - Basic player I/O via the console, including the ability to accept commands
    - Basic Adventurer interaction with a single room, including the ability to apply commands to that room that will generate appropriate output
    - (Navigation is not need at this point, just commands like look, take, use, etc.)
    - Note that at this point I am interested only in *core functionality*. I'm not looking for a fully-realized game world (that comes in part 2) or a wide variety of Rooms, Things, and Puzzles to interact with (that comes in part 3).
2. Group Assignment 2, due 3/24/2017
  - Core design of the game
  - Production of the Game Map, Instructions, and Documentation for external audiences (the players)
  - Creation of Design and Requirements documentation for internal audiences (the development team)
3. Group Assignment 3, due 4/21/2017
  - Completion of code, meeting all the requirements listed above
  - Preparation of 5-10 minute demo of your game to the class

Your Presentation will occur on the final day of class, 4/21/2017.  On this day, you will also present your Game Map.

* I reserve the right to give extra credit to particularly good games. *

On the final day of class, you will also complete a reflection on the overall project, including a peer review of your team members' contributions. I will take this peer review into consideration when assigning your final grades.
