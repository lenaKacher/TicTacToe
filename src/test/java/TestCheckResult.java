import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TestCheckResult {
    CheckResults checkResults = new CheckResults();
    Moves moves = new Moves();
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void victoryOHorizontalPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', ' ', 'X'},
                {' ', 'X', ' '},
                {'0', '0', '0'}};
        checkResults.checkDraw('0');
        Assert.assertEquals("Game over. X is a winner!", output.toString());
    }

    @Test
    public void victoryOVerticalPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', ' ', '0'},
                {' ', 'X', '0'},
                {'X', ' ', '0'}};
        checkResults.checkDraw('0');
        Assert.assertEquals("Game over. 0 is a winner!", output.toString());
    }

    @Test
    public void victoryODiagonalUpToDownPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'0', ' ', ' '},
                {'X', '0', 'X'},
                {'X', ' ', '0'}};
        checkResults.checkDraw('0');
        Assert.assertEquals("Game over. 0 is a winner!", output.toString());
    }

    @Test
    public void victoryODiagonalDownToUpPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', ' ', '0'},
                {'X', '0', 'X'},
                {'0', ' ', ' '}};
        checkResults.checkDraw('0');
        Assert.assertEquals("Game over. 0 is a winner!", output.toString());
    }

    @Test
    public void victoryXHorizontalPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {' ', '0', 'X'},
                {'X', 'X', 'X'},
                {'0', ' ', '0'}};
        checkResults.checkDraw('X');
        Assert.assertEquals("Game over. X is a winner!", output.toString());
    }

    @Test
    public void victoryXVerticalPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {' ', 'X', '0'},
                {'0', 'X', ' '},
                {'X', 'X', '0'}};
        checkResults.checkDraw('X');
        Assert.assertEquals("Game over. X is a winner!", output.toString());
    }

    @Test
    public void victoryXDiagonalUpToDownPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', '0', ' '},
                {'0', 'X', ' '},
                {' ', ' ', 'X'}};
        checkResults.checkDraw('X');
        Assert.assertEquals("Game over. X is a winner!", output.toString());
    }

    @Test
    public void victoryXDiagonalDownToUpPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'0', ' ', 'X'},
                {'0', 'X', ' '},
                {'X', ' ', ' '}};
        checkResults.checkDraw('X');
        Assert.assertEquals("Game over. X is a winner!", output.toString());
    }

    @Test
    public void checkDrawForXPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', '0', '0'},
                {'0', 'X', 'X'},
                {'X', '0', '0'}};
        checkResults.checkDraw('X');
        Assert.assertEquals("Game over. A draw", output.toString());
    }

    @Test
    public void checkDrawForOPositiveTest() {
        Common.gameFieldArray = new char[][]{
                {'X', '0', 'X'},
                {'0', 'X', '0'},
                {'X', '0', '0'}};
        checkResults.checkDraw('0');
        Assert.assertEquals("Game over. A draw", output.toString());
    }

    @Test
    public void checkVictoryXAfterLastMovePositiveTest() {
        systemInMock.provideText("2\n1\n");
        Common.gameFieldArray = new char[][]{
                {'X', ' ', 'X'},
                {'0', 'X', '0'},
                {'X', '0', '0'}};
        moves.humanMove();
        checkResults.checkDraw('X');
        Assert.assertEquals("Now it's a human's move. Input coordinates X Y (from 1 to 3): Game over. X is a winner!", output.toString());
    }

    @Test
    public void checkDrawAfterLastMoveXPositiveTest() {
        systemInMock.provideText("2\n1\n");
        Common.gameFieldArray = new char[][]{
                {'X', ' ', '0'},
                {'0', 'X', 'X'},
                {'X', '0', '0'}};
        moves.humanMove();
        checkResults.checkDraw('X');
        Assert.assertEquals("Now it's a human's move. Input coordinates X Y (from 1 to 3): Game over. A draw", output.toString());
    }
}