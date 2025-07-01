package ca.utoronto.utm.assignment1.othello;

/**
 * The OthelloController is an abstract class containing all the basics for an
 * Othello game. This class is used to play the Othello game, where the abstract
 * method play() contains the logic for the game, including alternation turns
 * and print out the game state reports.
 */
public abstract class OthelloController {
	protected Othello othello;

	/**
	 * Create an OthelloController. This consutrctor initialiizes the Othello game,
	 * which represents the state of the game.
	 */
	public OthelloController() {
		this.othello = new Othello();
	}

	/**
	 * Play the Othellogame. This will involve making moves until the game is over.
	 */
	public abstract void play();

	/**
	 * Print out the move that has just been made.
	 * 
	 * @param whosTurn the player who made the move
	 * @param move     the move that was made
	 */
	protected void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}

	/**
	 * Report the current state of the board. This is used at the start and during
	 * the Othello game. The board state, number of tokens, and whose turn it is, is
	 * printed out.
	 */
	protected void report() {
		String s = othello.getBoardString() + "\n" + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  "
				+ othello.getWhosTurn() + " moves next";
		System.out.println(s);
	}

	/**
	 * Print out the final state of the board. This is used at the end of the
	 * Othello game. The board state, number of tokens, and whose turn it is, is
	 * printed out.
	 */
	protected void reportFinal() {
		String s = othello.getBoardString() + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2)
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
}
