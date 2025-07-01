package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MyMoveTest {

    Move move;
    Move move2;

    @BeforeEach
    void setUp() {
        move = new Move(-1, -2);
        move2 = new Move(0, 0);
    }

    @org.junit.jupiter.api.Test
    void getRow() {
        assertEquals(-1, move.getRow(), "getRow");
        assertEquals(0, move2.getRow(), "getRow");
    }

    @org.junit.jupiter.api.Test
    void getCol() {
        assertEquals(-2, move.getCol(), "getCol");
        assertEquals(0, move2.getCol(), "getCol");
    }

    @org.junit.jupiter.api.Test
    void testToString1() {
        assertEquals("(-1,-2)", move.toString(), "toString");
        assertEquals("(0,0)", move2.toString(), "toString");
    }
}
