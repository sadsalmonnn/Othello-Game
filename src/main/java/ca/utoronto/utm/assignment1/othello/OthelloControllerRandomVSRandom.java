package ca.utoronto.utm.assignment1.othello;

/**
 * An OthelloControllerRandomVSRandom is an OthelloController. Determine whether
 * the first player or second player has the advantage when
 * both are playing a Random Strategy.
 * 
 * Do this by creating two players which use a random strategy and have them
 * play each other for 10000 games. What is your conclusion, does the first or
 * second player have some advantage, at least for a random strategy?
 * State the null hypothesis H0, the alternate hypothesis Ha and
 * about which your experimental results support. Place your short report in
 * randomVsRandomReport.txt.
 * 
 * @author arnold
 *
 */
public class OthelloControllerRandomVSRandom extends OthelloController {
	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like
	 * Probability P1 wins=.75
	 * Probability P2 wins=.20
	 * 
	 * @param args
	 */
	private PlayerRandom player1, player2;

	/**
	 * Constructs an OthelloControllerRandomVSRandom controller. This constructor
	 * initializes the Othello game and sets up two computer players, each with
	 * random strategies.
	 */
	public OthelloControllerRandomVSRandom() {
		super();
		this.player1 = new PlayerRandom(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerRandom(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run a game between a two computer players, with random strategies, P1 and P2.
	 * The game is played until it is over.
	 */
	public void play() {
		while (!othello.isGameOver()) {
			Move move = null;
			char whosTurn = othello.getWhosTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();
			othello.move(move.getRow(), move.getCol());
		}
	}

	/**
	 * Run main to play 10000 games between two computers each with random
	 * strategies. The winner of the game is counted, and the probability of winning
	 * is printed out for each player.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int p1wins = 0, p2wins = 0, numGames = 10000;

		for (int i = 0; i < numGames; i++) {

			OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
			oc.play();

			if (oc.othello.getWinner() == OthelloBoard.P1) {
				p1wins++;
			} else if (oc.othello.getWinner() == OthelloBoard.P2) {
				p2wins++;
			}
		}
		System.out.println("Probability P1 wins=" + (float) p1wins / numGames);
		System.out.println("Probability P2 wins=" + (float) p2wins / numGames);
	}
}
