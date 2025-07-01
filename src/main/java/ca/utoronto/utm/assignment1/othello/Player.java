package ca.utoronto.utm.assignment1.othello;

/**
 * The Player is an abstract class that defines the basics of a player for an
 * Othello game. This includes the player's character and the Othello game. This
 * class serves as a base class for different types of players.
 */
public abstract class Player {
  protected Othello othello;
  protected char player;

  /**
   * Constructs a Player with the given Othello game instance and player
   * character.
   * 
   * @param othello
   * @param player
   */
  public Player(Othello othello, char player) {
    this.othello = othello;
    this.player = player;
  }

  /** Get the player's move. */
  public abstract Move getMove();
}
