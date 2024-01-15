import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TestInit {
    Common common = new Common();
    @Rule
    public TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
        common.gameFieldInit();

    }
    @Test
    public void gameFieldArrayNotNullTest() {
        Assert.assertNotNull(common.gameFieldArray);
    }
    @Test
    public void gameFieldArrayElementsAreEmptySpacesTest() {
        for (int i = 0; i < common.gameFieldArray.length; i++) {
            for (int j = 0; j < common.gameFieldArray[i].length; j++) {
                Assert.assertEquals(common.gameFieldArray[i][j], ' ');
            }
        }
    }
    @Test
    public void gameFieldArrayColumnsLengthTest() {
        Assert.assertEquals(common.gameFieldArray.length, 3);
    }

    @Test
    public void gameFieldArrayRowsLengthTest() {
        for (int i = 0; i < common.gameFieldArray.length; i++) {
            Assert.assertEquals(Common.gameFieldArray[i].length, 3);
        }
    }
    @Test
    public void gameFieldDisplayedCorrectlyTest() {
        Assert.assertEquals("  1 2 3 \n" +
                "1       \n" +
                "2       \n" +
                "3       \n", output.toString());
    }
}

