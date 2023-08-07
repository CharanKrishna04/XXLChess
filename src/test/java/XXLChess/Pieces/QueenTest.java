package XXLChess.Pieces;//package XXLChess.Pieces;
//
//import XXLChess.App;
//import XXLChess.PieceColour;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import processing.core.PImage;
//
//import java.util.ArrayList;
//
//
//class QueenTest {
//
//
//    private PImage mockPieceSprite;
//
//    private Queen queenUnderTest;
//
//    @BeforeEach
//    void setUp() throws Exception {
//
//        queenUnderTest = new Queen(PieceColour.white, mockPieceSprite, 0, 0);
//    }
//
//    @Test
//    void testGetAvailableMoves() throws Exception {
//        // Setup
//        final App app = new App();
//
//        // Run the test
//        final ArrayList<int[]> result = queenUnderTest.getAvailableMoves(app);
//
//        // Verify the results
//    }
//}


import XXLChess.App;
import XXLChess.PieceColour;
import XXLChess.Pieces.Queen;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.core.PImage;

import java.util.ArrayList;

public class QueenTest {

    /**
     * Method under test: {@link Queen#Queen(PieceColour, PImage, int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {

        PieceColour colour = PieceColour.white;
        PImage pieceSprite = null;
        int x = 0;
        int y = 0;

        // Act
        Queen actualQueen = new Queen(colour, pieceSprite, x, y);

        // Assert
        // TODO: Add assertions on result
//    }

//    @Test
//    @DisplayName("get Available Moves")
//    public void getAvailableMoves() {
//        try {
//
//            ArrayList<int[]> expectedValue = null;
//            App app = null;
//
//            PieceColour colourc = null;
//            PImage pieceSpritec = null;
//            int xc = 0;
//            int yc = 0;
//
//            Queen queen = new Queen(colourc, pieceSpritec, xc, yc);
//            ArrayList<int[]> actualValue = queen.getAvailableMoves(app);
//
//            Assertions.assertEquals(expectedValue, actualValue);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            Assertions.assertFalse(false);
//        }
    }

//    @Test
//    @Disabled("TODO: Complete this test")
//    void testGetAvailableMoves() {
//
//
//        Queen queen = new Queen(PieceColour.white, new PImage(1, 1), 2, 3);
//        queen.getAvailableMoves(new App());
//    }

    /**
     * Method under test: {@link Queen#getAvailableMoves(App)}
     */
    @Test
    void testGetAvailableMoves() {
        Queen queen = new Queen(PieceColour.white, new PImage(1, 1), Integer.MIN_VALUE, 3);
        assertTrue(queen.getAvailableMoves(new App()).isEmpty());
    }
}
