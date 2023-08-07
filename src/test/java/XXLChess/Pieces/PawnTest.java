package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.mockito.MockitoAnnotations.initMocks;

class PawnTest {

//    @Mock
    private PImage mockPieceSprite;

    private Pawn pawnUnderTest;

    @BeforeEach
    void setUp() throws Exception {
//        initMocks(this);
        pawnUnderTest = new Pawn(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testMove() {
        // Setup
        final App app = new App();

        // Run the test
        pawnUnderTest.move(app, 0, 0);

        // Verify the results
    }

    @Test
    void testGetAvailableMoves() throws Exception {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = pawnUnderTest.getAvailableMoves(app);

        // Verify the results
    }
    @Test
    void testGetAvailableMoves3() {
        Rook rook = new Rook(PieceColour.white, new PImage(1, 1), Integer.MIN_VALUE, 3);
        assertTrue(rook.getAvailableMoves(new App()).isEmpty());
    }

}
