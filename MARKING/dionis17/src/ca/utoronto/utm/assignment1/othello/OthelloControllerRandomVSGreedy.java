package ca.utoronto.utm.assignment1.othello;

/**
 * An OthelloControllerRandomVSGreedy is an OthelloController.The goal here is
 * to print out the probability that Random wins and Greedy wins as a result of
 * playing 10000 games against each other with P1=Random and P2=Greedy. What is
 * your conclusion, which is the better strategy?
 * 
 * @author arnold
 *
 */
public class OthelloControllerRandomVSGreedy extends OthelloController {

	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like:
	 * Probability P1 wins=.75
	 * Probability P2 wins=.20
	 * 
	 * @param args
	 */
	private PlayerRandom player1;
	private PlayerGreedy player2;

	/**
	 * Constructs an OthelloControllerRandomVSGreedy controller. This constructor
	 * initializes the Othello game and sets up P1, a player with a random strategy,
	 * and P2, a greedy computer player.
	 */
	public OthelloControllerRandomVSGreedy() {
		super();
		this.player1 = new PlayerRandom(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run a game between a player with a random strategy, P1, and the computer
	 * greedy player, P2. The game is played until it is over.
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
	 * Run main to play 10000 games between a computer with a random strategy
	 * against a greedy computer, that picks the first move which maximizes its
	 * number of tokens on the board. The winner of the game is counted, and the
	 * probability of winning is printed out for each player.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int p1wins = 0, p2wins = 0, numGames = 10000;

		for (int i = 0; i < numGames; i++) {

			OthelloControllerRandomVSGreedy oc = new OthelloControllerRandomVSGreedy();
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
