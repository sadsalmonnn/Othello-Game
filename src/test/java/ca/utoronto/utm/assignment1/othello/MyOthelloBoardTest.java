package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MyOthelloBoardTest {
  OthelloBoard board;

  int[][] moves = {{1, 0}, {2, 4}, {3, 1}, {4, 1}, {3, 0}, {4, 2}, {4, 3}, {1, 4}, {0, 3}, {4, 4},
      {3, 2}, {0, 2}, {3, 4}, {2, 0}, {0, 4}, {0, 0}, {4, 0}};

  @BeforeEach
  public void setUp() throws Exception {
    board = new OthelloBoard(5);
    board.move(1, 3, 'X');
    board.move(2, 3, 'O');
    board.move(3, 3, 'X');
    board.move(0, 1, 'O');

    /*
     * . o . . .
     * . o x x .
     * . o x x .
     * . . . x .
     * . . . . .
     */
  }

  @org.junit.jupiter.api.Test
  public void testGetDimension() {
    // board of different sizes
    OthelloBoard testboard = new OthelloBoard(3);
    assertEquals(testboard.getDimension(), 3);
    // board during the game
    assertEquals(board.getDimension(), 5);
  }

  @org.junit.jupiter.api.Test
  public void testOtherPlayer() {
    assertEquals(OthelloBoard.otherPlayer(OthelloBoard.P1), OthelloBoard.P2);
    assertEquals(OthelloBoard.otherPlayer(OthelloBoard.P2), OthelloBoard.P1);
    assertEquals(OthelloBoard.otherPlayer('a'), OthelloBoard.EMPTY);
  }

  @org.junit.jupiter.api.Test
  public void testGet() {
    assertEquals(board.get(0, 0), OthelloBoard.EMPTY);
    assertEquals(board.get(1, 2), OthelloBoard.P1);
    assertEquals(board.get(3, 2), OthelloBoard.EMPTY);
    assertEquals(board.get(4, 4), OthelloBoard.EMPTY);
    assertEquals(board.get(1, 1), OthelloBoard.P2);
  }

  @org.junit.jupiter.api.Test
  public void testValidCoordinate() {
    assertEquals(board.validCoordinate(0, 0), true);
    assertEquals(board.validCoordinate(1, 2), true);
    assertEquals(board.validCoordinate(3, 2), true);
    assertEquals(board.validCoordinate(5, 5), false);
    assertEquals(board.validCoordinate(0, 5), false);
    assertEquals(board.validCoordinate(-1, 0), false);
    assertEquals(board.validCoordinate(0, -1), false);
    assertEquals(board.validCoordinate(-5, -5), false);
  }

  @org.junit.jupiter.api.Test
  public void testHasMove() {
    // when game starts
    OthelloBoard testboard = new OthelloBoard(3);
    assertEquals(testboard.hasMove(), OthelloBoard.BOTH);
    testboard.move(0, 2, 'X');
    testboard.move(1, 2, 'O');

    // when only x, during game
    assertEquals(testboard.hasMove(), OthelloBoard.P1);
    testboard.move(2, 0, 'X');

    assertEquals(testboard.hasMove(), OthelloBoard.P1);
    testboard.move(2, 2, 'X');
    // when game ends before all board is full
    assertEquals(testboard.hasMove(), OthelloBoard.EMPTY);

    // when game ends after all board is full
    int count = 1;
    for (int[] move : moves) {
      if (count % 2 == 0) {
        board.move(move[0], move[1], 'O');
      } else {
        board.move(move[0], move[1], 'X');
      }
      count++;
    }
    assertEquals(testboard.hasMove(), OthelloBoard.EMPTY);
  }

  @org.junit.jupiter.api.Test
  public void testMove() {

    // outof bounds
    assertEquals(board.move(-1, -1, 'X'), false);
    assertEquals(board.move(5, 5, 'X'), false);
    assertEquals(board.move(-5, -5, 'X'), false);

    // inbounds but not valid
    assertEquals(board.move(0, 0, 'O'), false);
    assertEquals(board.move(1, 3, 'X'), false);
    assertEquals(board.move(0, 4, 'X'), false);
  }

  @org.junit.jupiter.api.Test
  public void testGetCount() {
    assertEquals(board.getCount('X'), 5);
    assertEquals(board.getCount('O'), 3);

    int count = 1;
    for (int[] move : moves) {
      if (count % 2 == 0) {
        board.move(move[0], move[1], 'O');
      } else {
        board.move(move[0], move[1], 'X');
      }
      count++;
    }
    assertEquals(board.getCount('X'), 13);
    assertEquals(board.getCount('O'), 12);
  }

  @org.junit.jupiter.api.Test
  public void testNonMutatedFlip() {
    OthelloBoard copyboard = new OthelloBoard(5);
    copyboard.move(1, 3, 'X');
    copyboard.move(2, 3, 'O');
    copyboard.move(3, 3, 'X');
    copyboard.move(0, 1, 'O');
    int result = board.nonMutatedFlip(2, 4, 0, -1, OthelloBoard.P2);
    assertEquals(board.toString(), copyboard.toString());
    assertEquals(result, 3);

    assertEquals(board.nonMutatedFlip(2, 3, 0, -1, OthelloBoard.P2), -1);
    assertEquals(board.nonMutatedFlip(2, 3, 0, 0, OthelloBoard.P1), -1);
    assertEquals(board.nonMutatedFlip(4, 3, 0, 1, OthelloBoard.P1), -1);
  }

  @org.junit.jupiter.api.Test
  public void testToString() {
    assertEquals("""
          0 1 2 3 4\s
         +-+-+-+-+-+
        0| |O| | | |0
         +-+-+-+-+-+
        1| |O|X|X| |1
         +-+-+-+-+-+
        2| |O|X|X| |2
         +-+-+-+-+-+
        3| | | |X| |3
         +-+-+-+-+-+
        4| | | | | |4
         +-+-+-+-+-+
          0 1 2 3 4\s
        """, board.toString());

    int count = 1;
    for (int[] move : moves) {
      if (count % 2 == 0) {
        board.move(move[0], move[1], 'O');
      } else {
        board.move(move[0], move[1], 'X');
      }
      count++;
    }

    assertEquals("""
          0 1 2 3 4\s
         +-+-+-+-+-+
        0|O|O|O|X|X|0
         +-+-+-+-+-+
        1|O|O|O|X|X|1
         +-+-+-+-+-+
        2|O|O|X|X|X|2
         +-+-+-+-+-+
        3|X|X|X|X|X|3
         +-+-+-+-+-+
        4|X|O|O|O|O|4
         +-+-+-+-+-+
          0 1 2 3 4\s
          """, board.toString());
  }

}
