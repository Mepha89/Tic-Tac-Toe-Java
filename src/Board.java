/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 */

public class Board {

    private char[][] board = new char[3][3];
    private static final int rows = 3;
    private static final int cols = 3;

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
        /*
         * TBD
         */
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (i == move.getI() && j == move.getJ()) {
                    board[i][j] = move.getPiece();
                } else {
                    board[i][j] = other.get(i, j);
                }
            }
        }
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        String boardTxt = "-------------\n";
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0)
                    boardTxt += "| " + board[i][j] + " | ";
                else if (j == 1)
                    boardTxt += board[i][j] + " | ";
                else if (j == 2)
                    boardTxt += board[i][j] + " |";
            }
            boardTxt += "\n-------------\n";
        }
        return boardTxt;
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        return board[i][j];
    }

    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (board[i][j] == ' ') {
                    return false;
                };
            }
        }
        return true;
    }

    /**
     *
     * @param i
     * @param j
     * @return true if spot is empty, false if piece placed
     */
    public boolean isSpotEmpty(int i, int j) {
        if (board[i][j] ==' ') {
            return true;
        }
        else {
            return false;
        }
    }
}
