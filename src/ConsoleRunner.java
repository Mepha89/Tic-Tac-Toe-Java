/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     */
    public ConsoleRunner() {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to play as X (Y/N):\n");
        String ans1 = scanner.nextLine();

        if (ans1.matches("Y")) {
            playerIsX = true;
        } else {
            playerIsX = false;
        }

        boolean challenging = false;
        System.out.println("Do you want a challenge (Y/N):\n");
        String ans2 = scanner.nextLine();

        if (ans2.matches("Y")) {
            challenging = true;
        }

        game = new Game(playerIsX, challenging);
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        //print empty board
        System.out.println(game.getBoard().toString());

        //loop begins
        while (true) {
            if (playerIsX) {
                int xCord;
                int yCord;
                //ask for the positions
                System.out.println("Enter desired x-coordinate:");
                xCord = scanner.nextInt();
                System.out.println("Enter desired y-coordinate:");
                yCord = scanner.nextInt();

                game.placePlayerPiece(yCord, xCord);
                System.out.println("After your move:\n");
                System.out.println(game.getBoard().toString()); //prints the board
                if (game.getStatus() != GameStatus.IN_PROGRESS) {
                    break;
                }

                //ai makes its move
                game.aiPlacePiece();
                System.out.println("After AI move:\n");
                System.out.println(game.getBoard().toString());
                if (game.getStatus() != GameStatus.IN_PROGRESS) {
                    break;
                }
            } else {
                int yCord;
                int xCord;

                //ai makes its move
                game.aiPlacePiece();
                System.out.println("After AI move:\n");
                System.out.println(game.getBoard().toString());
                if (game.getStatus() != GameStatus.IN_PROGRESS) {
                    break;
                }

                //ask for the positions
                System.out.println("Enter desired x-coordinate:");
                xCord = scanner.nextInt();
                System.out.println("Enter desired y-coordinate:");
                yCord = scanner.nextInt();

                game.placePlayerPiece(yCord, xCord);
                System.out.println("After your move:\n");
                System.out.println(game.getBoard().toString()); //prints the board
                if (game.getStatus() != GameStatus.IN_PROGRESS) {
                    break;
                }
            }
        }

        //checks if player won and outputs result
        if ((playerIsX == true && game.getStatus() == GameStatus.X_WON) || (playerIsX == false && game.getStatus() == GameStatus.O_WON)) {
            System.out.println("You won!");
        } else if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("You lost!");
        }

    }
}
