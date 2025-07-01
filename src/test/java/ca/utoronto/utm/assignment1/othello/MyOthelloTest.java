package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MyOthelloTest {
    Othello othello;
    int[][] moves = { { 4, 2 }, { 3, 2 }, { 2, 3 }, { 5, 2 }, { 3, 1 }, { 5, 4 }, { 5, 5 }, { 5, 6 }, { 6, 2 },
            { 6, 1 }, { 2, 4 }, { 2, 1 }, { 2, 2 }, { 7, 2 }, { 6, 6 }, { 1, 4 }, { 5, 3 }, { 1, 2 }, { 1, 0 },
            { 6, 4 }, { 7, 3 }, { 4, 0 }, { 4, 6 }, { 3, 0 }, { 2, 5 }, { 3, 6 }, { 0, 2 }, { 3, 5 }, { 4, 5 },
            { 6, 5 }, { 2, 6 }, { 2, 7 }, { 7, 6 }, { 0, 3 }, { 5, 1 }, { 0, 1 }, { 2, 0 }, { 6, 0 }, { 1, 1 },
            { 4, 7 }, { 3, 7 }, { 7, 4 }, { 7, 0 }, { 5, 0 }, { 1, 3 }, { 6, 3 }, { 7, 1 }, { 6, 7 }, { 1, 6 },
            { 0, 0 }, { 5, 7 }, { 0, 6 }, { 7, 7 }, { 4, 1 }, { 1, 5 }, { 0, 4 }, { 0, 7 }, { 1, 7 }, { 7, 5 },
            { 0, 5 } };

    @BeforeEach
    public void setUp() throws Exception {
        othello = new Othello();

    }

    @org.junit.jupiter.api.Test
    public void testGetWhosTurn() {

        // Player being skipped more than twice
        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];
            if (x == moves.length - 1) {
                assertEquals(othello.getWhosTurn(), 'X');
            }
            if (x == moves.length - 2) {
                assertEquals(othello.getWhosTurn(), 'X');
            }
            othello.move(move[0], move[1]);
        }

        // whose turn after the game ends
        assertEquals(othello.getWhosTurn(), OthelloBoard.EMPTY);
    }

    @org.junit.jupiter.api.Test
    public void testMove() {

        // Attempt to place on invalid bounds
        assertEquals(othello.move(9, 9), false);
        assertEquals(othello.move(-1, 0), false);
        assertEquals(othello.move(0, -1), false);
        assertEquals(othello.move(-100, -100), false);

        // Attempt to place on filled square
        assertEquals(othello.move(3, 3), false);
        assertEquals(othello.move(3, 4), false);
        assertEquals(othello.move(4, 3), false);
        assertEquals(othello.move(4, 4), false);

        // Attempt to place on invalid empty square
        assertEquals(othello.move(0, 0), false);
        assertEquals(othello.move(7, 7), false);
        assertEquals(othello.move(4, 7), false);
        assertEquals(othello.move(2, 3), false);

        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];
            assertEquals(othello.move(move[0], move[1]), true);
        }
    }

    @org.junit.jupiter.api.Test
    public void testGetCount() {
        assertEquals(othello.getCount('X'), 2);
        assertEquals(othello.getCount('O'), 2);

        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];
            othello.move(move[0], move[1]);

            if (x == 10) {
                assertEquals(othello.getCount('X'), 9);
                assertEquals(othello.getCount('O'), 6);
            }
            if (x == 20) {
                assertEquals(othello.getCount('X'), 10);
                assertEquals(othello.getCount('O'), 15);
            }

            if (x == 30) {
                assertEquals(othello.getCount('X'), 18);
                assertEquals(othello.getCount('O'), 17);
            }
        }
        assertEquals(othello.getCount('X'), 25);
        assertEquals(othello.getCount('O'), 39);
    }

    @org.junit.jupiter.api.Test
    public void testGetWinner() {

        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];

            assertEquals(othello.getWinner(), OthelloBoard.EMPTY);
            othello.move(move[0], move[1]);
        }
        assertEquals(othello.getWinner(), OthelloBoard.P2);
    }

    @org.junit.jupiter.api.Test
    public void isGameOver() {

        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];

            assertEquals(othello.isGameOver(), false);
            othello.move(move[0], move[1]);
        }
        assertEquals(othello.isGameOver(), true);

    }

    @org.junit.jupiter.api.Test
    public void testGetBoardString() {
        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];
            if (x == 20) {
                assertEquals(othello.getBoardString(), """
                          0 1 2 3 4 5 6 7\s
                         +-+-+-+-+-+-+-+-+
                        0| | | | | | | | |0
                         +-+-+-+-+-+-+-+-+
                        1|X| |O| |O| | | |1
                         +-+-+-+-+-+-+-+-+
                        2| |X|O|O|O| | | |2
                         +-+-+-+-+-+-+-+-+
                        3| |X|X|X|O| | | |3
                         +-+-+-+-+-+-+-+-+
                        4| | |O|X|O| | | |4
                         +-+-+-+-+-+-+-+-+
                        5| | |O|O|O|X|O| |5
                         +-+-+-+-+-+-+-+-+
                        6| |O|O| |O| |X| |6
                         +-+-+-+-+-+-+-+-+
                        7| | |O| | | | | |7
                         +-+-+-+-+-+-+-+-+
                          0 1 2 3 4 5 6 7\s
                                                """);
            }

            if (x == 40) {

                assertEquals(othello.getBoardString(), """
                          0 1 2 3 4 5 6 7\s
                         +-+-+-+-+-+-+-+-+
                        0| |O|O|O| | | | |0
                         +-+-+-+-+-+-+-+-+
                        1|X|X|O| |O| | | |1
                         +-+-+-+-+-+-+-+-+
                        2|X|X|X|O|O|O|O|O|2
                         +-+-+-+-+-+-+-+-+
                        3|O|X|O|X|X|X|O| |3
                         +-+-+-+-+-+-+-+-+
                        4|O| |O|X|X|O|O|O|4
                         +-+-+-+-+-+-+-+-+
                        5| |O|X|X|X|O|X| |5
                         +-+-+-+-+-+-+-+-+
                        6|O|O|X| |X|X|X| |6
                         +-+-+-+-+-+-+-+-+
                        7| | |O|X| | |X| |7
                         +-+-+-+-+-+-+-+-+
                          0 1 2 3 4 5 6 7\s
                                                """);
            }
            othello.move(move[0], move[1]);
        }

        assertEquals(othello.getBoardString(), """
                  0 1 2 3 4 5 6 7\s
                 +-+-+-+-+-+-+-+-+
                0|O|O|O|O|O|X|X|X|0
                 +-+-+-+-+-+-+-+-+
                1|O|O|X|O|O|X|O|O|1
                 +-+-+-+-+-+-+-+-+
                2|O|O|O|O|O|X|O|O|2
                 +-+-+-+-+-+-+-+-+
                3|O|O|O|O|O|O|O|X|3
                 +-+-+-+-+-+-+-+-+
                4|O|O|O|X|O|O|O|X|4
                 +-+-+-+-+-+-+-+-+
                5|O|O|O|X|O|X|O|X|5
                 +-+-+-+-+-+-+-+-+
                6|O|O|X|O|X|X|X|X|6
                 +-+-+-+-+-+-+-+-+
                7|X|X|X|X|X|X|X|X|7
                 +-+-+-+-+-+-+-+-+
                  0 1 2 3 4 5 6 7\s
                                """);
    }

    @org.junit.jupiter.api.Test
    public void testCheckPlayerValidMove() {

        Othello newOthello = new Othello();
        assertEquals(othello.checkPlayerValidMove(0, 0, 1, 1, OthelloBoard.P1) == -1, true);
        assertEquals(newOthello.getBoardString(), othello.getBoardString());

        assertEquals(othello.checkPlayerValidMove(2, 4, 1, 0, OthelloBoard.P1) == 2, true);
        assertEquals(newOthello.getBoardString(), othello.getBoardString());
        String previous;

        for (int x = 0; x < moves.length; x++) {
            int[] move = moves[x];
            previous = othello.getBoardString();
            if (x == 10) {
                assertEquals(othello.checkPlayerValidMove(move[0], move[1], 1, 0, OthelloBoard.P1) == 2, true);
                assertEquals(previous, othello.getBoardString());
            }
            if (x == 20) {
                assertEquals(othello.checkPlayerValidMove(move[0], move[1], 1, 0, OthelloBoard.P1) == 2, false);
                assertEquals(previous, othello.getBoardString());
            }
            if (x == 30) {
                assertEquals(othello.checkPlayerValidMove(move[0], move[1], 1, 0, OthelloBoard.P1) == 2, true);
                assertEquals(previous, othello.getBoardString());
            }

            othello.move(move[0], move[1]);
        }

    }

}
