/**
 * Realization of AI interface using simplistic random placement strategy.
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();

    private char aiPiece;
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        if (aiIsX == true) {
            aiPiece = 'X';
        } else {
            aiPiece = 'O';
        }
    }

    public Move chooseMove(Board board) {
        int choice;
        do {
            choice = random.nextInt(9);
        } while (board.get(choice/3, choice%3)!= ' ');

        Move aiMove = new Move(choice/3, choice%3, aiPiece);

        return aiMove;
    }
}
