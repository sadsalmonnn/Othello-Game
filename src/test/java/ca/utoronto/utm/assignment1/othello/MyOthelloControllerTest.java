package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MyOthelloControllerTest {
  private char[] possibleWinner = { OthelloBoard.P1, OthelloBoard.P2, OthelloBoard.EMPTY };
  OthelloController[] games = { new OthelloControllerRandomVSGreedy(),
      new OthelloControllerRandomVSRandom() };

  @BeforeEach
  public void setUp() throws Exception {

    for (int i = 0; i < games.length; i++) {
      games[i].play();
    }
  }

  @org.junit.jupiter.api.Test
  public void testPlay() {
    char result = 'N';

    for (int i = 0; i < games.length; i++) {
      for (char winner : possibleWinner) {
        if (winner == games[i].othello.getWinner()) {
          result = winner;
        }
      }
      assertEquals(games[i].othello.getWinner(), result);
    }
  }
}
