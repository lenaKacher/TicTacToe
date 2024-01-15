import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.*;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TestMoves extends Assert {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    Moves moves = new Moves();
    @Before
    public void setUp() {
        Common.gameFieldArray = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
    }

    @Test
    public void humanMoveRightPositionEmptyFieldPositiveTest() {
        systemInMock.provideText("2\n2\n");
        moves.humanMove();
        char expRes = 'X';
        char actualRes = Common.gameFieldArray[1][1];
        assertEquals(expRes, actualRes);
    }

    @Test
    public void humanOnlyOneMoveEmptyFieldPositivTest() {
        systemInMock.provideText("2\n2\n");
        moves.humanMove();
        int actualRes = amountMoves(Common.gameFieldArray, 'X');
        assertEquals(1, actualRes);
    }

    @Test
    public void humanMoveRightPositionDefinedFieldPositivTest() {
        systemInMock.provideText("1\n1\n");
        Common.gameFieldArray = new char[][]{
                {' ', 'X', ' '},
                {'O', ' ', 'O'},
                {'X', 'X', 'O'}};
        moves.humanMove();
        char expRes = 'X';
        char actualRes = Common.gameFieldArray[0][0];
        assertEquals(expRes, actualRes);
    }

    @Test
    public void humanOnlyOneMoveDefinedFieldPositivTest() {
        systemInMock.provideText("1\n1\n");
        Common.gameFieldArray = new char[][]{
                {' ', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'X', 'O'}};
        moves.humanMove();
        int actualRes = amountMoves(Common.gameFieldArray, 'X');
        assertEquals(3, actualRes);
    }

    @Test
    public void computerOnlyOneMoveEmptyFieldPositiveTest() {
        moves.compMove();
        int actualRes = amountMoves(Common.gameFieldArray, '0');
        assertEquals(1, actualRes);
    }

    @Test
    public void computerOnlyOneMoveDefinedFieldPositivTest() {
        Common.gameFieldArray = new char[][]{
                {'X', 'X', ' '},
                {'0', ' ', '0'},
                {' ', 'X', '0'}};
        moves.compMove();
        int actualRes = amountMoves(Common.gameFieldArray, '0');
        assertEquals(4, actualRes);
    }
    public int amountMoves(char[][] arr, char player) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == player) {
                    count++;
                }
            }
        }
        return count;
    }
//    @Test
//    public void testHumanMoveOutOfRangeNegativ() {
//        systemInMock.provideText("6\n6\n");
//
//        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
//            moves.humanMove();
//        });
//        assertNotNull(thrown.getMessage());
//    }
}
