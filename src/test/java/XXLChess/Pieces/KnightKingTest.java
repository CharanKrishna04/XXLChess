package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class KnightKingTest {

//    @Mock
    private PImage mockPieceSprite;

    private KnightKing knightKingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
//        initMocks(this);
        knightKingUnderTest = new KnightKing(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testGetAvailableMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = knightKingUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
