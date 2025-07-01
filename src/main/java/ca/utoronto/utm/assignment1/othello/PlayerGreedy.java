package ca.utoronto.utm.assignment1.othello;

/**
 * PlayerGreedy makes a move by considering all possible moves that the player
 * can make. Each move leaves the player with a total number of tokens.
 * getMove() returns the first move which maximizes the number of
 * tokens owned by this player. In case of a tie, between two moves,
 * (row1,column1) and (row2,column2) the one with the smallest row wins. In case
 * both moves have the same row, then the smaller column wins.
 * 
 * Example: Say moves (2,7) and (3,1) result in the maximum number of tokens for
 * this player. Then (2,7) is returned since 2 is the smaller row.
 * 
 * Example: Say moves (2,7) and (2,4) result in the maximum number of tokens for
 * this player. Then (2,4) is returned, since the rows are tied, but (2,4) has
 * the smaller column.
 * 
 * See the examples supplied in the assignment handout.
 * 
 * @author arnold
 *
 */
public class PlayerGreedy extends Player {

	/**
	 * Constructs a computer Greedy player with the given Othello game instance and
	 * player character.
	 * 
	 * @param othello
	 * @param player
	 */
	public PlayerGreedy(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * Returns the move for the current player that it maximizes the number of
	 * tokens for this player. In case of a tie, the first move found which
	 * maximizes the number of tokens is returned.
	 * 
	 * @return the best Move for the current player
	 */
	public Move getMove() {
		int lrow = 0;
		int lcol = 0;
		int lcount = 0;
		int currentmove;

		int[] directions = { -1, 0, 1 };

		// Loop through each square on the board and each direction
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				for (int drow : directions) {
					for (int dcol : directions) {

						currentmove = this.othello.checkPlayerValidMove(row, col, drow, dcol, player);

						if (currentmove > lcount) {
							lcount = currentmove;
							lrow = row;
							lcol = col;
						}
					}
				}
			}
		}
		return new Move(lrow, lcol);
	}
}
