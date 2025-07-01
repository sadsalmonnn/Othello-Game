package ca.utoronto.utm.assignment1.othello;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author arnold
 *
 */
public class PlayerRandom extends Player {
	private Random rand = new Random();

	/**
	 * Constructs a computer player, that has a random strategy with the given
	 * Othello game instance and player character.
	 * 
	 * @param othello
	 * @param player
	 */
	public PlayerRandom(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * Returns a random move from the list of all possible moves for this player.
	 * 
	 * @return a Move object
	 */
	public Move getMove() {
		ArrayList<Move> possiblemoves = getPossibleMoves();
		Move generatemove = possiblemoves.get(rand.nextInt(possiblemoves.size()));
		return generatemove;
	}

	/**
	 * Returns a list of all possible moves for this player.
	 * 
	 * @return an ArrayList of Move objects
	 */
	private ArrayList<Move> getPossibleMoves() {
		ArrayList<Move> possiblemoves = new ArrayList<Move>();
		int[] directions = { -1, 0, 1 };

		// Loop through each square on the board and each direction
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				for (int drow : directions) {
					for (int dcol : directions) {

						if (this.othello.checkPlayerValidMove(row, col, drow, dcol, player) > 0) {
							possiblemoves.add(new Move(row, col));
						}
					}
				}
			}
		}
		return possiblemoves;
	}
}
