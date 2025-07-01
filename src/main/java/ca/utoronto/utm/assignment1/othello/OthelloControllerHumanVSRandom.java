package ca.utoronto.utm.assignment1.othello;

/**
 * An OthelloControllerHumanVSRandom is an OthelloController. This controller
 * uses the Model classes to allow the Human player P1 to play the computer P2.
 * The computer, P2 uses a random strategy.
 * 
 * @author arnold
 *
 */
public class OthelloControllerHumanVSRandom extends OthelloController {
	private PlayerHuman player1;
	private PlayerRandom player2;

	/**
	 * Constructs an OthelloControllerHumanVSRandom controller. This constructor
	 * initializes the Othello game and sets up P1, a human player, and P2, a
	 * computer player, with random strategy.
	 */
	public OthelloControllerHumanVSRandom() {
		super();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerRandom(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run a game between a human player, P1, and the computer greedy player, P2.
	 * The game is played until it is over. The board is displayed with each move.
	 * The final score is displayed when the game is over.
	 */
	public void play() {
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhosTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}

	/**
	 * Run main to play a Human against a greedy computer, that picks the first move
	 * which maximizes its number of tokens on the board.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OthelloControllerHumanVSRandom oc = new OthelloControllerHumanVSRandom();
		oc.play(); // this should work
	}
}
