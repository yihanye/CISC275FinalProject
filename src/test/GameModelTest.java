package test;

import org.junit.*;

import model.*;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameModelTest {

    @Test
    public void gameModelTest() {
        GameModel gameModelTest = new GameModel();
        
        assertEquals(BlueFish.createBFList(), gameModelTest.getBlueFishList());
    }
}
