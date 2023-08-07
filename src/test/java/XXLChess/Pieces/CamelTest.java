package XXLChess.Pieces;

import static org.junit.jupiter.api.Assertions.fail;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.*;
import processing.core.PImage;

import java.util.ArrayList;

public class CamelTest {

    @BeforeAll
    static void initAll() {
    }
    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("get Available Moves")
    public void getAvailableMoves(){
        try {

            ArrayList<int[]> expectedValue = null;
            App app = null;

            PieceColour colourc = null;
            PImage pieceSpritec = null;
            int xc=0;
            int yc=0;

            Camel camel  =new Camel( colourc ,pieceSpritec ,xc ,yc);
            ArrayList<int[]> actualValue=camel.getAvailableMoves( app);
            System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
            Assertions.assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }
    @AfterEach
    void tearDown() {
    }
    @AfterAll
    static void tearDownAll() {
    }
}
