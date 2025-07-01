package ca.utoronto.utm.assignment1.othello;

/**
 * An OthelloControllerHumanVSHuman is an OthelloController. This controller
 * uses the Model classes to allow the Human player P1 to play another Human
 * player P2.
 * 
 * @author arnold
 */
public class OthelloControllerHumanVSHuman extends OthelloController {
	private PlayerHuman player1, player2;

	/**
	 * Constructs an OthelloControllerHumanVSHuman controller. This constructor
	 * initializes the Othello game and sets up two human players, P1 and P2.
	 */
	public OthelloControllerHumanVSHuman() {
		super();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run a game between two human players, P1 and P2. The game is played until it
	 * is over. The board is displayed with each move. The final score is displayed
	 * when the game is over.
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
	 * Run main to play a Human against another Human.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
		oc.play();
	}
}
