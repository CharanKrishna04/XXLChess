package XXLChess.Pieces;

import XXLChess.App;
import XXLChess.PieceColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import processing.core.PImage;

import java.util.ArrayList;

//import static org.mockito.MockitoAnnotations.initMocks;

class KnightTest {

//    @Mock
    private PImage mockPieceSprite;

    private Knight knightUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        knightUnderTest = new Knight(PieceColour.white, mockPieceSprite, 0, 0);
    }

    @Test
    void testGetAvailableMoves() {
        // Setup
        final App app = new App();

        // Run the test
        final ArrayList<int[]> result = knightUnderTest.getAvailableMoves(app);

        // Verify the results
    }
}
