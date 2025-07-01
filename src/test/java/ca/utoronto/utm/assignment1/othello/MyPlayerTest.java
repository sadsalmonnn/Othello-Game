package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MyPlayerTest {
  Player[] players = new Player[2];
  Othello othello = new Othello();


  @BeforeEach
  public void setUp() throws Exception {
    players[0] = new PlayerGreedy(othello, OthelloBoard.P1);
    players[1] = new PlayerRandom(othello, OthelloBoard.P2);
  }

  @org.junit.jupiter.api.Test
  public void testGetMove(){
    assertEquals(players[0].getMove().getCol(), new Move(2, 4).getCol());
    assertEquals(players[0].getMove().getRow(), new Move(2, 4).getRow());
    assertEquals(players[1].getMove() instanceof Move, true);
  }

}
