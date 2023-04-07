import java.util.Random;

/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private char playerPiece;
    private char aiPiece;

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        if (playerIsX) {
            playerPiece = 'X';
            aiPiece = 'O';
        } else {
            playerPiece = 'O';
            aiPiece = 'X';
        }
        status = GameStatus.IN_PROGRESS;
        if(challenging == true) {
            ai = new SmartAI(!playerIsX);
        } else {
            ai = new DumbAI(!playerIsX);
        }
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        if (hasWon('X')) {
            status = GameStatus.X_WON;
        } else if (hasWon('O')) {
            status = GameStatus.O_WON;
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
        }
        return status;
    }

    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
        boolean isSpotEmpty = board.isSpotEmpty(i, j);
        if (isSpotEmpty) {
            //create Move object
            Move playerMove = new Move(i, j, playerPiece);
            //override board with new board
            board = new Board(board, playerMove);
        }
        return isSpotEmpty;
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        board = new Board(board, ai.chooseMove(board));
    }

    /**
     * checks if piece won
     */
    public boolean hasWon(char piece) {
        return ((board.get(0, 0) == piece && board.get(0, 1) == piece && board.get(0, 2) == piece) ||
                (board.get(1, 0) == piece && board.get(1, 1) == piece && board.get(1, 2) == piece) ||
                (board.get(2, 0) == piece && board.get(2, 1) == piece && board.get(2, 2) == piece) ||
                (board.get(0, 0) == piece && board.get(1, 0) == piece && board.get(2, 0) == piece) ||
                (board.get(0, 1) == piece && board.get(1, 1) == piece && board.get(2, 1) == piece) ||
                (board.get(0, 2) == piece && board.get(1, 2) == piece && board.get(2, 2) == piece) ||
                (board.get(0, 0) == piece && board.get(1, 1) == piece && board.get(2, 2) == piece) ||
                (board.get(0, 2) == piece && board.get(1, 1) == piece && board.get(2, 0) == piece));
    }
}
