# Tic-Tac-Toe-Java
This is a Tic-Tac-Toe Object Oriented Java game made for ECE-5010 at Memorial University of Newfoundland in Winter 2023

The application is a Java CLI based Tic-Tac-Toe game.
It can be run on `src/TicTacToeApplication.java`

## Classes Implemented:
- **TicTacToeApplication**: Contains the main method. Creates a ConsoleRunner and then calls its mainLoop method.
- **ConsoleRunner**:  Prompts the user to determine the parameters of the Game constructor.  Creates a Game and manages the alternating calls to the ‘place’ methods in Game. Prompts the user for inputs and outputs the state of the board to the console.
- **Game**: Represents the logic of the game in terms of detecting wins or draws.  Also places new pieces for the human player or AI.
- **Board**: An immutable class that represents the state of the 3×3 tic-tac-toe board.  An immutable object cannot be changed.
- **GameStatus**: Enum type representing the possible states of a running game.
- **Move**: Represents a move (by the player or the AI) to a particular cell.
- **AI**: Interface stipulating that an AI is a class that implements ‘chooseMove’.
- **SmartAI and DumbAI**: Classes realizing the AI interface using different gameplay strategies.
