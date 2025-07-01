package ca.utoronto.utm.assignment1.othello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a Human player in the Othello game. This player is controlled by
 * the user with prompts, taking input in the form of row and column indices.
 * This input is validated to ensure it is an acceptable move.
 * 
 * @author arnold
 *
 */
public class PlayerHuman extends Player {
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Constructs a Human player with the given Othello game instance and player
	 * character.
	 *
	 * @param othello
	 * @param player
	 */
	public PlayerHuman(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * 
	 * @return a Move object representing the move entered by the user
	 */
	public Move getMove() {
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	/**
	 * Prompts the user with message to enter an integer between 0 and 7
	 * (inclusive). If the user enters a valid integer, then the integer is
	 * returned. Otherwise, the user is prompted until a valid integer is entered.
	 * If an I/O Exception occurs, then -1 is returned.
	 * 
	 * @param message the message to print to the user
	 * @return the integer entered by the user
	 */
	private int getMove(String message) {
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
