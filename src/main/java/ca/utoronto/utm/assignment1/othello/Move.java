package ca.utoronto.utm.assignment1.othello;

/**
 * Capture a Move. This includes integers, row and column, which is used to
 * represent a move in Othello. It knows how to represent itself in coordinate
 * format.
 * 
 * @author arnold
 *
 */
public class Move {
	private int row, col;

	/**
	 * Construct a Move
	 * 
	 * @param row the index of a row for a move
	 * @param col the index of a column for a move
	 */
	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * 
	 * @return the row of this move
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @return the column of this move
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * @return a string representation of this in coordinate format, e.g. (4,7)
	 */
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}
}
